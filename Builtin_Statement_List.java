import java.util.Scanner;

/**This is a hack to handle the (currently two) functions that must be
   built into the language for it to be able to do I/O.

   The lexer and parser know nothing about this subclass and will
   never generate nodes of this type.  The way it works is the
   Interpreter constructor creates functions in the global symbol
   table of this type, and these symbols get looked up and visited
   when these symbols are called as functions.*/
public class Builtin_Statement_List extends Statement_List
{
     public int stream;
     public Scanner s;

     public Builtin_Statement_List(int stream_)
          {
               stream = stream_;
               if(stream==0)
                    s = new Scanner(System.in);
          }

     public void visit_with(Visitor v) { v.visit(this); }
}
