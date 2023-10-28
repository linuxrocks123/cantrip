/**An expression consisting of a single identifier.

   When you recursively drill an expression down to its smallest
   components, those components will all be either Identifiers or
   literal constants.

   The literal constants are represented in the AST as Values.
*/
public class Identifier extends Expression
{
     public String name;

     public Identifier(String name_) { name = name_; }

     public void visit_with(Visitor v) { v.visit(this); }
}
