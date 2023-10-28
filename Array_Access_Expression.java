///something[something]
public class Array_Access_Expression extends Expression
{
     Expression outer;
     Expression inner;

     public Array_Access_Expression(Expression outer_, Expression inner_)
          {
               outer = outer_;
               inner = inner_;
          }

     public void visit_with(Visitor v) { v.visit(this); }
}
