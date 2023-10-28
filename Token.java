/**This class is scaffolding: it represents the absence of a semantic
   value and should never appear in a finished parse tree.
*/
public class Token extends ASTNode
{
     ///Since we should never appear in a parse tree, it is an error to visit us.
     public void visit_with(Visitor v) { assert false; }
}
