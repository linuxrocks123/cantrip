///A while statement, containing a condition and a body
public class While_Statement extends Statement
{
     /**The expression used as the continuation condition for the loop.
        Note: there's no boolean type in Cantrip.  0 is false, and
        anything else is true.*/
     public Expression condition;
     public Statement_List body; ///<the statements in the loop's body
     
     public void visit_with(Visitor v) { v.visit(this); }
}
