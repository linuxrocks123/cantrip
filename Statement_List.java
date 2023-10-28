import java.util.ArrayList;

/**A list of Statements.

   Statement_Lists form the bodies of lambdas, loops, if statements,
   and the program as a whole.
*/
public class Statement_List extends ASTNode
{
     public ArrayList<Statement> statements;

     public Statement_List() { statements = new ArrayList<Statement>(); }

     public void visit_with(Visitor v) { v.visit(this); }
}
