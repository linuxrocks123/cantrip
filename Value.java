import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**Represents a single value of some kind.

   Objects of this type are used:
   - To represent literal constants in the AST
     (Identifiers are used for variable references).
   - To represent the current value of a variable in the symbol table.
*/
public class Value extends Expression
{
     ///What type of value is this?
     public Type type;

     ///Is this a literal constant from the AST?
     public boolean is_literal;

     //Possible values; only one of these is ever used at a time.
     //The one that is currently in use is the one indicated by type.
     public int int_value;
     public double float_value;
     public Value[] array_value;
     public TreeMap<String,Value> ag_value;
     public Function func_value;

     ///Note: this has the semantics of Cantrip's clone function:
     ///      a one-level-deep copy
     public Value(Value to_copy)
          {
               type = to_copy.type;
               is_literal = false;
               int_value = to_copy.int_value;
               float_value = to_copy.float_value;
               if(to_copy.array_value!=null)
                    array_value = Arrays.copyOf(to_copy.array_value,to_copy.array_value.length);
               if(type==Type.AGGREGATE || to_copy.ag_value!=null)
                    ag_value = new TreeMap<String,Value>();
               if(to_copy.ag_value!=null)
                    for(Iterator<Map.Entry<String,Value>> it = to_copy.ag_value.entrySet().iterator(); it.hasNext();)
                    {
                         Map.Entry<String,Value> kv = it.next();
                         
                         Value cv = kv.getValue();
                         Value nv = new Value();
                         nv.type = cv.type;
                         assert(!cv.is_literal);
                         nv.int_value = cv.int_value;
                         nv.float_value = cv.float_value;
                         nv.array_value = cv.array_value;
                         nv.ag_value = cv.ag_value;
                         nv.func_value = cv.func_value;
                         
                         ag_value.put(kv.getKey(),nv);
                    }
               func_value = to_copy.func_value;
          }
               

     public Value() { }
     
     public void visit_with(Visitor v) { v.visit(this); }
}
