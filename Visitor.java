/**The abstract class representing a Visitor.

   The Visitor Pattern is a general programming strategy for handling
   complex tree structures with heterogeneous node types.

   In this case, there is a visit() overload for every possible node
   type that may appear in the AST.  A class inheriting from Visitor
   must implement all of these overloads.  The bodies of the overloads
   will call child.visit_with(this) in order to call the appropriate
   visit overload for whatever child type is being visited.

   Why have the visit_with function?  It's a little ugly to have the
   exact same code copy-pasted into every single subclass of AST_Node,
   no?  Well, consider that the exact type of a child node may not be
   known until runtime.  For example, the Statement class has a bunch
   of subclasses for the different types of Statements in Cantrip,
   and the Interpreter visitor fpr a Statement_List just calls
   s.visit_with(this) for each statement s in the list, top-to-bottom,
   trusting that the visit() overload that ultimately gets called will
   be the right one for whatever particular type of statement s
   happens to be at runtime.

   But, in Java, overload resolution is performed at compile-time.  If
   the Interpreter visit implementation for Statement_List just said
   visit(s) for each statement in the list, Java would try to find a
   visit overload in Interpreter for the type Statement at compile
   time.

   If it found one, that's the function that would get called at
   runtime, which isn't what we want.  If it didn't find one, the code
   would not compile, which also isn't what we want.

   What we want is the _RUNTIME_ type of s -- not the _COMPILE-TIME_
   type of s -- to determine which overload of visit() gets called,
   but that's just not how Java works, so we can't get that.  What
   Java _DOES_ support is subtype polymorphic dynamic dispatch,
   meaning that we can use the runtime type of a variable to choose
   which _OVERRIDE_ of a function gets called.

   So we use that to get what we want.  class AST_Node has an abstract
   visit_with(Visitor v) method that each non-abstract AST_Node
   subtype implements in exactly the same way, which is just to call
   v.visit(this).  Since every non-abstract subclass of AST_Node has a
   visit_with implementation, the static type of this will always be
   the same as the runtime type of this, so the right overload of
   visit in the Visitor v will get called.

   That's the story, and that's also the story of why this class even
   exists at all: the visit_with method in AST_Node needs a type to
   take; that type needs to have visit() overloads for every single
   non-abstract subclass of AST_Node; and, those methods should be
   abstract so that we can implement multiple visitors that process or
   analyze the AST in completely different ways if we want to:
   remember, not every Visitor will be an interpreter!  AST visitors
   could be compilers, type checkers, or a lot of other things, too.

   We exist to be that type.
*/
public abstract class Visitor
{
     public abstract void visit(Aggregate_Access_Expression e);
     public abstract void visit(Array_Access_Expression e);
     public abstract void visit(Binary_Expression e);
     public abstract void visit(Expression_Statement e);
     public abstract void visit(Function_Call_Expression e);
     public abstract void visit(Identifier e);
     public abstract void visit(If_Statement e);
     public abstract void visit(Statement_List e);
     public abstract void visit(Unary_Expression e);
     public abstract void visit(Value e);
     public abstract void visit(While_Statement e);

     public abstract void visit(Builtin_Statement_List e);
}
