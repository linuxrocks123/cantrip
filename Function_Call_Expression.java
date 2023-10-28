import java.util.ArrayList;

/**A function call.
   Note that, in Cantrip, all function calls are expressions.
*/
public class Function_Call_Expression extends Expression
{
     public Expression called_function;
     public ArrayList<Expression> actual_parameters;

     public Function_Call_Expression(Expression cf, ArrayList<Expression> ap)
          {
               called_function = cf;
               actual_parameters = ap;
          }

     public void visit_with(Visitor v) { v.visit(this); }
}
