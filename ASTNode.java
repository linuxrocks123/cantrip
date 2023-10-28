///Superclass of everything that can be in the AST
public abstract class ASTNode
{
     public abstract void visit_with(Visitor v);
}
