///Unary expressions: either arithmetic (-) or logical (!) negation.
public class Unary_Expression extends Expression
{
     public int operator;
     public Expression right;

     public Unary_Expression(int op_, Expression right_)
          {
               operator = op_;
               right = right_;
          }

     public void visit_with(Visitor v) { v.visit(this); }
}
