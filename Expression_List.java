import java.util.ArrayList;
/**Represents a comma-separated list of Expressions.

   This node gets merged into Function_Call_Expression by the parser
   during the construction of the completed AST, so it should never be
   seen in a completed AST, and thus should never be visited.
*/
public class Expression_List extends ASTNode
{
     public ArrayList<Expression> value;

     public Expression_List() { value = new ArrayList<Expression>(); }

     ///Scaffolding: should never appear in finished AST
     public void visit_with(Visitor v) { assert false; }
}
