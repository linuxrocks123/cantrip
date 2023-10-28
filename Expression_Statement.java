/**An expression used as a statement.

   Typically this will be a function call or an assignment expression,
   but the language allows any expression to be used as a statement.*/
public class Expression_Statement extends Statement
{
     Expression root_expr;
     
     public void visit_with(Visitor v) { v.visit(this); }
}
