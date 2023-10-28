import java.util.ArrayList;
import java.util.TreeMap;
public class Interpreter extends Visitor
{
     ///The symbol table
     private ArrayList<TreeMap<String,Value>> symbol_table;

     ///"Return" values for the visitor methods
     private Value cur_value; ///<primary one
     private Value[] cur_ary;
     private int cur_ary_idx;
     private TreeMap<String,Value> cur_map; ///<only used by idents and ag_access
     private String cur_str; ///<only used by idents and ag_access

     ///Initialize symbol table only: everything else starts null
     public Interpreter()
          {
               symbol_table = new ArrayList<TreeMap<String,Value>>();

               TreeMap<String,Value> global_symbols = new TreeMap<String,Value>();
               Value v = new Value();
               v.type = Type.FUNCTION;
               v.func_value = new Function();
               v.func_value.formal_parameters = new ArrayList<Parameter>();
               Parameter p = new Parameter();
               p.name = "__BOLVANGAR_BUILTIN_PRINT__";
               p.is_reference = true;
               v.func_value.formal_parameters.add(p);
               v.func_value.body = new Builtin_Statement_List(1);
               global_symbols.put("print",v);

               v = new Value();
               v.type = Type.FUNCTION;
               v.func_value = new Function();
               v.func_value.formal_parameters = new ArrayList<Parameter>();
               v.func_value.body = new Builtin_Statement_List(0);
               global_symbols.put("read_line",v);
               
               symbol_table.add(global_symbols);
          }
     
     public static void error_out(String message)
          {
               System.err.println(message);
               System.exit(1);
          }
     
     public void visit(Aggregate_Access_Expression e)
          {
               //Handle left-hand expression
               e.left.visit_with(this);
               Value left_value = cur_value;

               //If our left-hand expression is neither an aggregate
               //nor an array length call, runtime error.
               if(left_value.type==Type.ARRAY && e.right.equals("length"))
               {
                    cur_value = new Value();
                    cur_value.type = Type.INTEGER;
                    cur_value.int_value = left_value.array_value.length;
                    return;
               }
               else if(left_value.type!=Type.AGGREGATE)
                    error_out("Non-aggregate on left hand side of aggregate access.");

               //The value of our expression is the value of the right-hand side
               cur_value = left_value.ag_value.get(e.right);
               cur_str = e.right;
               cur_map = left_value.ag_value;
               cur_ary = null;
               if(cur_value==null)
               {
                    cur_value = new Value();
                    cur_map.put(cur_str,cur_value);
               }
          }

     public void visit(Array_Access_Expression e)
          {
               //If there's no outer expression, that means create a new array
               if(e.outer==null)
               {
                    //Visit the existing inner value expression
                    e.inner.visit_with(this);
                    Value inner_value = cur_value;
                    if(inner_value.type!=Type.INTEGER)
                         error_out("Attempted to create an array with a non-integer argument.");

                    //Do the creation
                    cur_value = new Value();
                    cur_value.type = Type.ARRAY;
                    cur_value.is_literal = true;
                    cur_value.array_value = new Value[inner_value.int_value];

                    //Create each interior element
                    for(int i=0; i<inner_value.int_value; i++)
                         cur_value.array_value[i] = new Value();

                    return;
               }
               
               //Visit the expression on the left of the []
               e.outer.visit_with(this);
               Value outer_value = cur_value;

               //Visit the expression inside the []
               e.inner.visit_with(this);
               Value inner_value = cur_value;

               //Raw array?
               if(outer_value.type==Type.ARRAY)
               {
                    if(inner_value.type!=Type.INTEGER)
                         error_out("Attempted to access an array with a non-integer.");
                    cur_value = outer_value.array_value[inner_value.int_value];
                    cur_ary = outer_value.array_value;
                    cur_ary_idx = inner_value.int_value;

                    //For arrays, no cur_str or cur_map
                    cur_str = null;
                    cur_map = null;
               }
               else if(outer_value.type==Type.AGGREGATE && outer_value.ag_value.containsKey("index")) //Aggregate implementing index()
                    operator_overload_helper(outer_value,inner_value,"index");
               else
                    error_out("Invalid array access!");
          }

     ///Precondition: left hand is an aggregate
     ///Postcondition: cur_value is evaluated operator call
     private void operator_overload_helper(Value left_hand, Value right_hand, String op)
          {
               if(!left_hand.ag_value.containsKey(op))
                    error_out("Invalid left-hand aggregate for binary expression operator "+op);
               
               ArrayList<Expression> param_list = new ArrayList<Expression>();
               param_list.add(left_hand);
               param_list.add(right_hand);
               Function_Call_Expression fe = new Function_Call_Expression(left_hand.ag_value.get(op),param_list);
               fe.visit_with(this);
          }

     private static Value copy_if_literal(Value v)
          {
               Value to_return = v;
               if(v.is_literal)
                    to_return = new Value(v);
               return to_return;
          }

     ///Handle = and #= operators.
     ///They're very special because they are the only operators to update the symbol table.
     ///Left hand side should be an lvalue, but we don't check.
     private void handle_assignment(Binary_Expression e)
          {
               //For static variables, only do anything first time through
               if(e.is_static && e.is_static_visited)
                    return;
               else if(e.is_static)
                    e.is_static_visited = true;
               
               //First, evaluate RHS to get value to assign to LHS
               e.right.visit_with(this);
               Value rhs = cur_value;

               //Now, evaluate LHS to get the thing we're assigning to
               e.left.visit_with(this);
               Value lhs = cur_value;

               //It's illegal to assign to a literal (i.e. 3 = 5)
               if(lhs.is_literal)
                    error_out("Attempted to assign to a literal.");
               
               //For #=, just copy the reference over, unless RHS is literal.
               if(e.operator==Cantrip.Lexer.REF_ASSN)
               {
                    //Error out if LHS invalid
                    if(cur_map==null && cur_ary==null)
                         error_out("Attempted to assign to an r-value.");

                    if(cur_map!=null)
                         cur_map.put(cur_str,(cur_value = copy_if_literal(rhs)));
                    else //cur_ary!=null
                         cur_ary[cur_ary_idx] = (cur_value = copy_if_literal(rhs));
                    
                    cur_str = null;
                    cur_map = null;
               }
               else
                    //For =, if left-hand side is an aggregate, first look for an overload
                    if(lhs.type==Type.AGGREGATE && lhs.ag_value.containsKey("assign"))
                         operator_overload_helper(lhs,rhs,"assign"); //that's it then
                    else //If no overload found or left-hand side isn't an aggregate, invoke clone().
                    {
                         if(cur_map==null && cur_ary==null)
                              error_out("Attempted to assign to an r-value.");
                         
                         //Clone does a one-level-deep copy of the right value and makes it the left value
                         if(cur_map!=null)
                              cur_map.put(cur_str,new Value(rhs));
                         else
                              cur_ary[cur_ary_idx] = new Value(rhs);
                         
                         cur_str = null;
                         cur_map = null;
                         cur_ary = null;
                    }
          }

     private void process_primitives_operator(Value left, Value right, int op)
          {
               //Create result value and deal with type promotion rules
               Value result = new Value();
               result.type = left.type;
               if(left.type==Type.CHARACTER && right.type!=Type.CHARACTER || //type promotion
                  left.type==Type.INTEGER && right.type==Type.FLOAT)
                    result.type = right.type;

               if(result.type==Type.FLOAT && left.type!=Type.FLOAT)
                    result.float_value = do_operator(left.int_value,right.float_value,op);
               else if(result.type==Type.FLOAT && right.type!=Type.FLOAT)
                    result.float_value = do_operator(left.float_value,right.int_value,op);
               else if(result.type==Type.FLOAT)
                    result.float_value = do_operator(left.float_value,right.float_value,op);
               else
                    result.int_value = do_operator(left.int_value,right.int_value,op);

               //Make sure boolean operators don't evaluate to a float type
               if(op!='+' && op!='-' && op!='*' && op!='/' && op!='%')
                    if(result.type==Type.FLOAT)
                    {
                         result.type = Type.INTEGER;
                         result.int_value = (int)(result.float_value);
                    }

               cur_value = result;
          }
     
     public void visit(Binary_Expression e)
          {
               //Special-case assignment and ref-assignment operators
               if(e.operator=='=' || e.operator==Cantrip.Lexer.REF_ASSN)
               {
                    handle_assignment(e);
                    return;
               }
               
               //Visit left position
               e.left.visit_with(this);
               Value left_value = cur_value;

               //Short-circuit for && and ||
               if(e.operator==Cantrip.Lexer.AND && left_value.int_value==0)
                    return;
               else if(e.operator==Cantrip.Lexer.OR && left_value.int_value!=0)
                    return;

               //Visit right position
               e.right.visit_with(this);
               Value right_value = cur_value;

               //If we're not a number or aggregate, error out
               if(left_value.type!=Type.CHARACTER && left_value.type!=Type.INTEGER &&
                  left_value.type!=Type.FLOAT && left_value.type!=Type.AGGREGATE)
                    error_out("Invalid left-hand side for binary expression operator "+e.operator);

               //Handle operator overloading
               if(left_value.type==Type.AGGREGATE)
               {
                    String op_name = "";
                    switch(e.operator)
                    {
                    case '+': op_name = "add"; break;
                    case '-': op_name = "subtract"; break;
                    case '*': op_name = "multiply"; break;
                    case '/': op_name = "divide"; break;
                    case '%': op_name = "modulo"; break;
                    case Cantrip.Lexer.EQUALS: op_name = "equals"; break;
                    case Cantrip.Lexer.NOT_EQUALS:
                         operator_overload_helper(left_value,right_value,"equals");
                         cur_value.int_value = cur_value.int_value==0 ? 1 : 0;
                         break;
                    case '<': op_name = "lt"; break;
                    case Cantrip.Lexer.LT_EQUALS:
                         operator_overload_helper(left_value,right_value,"lt");
                         if(cur_value.int_value==0)
                              operator_overload_helper(left_value,right_value,"equals");
                         break;
                    case Cantrip.Lexer.GT_EQUALS:
                         operator_overload_helper(left_value,right_value,"lt");
                         cur_value.int_value = cur_value.int_value==0 ? 1 : 0;
                         break;
                    case '>':
                         operator_overload_helper(left_value,right_value,"lt");
                         cur_value.int_value = cur_value.int_value==0 ? 1 : 0;
                         if(cur_value.int_value==1)
                         {
                              operator_overload_helper(left_value,right_value,"equals");
                              cur_value.int_value = cur_value.int_value==0 ? 1 : 0;
                         }
                         break;
                    default: error_out("Invalid binary operator used with left-hand aggregate.");
                    }

                    operator_overload_helper(left_value,right_value,op_name);
               }
               else
                    process_primitives_operator(left_value,right_value,e.operator);
          }

     public void visit(Expression_Statement es)
          {
               es.root_expr.visit_with(this);
          }

     public void visit(Function_Call_Expression e)
          {
               //Evaluate left-hand side for called function
               e.called_function.visit_with(this);

               //Make sure it's a function, set local var to it
               if(cur_value.type!=Type.FUNCTION)
                    error_out("Tried to call non-function.");
               Function called_function = cur_value.func_value;
               
               //This will be the new level of the symbol table
               TreeMap<String,Value> new_local_scope = new TreeMap<String,Value>();

               //Reference to formal parameter list, for convenience
               ArrayList<Parameter> formal_parameters = called_function.formal_parameters;

               /*Visit each actual parameter of the function and
                 add it to the new scope with the formal parameter's name.*/
               for(int i=0; i < e.actual_parameters.size(); i++)
               {
                    Parameter fp = formal_parameters.get(i);                   
                    e.actual_parameters.get(i).visit_with(this);
                    new_local_scope.put(fp.name,fp.is_reference ? copy_if_literal(cur_value) : new Value(cur_value));
               }

               //Add the actual parameter values with the formal parameter names to the new local scope
               symbol_table.add(new_local_scope);

               //Visit the body of the function
               called_function.body.visit_with(this);

               //Pop local scope of returned function
               symbol_table.remove(symbol_table.size()-1);
          }

     ///Handle identifier lookup
     public void visit(Identifier e)
          {
               int last_idx = symbol_table.size()-1;
               cur_str = e.name;

               //Current symbol table is last one unless variable exists in global one and also not in last one
               if(symbol_table.get(last_idx).containsKey(cur_str) || !symbol_table.get(0).containsKey(cur_str))
                    cur_map = symbol_table.get(last_idx);
               else
                    cur_map = symbol_table.get(0);

               //If necessary, add a new value to the current symbol table with the name of this identifier
               cur_value = cur_map.get(cur_str);
               if(cur_value==null)
               {
                    cur_value = new Value();
                    cur_map.put(cur_str,cur_value);
               }
          }

     public void visit(If_Statement is)
          {
               boolean condition = true; //change to false later if needed
               //Evaluate if condition
               is.condition.visit_with(this);
               switch(cur_value.type)
               {
               case CHARACTER: case INTEGER:
                    if(cur_value.int_value==0)
                         condition = false;
                    break;
               case FLOAT:
                    if(cur_value.float_value==0)
                         condition = false;
                    break;
               default:
                    error_out("Invalid if condition expression: not a char/int/float");
                    break;
               }

               if(condition)
                    is.if_branch.visit_with(this);
               else
                    if(is.else_branch!=null)
                         is.else_branch.visit_with(this);
          }

     public void visit(Statement_List sl)
          {
               //Unconditional, sequential execution.  Trivial.
               for(Statement s : sl.statements)
                    s.visit_with(this);
          }

     public void visit(Unary_Expression ue)
          {
               ue.visit_with(this);
               switch(ue.operator)
               {
               case '-': cur_value.int_value = -cur_value.int_value;
                    cur_value.float_value = -cur_value.float_value;
                    break;
               case '!': cur_value.int_value = cur_value.int_value==0 ? 1 : 0;
                    break;
               }
          }

     public void visit(Value v)
          {
               cur_value = v;
          }

     public void visit(While_Statement ws)
          {
               ws.condition.visit_with(this);
               while(cur_value.type==Type.INTEGER && cur_value.int_value!=0)
               {
                    ws.body.visit_with(this);
                    ws.condition.visit_with(this);
               }
          }

     public void visit(Builtin_Statement_List bsl)
          {
               switch(bsl.stream)
               {
               case 0: String input = bsl.s.nextLine();
                    Value[] values = new Value[input.length()];
                    for(int i=0; i<values.length; i++)
                    {
                         values[i] = new Value();
                         values[i].type = Type.CHARACTER;
                         values[i].int_value = input.charAt(i);
                    }
                    
                    cur_value = new Value();
                    cur_value.type = Type.ARRAY;
                    cur_value.array_value = values;
                    break;

               case 1: (new Identifier("__BOLVANGAR_BUILTIN_PRINT__")).visit_with(this);
                    switch(cur_value.type)
                    {
                    case CHARACTER: System.out.print((char)(cur_value.int_value));
                         break;
                    case INTEGER: System.out.print(cur_value.int_value);
                         break;
                    case FLOAT: System.out.print(cur_value.float_value);
                         break;
                    case ARRAY: for(int i=0; i<cur_value.array_value.length; i++)
                              if(cur_value.array_value[i].type!=Type.CHARACTER)
                                   error_out("Called builtin print with array of something other than characters.");
                              else
                                   System.out.print((char)(cur_value.array_value[i].int_value));
                         break;
                    default: error_out("Called print with invalid value.");
                         break;
                    }
                    break;
               }
          }

     ///These four redundant methods should be a C macro or C++ template.  Java is inadequate.
     private static int do_operator(int x, int y, int op)
          {
               switch(op)
               {
               case '+': return x+y;
               case '-': return x-y;
               case '*': return x*y;
               case '/': return x/y;
               case '%': return x%y;
               case Cantrip.Lexer.EQUALS: return (x==y ? 1 : 0);
               case Cantrip.Lexer.NOT_EQUALS: return (x!=y ? 1 : 0);
               case '<': return (x<y ? 1 : 0);
               case Cantrip.Lexer.LT_EQUALS: return (x<=y ? 1 : 0);
               case Cantrip.Lexer.GT_EQUALS: return (x>=y ? 1 : 0);
               case '>': return (x>y ? 1 : 0);
               case Cantrip.Lexer.AND: return ((x!=0 && y!=0) ? 1 : 0);
               case Cantrip.Lexer.OR: return ((x!=0 || y!=0) ? 1 : 0);
               default: assert false;
               }

               return -1;
          }
     
     ///These four redundant methods should be a C macro or C++ template.  Java is inadequate.
     private static double do_operator(int x, double y, int op)
          {
               switch(op)
               {
               case '+': return x+y;
               case '-': return x-y;
               case '*': return x*y;
               case '/': return x/y;
               case '%': return x%y;
               case Cantrip.Lexer.EQUALS: return (x==y ? 1 : 0);
               case Cantrip.Lexer.NOT_EQUALS: return (x!=y ? 1 : 0);
               case '<': return (x<y ? 1 : 0);
               case Cantrip.Lexer.LT_EQUALS: return (x<=y ? 1 : 0);
               case Cantrip.Lexer.GT_EQUALS: return (x>=y ? 1 : 0);
               case '>': return (x>y ? 1 : 0);
               case Cantrip.Lexer.AND: return ((x!=0 && y!=0) ? 1 : 0);
               case Cantrip.Lexer.OR: return ((x!=0 || y!=0) ? 1 : 0);
               default: assert false;
               }

               return -1;
          }

     ///These four redundant methods should be a C macro or C++ template.  Java is inadequate.
     private static double do_operator(double x, int y, int op)
          {
               switch(op)
               {
               case '+': return x+y;
               case '-': return x-y;
               case '*': return x*y;
               case '/': return x/y;
               case '%': return x%y;
               case Cantrip.Lexer.EQUALS: return (x==y ? 1 : 0);
               case Cantrip.Lexer.NOT_EQUALS: return (x!=y ? 1 : 0);
               case '<': return (x<y ? 1 : 0);
               case Cantrip.Lexer.LT_EQUALS: return (x<=y ? 1 : 0);
               case Cantrip.Lexer.GT_EQUALS: return (x>=y ? 1 : 0);
               case '>': return (x>y ? 1 : 0);
               case Cantrip.Lexer.AND: return ((x!=0 && y!=0) ? 1 : 0);
               case Cantrip.Lexer.OR: return ((x!=0 || y!=0) ? 1 : 0);
               default: assert false;
               }

               return -1;
          }

     ///These four redundant methods should be a C macro or C++ template.  Java is inadequate.
     private static double do_operator(double x, double y, int op)
          {
               switch(op)
               {
               case '+': return x+y;
               case '-': return x-y;
               case '*': return x*y;
               case '/': return x/y;
               case '%': return x%y;
               case Cantrip.Lexer.EQUALS: return (x==y ? 1 : 0);
               case Cantrip.Lexer.NOT_EQUALS: return (x!=y ? 1 : 0);
               case '<': return (x<y ? 1 : 0);
               case Cantrip.Lexer.LT_EQUALS: return (x<=y ? 1 : 0);
               case Cantrip.Lexer.GT_EQUALS: return (x>=y ? 1 : 0);
               case '>': return (x>y ? 1 : 0);
               case Cantrip.Lexer.AND: return ((x!=0 && y!=0) ? 1 : 0);
               case Cantrip.Lexer.OR: return ((x!=0 || y!=0) ? 1 : 0);
               default: assert false;
               }

               return -1;
          }
}
