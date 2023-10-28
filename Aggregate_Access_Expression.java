///Something.something
public class Aggregate_Access_Expression extends Expression
{
     public Expression left;
     public String right;

     public Aggregate_Access_Expression(Expression left_, String right_)
          {
               left = left_;
               right = right_;
          }

     public void visit_with(Visitor v) { v.visit(this); }
}
