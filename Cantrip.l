//Note: In C/C++ Flex, the "user code" section is at the bottom instead.
import java.util.ArrayList;

%%

%public
%implements Cantrip.Lexer
%int

%eofval{
    return EOF;
%eofval}

%{

public ASTNode yylval;
public ASTNode getLVal()
{
    return yylval;
}

//Note: tracking line numbers would be a useful addition.
public void yyerror(String msg)
{
    System.err.println(msg);
}

private static String handle_escapes(String input)
{
     String to_return = "";
     //ignore the beginning and ending quotes
     for(int i=1; i<input.length()-1; i++)
          if(input.charAt(i)!='\\')
               to_return+=input.charAt(i);
          else
          {
               if(i==input.length()-2)
               {
                    System.err.println("Lexer internal error.");
                    break;
               }
               
               i++;
               switch(input.charAt(i))
               {
               case 'n': to_return+='\n';
                    break;
               case 'r': to_return+='\r';
                    break;
               case '\\': to_return+='\\';
                    break;
               case '\t': to_return+='\t';
                    break;
               default: System.err.println("Unsupported escape string.");
                    break;
               }
          }
     return to_return;
}

%}

 /*In C/C++ Flex, you would lose the "=" for these.*/
delim = [ \t\n]
ws = {delim}+
letter = [A-Za-z_]
digit = [0-9]
id = {letter}({letter}|{digit})*
integer = {digit}+
fpoint = {integer}+\.{integer}+

%%

 /*Ignore whitespace*/
{ws} { /*ignore*/ }

 /*Ignore comments (//)*/
\/\/.*\n { /*ignore*/ }

 /*Keywords*/
if { return IF; }
else { return ELSE; }
while { return WHILE; }
lambda { return LAMBDA; }
static { return STATIC; }

 /*Punctuation*/
@ { return '@'; }
\( { return '('; }
\) { return ')'; }
\[ { return '['; }
\] { return ']'; }
\{ { return '{'; }
\} { return '}'; }
; { return ';'; }

 /*Computational Operators*/
== { return EQUALS; }
\!= { return NOT_EQUALS; }
\< { return '<'; }
\<= { return LT_EQUALS; }
\>= { return GT_EQUALS; }
\> { return '>'; }
&& { return AND; }
\|\| { return OR; }
\! { return '!'; }
\+ { return '+'; }
- { return '-'; }
\* { return '*'; }
\/ { return '/'; }
% { return '%'; }

 /*Other Operators*/
= { return '='; }
#= { return REF_ASSN; }
& { return '&'; }
\. { return '.'; }
\, { return ','; }

 /*Handle string, character, integer, and floating point literals*/
 /*String literals (array of chars)*/
\"([^\"]|\\\")*\" { Value v = new Value();
                    v.type = Type.ARRAY;
                    v.is_literal = true;
                    String text = handle_escapes(yytext());
                    Value[] aryvalue = new Value[text.length()];
                    for(int i=0; i<text.length(); i++)
                    {
                         aryvalue[i] = new Value();
                         aryvalue[i].type = Type.CHARACTER;
                         aryvalue[i].is_literal = true;
                         aryvalue[i].int_value = text.charAt(i);
                    }
                    v.array_value = aryvalue;
                    yylval = v;
                    return LITERAL; }

 /*Char literals*/
\'([^\']|\')\' { Value v = new Value();
                 v.type = Type.CHARACTER;
                 v.is_literal = true;
                 v.int_value = handle_escapes(yytext()).charAt(0);
                 yylval = v;
                 return LITERAL; }

 /*Int literals*/
{integer} { Value v = new Value();
            v.type = Type.INTEGER;
            v.is_literal = true;
            v.int_value = Integer.parseInt(yytext());
            yylval = v;
            return LITERAL; }

 /*Floating-point literals*/
{fpoint} { Value v = new Value();
           v.type = Type.FLOAT;
           v.is_literal = true;
           v.float_value = Double.parseDouble(yytext());
           yylval = v;
           return LITERAL; }

 /*Handle identifier*/
{id} { yylval = new Identifier(yytext()); return IDENTIFIER; }
