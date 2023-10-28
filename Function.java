import java.util.ArrayList;

/**The signature and body of a lambda.  Since Cantrip supports
   first-class functions, Values can be of this type.

   AST_Nodes will never be of this type: lambda expressions in the AST
   are of type Value, and the type of the Value is Type.FUNCTION.
*/
public class Function
{
     public ArrayList<Parameter> formal_parameters;
     public Statement_List body;
}
