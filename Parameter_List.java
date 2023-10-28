import java.util.ArrayList;

/**A list of the formal parameters for a lambda expression.

   All nodes of this type are merged into the node for the full lambda
   expression by the parser, so this node type will never be visited.
*/
public class Parameter_List extends ASTNode
{
     public ArrayList<Parameter> parameters;

     public Parameter_List() { parameters = new ArrayList<Parameter>(); }

     ///Scaffolding: should never be visited
     public void visit_with(Visitor v) { assert false; }
}
