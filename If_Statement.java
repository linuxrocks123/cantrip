public class If_Statement extends Statement
{
     public Expression condition;
     public Statement_List if_branch;
     public Statement_List else_branch;
     
     public void visit_with(Visitor v) { v.visit(this); }
}
