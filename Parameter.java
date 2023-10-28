/**A formal parameter of a lambda.

   These nodes get merged into the node for the full lambda expression
   by the parser, so they will never appear in the finished AST and
   thus will never be visited.
*/
public class Parameter extends ASTNode
{
     public String name;
     public boolean is_reference;

     ///Scaffolding: will never appear in the finished AST.
     public void visit_with(Visitor v) { assert false; }
}
