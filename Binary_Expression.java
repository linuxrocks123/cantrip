///something +/-/*/etc. something
public class Binary_Expression extends Expression
{
     public Expression left;
     public int operator;
     public Expression right;

     ///For static variable declarations
     public boolean is_static;
     public boolean is_static_visited;
     
     public Binary_Expression(Expression left_, int op_, Expression right_)
          {
               left = left_;
               operator = op_;
               right = right_;

               is_static = is_static_visited = false;
          }

     ///For static variable declarations
     public Binary_Expression(Expression left_, int op_, Expression right_, String dummy)
          {
               left = left_;
               operator = op_;
               right = right_;

               assert operator=='=' || operator==Cantrip.Lexer.REF_ASSN;

               is_static = true;
               is_static_visited = false;
          }

     public void visit_with(Visitor v) { v.visit(this); }
}
