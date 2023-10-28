/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */




import java.text.MessageFormat;
import java.util.ArrayList;
/* "%code imports" blocks.  */
/* "Cantrip.y":9  */

     import java.io.StreamTokenizer;
     import java.io.ByteArrayInputStream;
     import java.io.InputStream;
     import java.io.InputStreamReader;
     import java.io.Reader;
     import java.io.IOException;
     import java.io.FileInputStream;
     import java.io.File;
     
     import java.util.Arrays;
 

/* "Cantrip.java":58  */

/**
 * A Bison parser, automatically generated from <tt>Cantrip.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Cantrip
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.8.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";






  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_IDENTIFIER(3),               /* IDENTIFIER  */
    S_LITERAL(4),                  /* LITERAL  */
    S_EQUALS(5),                   /* "=="  */
    S_NOT_EQUALS(6),               /* "!="  */
    S_LT_EQUALS(7),                /* "<="  */
    S_GT_EQUALS(8),                /* ">="  */
    S_AND(9),                      /* "&&"  */
    S_OR(10),                      /* "||"  */
    S_REF_ASSN(11),                /* "#="  */
    S_IF(12),                      /* IF  */
    S_WHILE(13),                   /* WHILE  */
    S_LAMBDA(14),                  /* LAMBDA  */
    S_STATIC(15),                  /* STATIC  */
    S_16_(16),                     /* '@'  */
    S_17_(17),                     /* '('  */
    S_18_(18),                     /* '{'  */
    S_19_(19),                     /* '}'  */
    S_20_(20),                     /* '['  */
    S_21_(21),                     /* ']'  */
    S_22_(22),                     /* ';'  */
    S_23_(23),                     /* ')'  */
    S_ELSE(24),                    /* ELSE  */
    S_25_(25),                     /* '='  */
    S_26_(26),                     /* '<'  */
    S_27_(27),                     /* '>'  */
    S_28_(28),                     /* '+'  */
    S_29_(29),                     /* '-'  */
    S_30_(30),                     /* '*'  */
    S_31_(31),                     /* '/'  */
    S_32_(32),                     /* '%'  */
    S_UMINUS(33),                  /* UMINUS  */
    S_34_(34),                     /* '!'  */
    S_35_(35),                     /* '&'  */
    S_36_(36),                     /* '.'  */
    S_37_(37),                     /* ','  */
    S_YYACCEPT(38),                /* $accept  */
    S_Program(39),                 /* Program  */
    S_Statements(40),              /* Statements  */
    S_Statement(41),               /* Statement  */
    S_If_Statement(42),            /* If_Statement  */
    S_While_Statement(43),         /* While_Statement  */
    S_Expression(44),              /* Expression  */
    S_Expression_List(45),         /* Expression_List  */
    S_Block_Or_Statement(46),      /* Block_Or_Statement  */
    S_Block(47),                   /* Block  */
    S_Parameter_List(48),          /* Parameter_List  */
    S_Parameter(49);               /* Parameter  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_LITERAL,
      SymbolKind.S_EQUALS,
      SymbolKind.S_NOT_EQUALS,
      SymbolKind.S_LT_EQUALS,
      SymbolKind.S_GT_EQUALS,
      SymbolKind.S_AND,
      SymbolKind.S_OR,
      SymbolKind.S_REF_ASSN,
      SymbolKind.S_IF,
      SymbolKind.S_WHILE,
      SymbolKind.S_LAMBDA,
      SymbolKind.S_STATIC,
      SymbolKind.S_16_,
      SymbolKind.S_17_,
      SymbolKind.S_18_,
      SymbolKind.S_19_,
      SymbolKind.S_20_,
      SymbolKind.S_21_,
      SymbolKind.S_22_,
      SymbolKind.S_23_,
      SymbolKind.S_ELSE,
      SymbolKind.S_25_,
      SymbolKind.S_26_,
      SymbolKind.S_27_,
      SymbolKind.S_28_,
      SymbolKind.S_29_,
      SymbolKind.S_30_,
      SymbolKind.S_31_,
      SymbolKind.S_32_,
      SymbolKind.S_UMINUS,
      SymbolKind.S_34_,
      SymbolKind.S_35_,
      SymbolKind.S_36_,
      SymbolKind.S_37_,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_Program,
      SymbolKind.S_Statements,
      SymbolKind.S_Statement,
      SymbolKind.S_If_Statement,
      SymbolKind.S_While_Statement,
      SymbolKind.S_Expression,
      SymbolKind.S_Expression_List,
      SymbolKind.S_Block_Or_Statement,
      SymbolKind.S_Block,
      SymbolKind.S_Parameter_List,
      SymbolKind.S_Parameter
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* Return YYSTR after stripping away unnecessary quotes and
       backslashes, so that it's suitable for yyerror.  The heuristic is
       that double-quoting is unnecessary unless the string contains an
       apostrophe, a comma, or backslash (other than backslash-backslash).
       YYSTR is taken from yytname.  */
    private static String yytnamerr_(String yystr)
    {
      if (yystr.charAt (0) == '"')
        {
          StringBuffer yyr = new StringBuffer();
          strip_quotes: for (int i = 1; i < yystr.length(); i++)
            switch (yystr.charAt(i))
              {
              case '\'':
              case ',':
                break strip_quotes;

              case '\\':
                if (yystr.charAt(++i) != '\\')
                  break strip_quotes;
                /* Fall through.  */
              default:
                yyr.append(yystr.charAt(i));
                break;

              case '"':
                return yyr.toString();
              }
        }
      return yystr;
    }

    /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yytname_ = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "\"end of file\"", "error", "\"invalid token\"", "IDENTIFIER",
  "LITERAL", "\"==\"", "\"!=\"", "\"<=\"", "\">=\"", "\"&&\"", "\"||\"",
  "\"#=\"", "IF", "WHILE", "LAMBDA", "STATIC", "'@'", "'('", "'{'", "'}'",
  "'['", "']'", "';'", "')'", "ELSE", "'='", "'<'", "'>'", "'+'", "'-'",
  "'*'", "'/'", "'%'", "UMINUS", "'!'", "'&'", "'.'", "','", "$accept",
  "Program", "Statements", "Statement", "If_Statement", "While_Statement",
  "Expression", "Expression_List", "Block_Or_Statement", "Block",
  "Parameter_List", "Parameter", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Cantrip</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 258;
    /** Token LITERAL, to be returned by the scanner.  */
    static final int LITERAL = 259;
    /** Token "==", to be returned by the scanner.  */
    static final int EQUALS = 260;
    /** Token "!=", to be returned by the scanner.  */
    static final int NOT_EQUALS = 261;
    /** Token "<=", to be returned by the scanner.  */
    static final int LT_EQUALS = 262;
    /** Token ">=", to be returned by the scanner.  */
    static final int GT_EQUALS = 263;
    /** Token "&&", to be returned by the scanner.  */
    static final int AND = 264;
    /** Token "||", to be returned by the scanner.  */
    static final int OR = 265;
    /** Token "#=", to be returned by the scanner.  */
    static final int REF_ASSN = 266;
    /** Token IF, to be returned by the scanner.  */
    static final int IF = 267;
    /** Token WHILE, to be returned by the scanner.  */
    static final int WHILE = 268;
    /** Token LAMBDA, to be returned by the scanner.  */
    static final int LAMBDA = 269;
    /** Token STATIC, to be returned by the scanner.  */
    static final int STATIC = 270;
    /** Token ELSE, to be returned by the scanner.  */
    static final int ELSE = 271;
    /** Token UMINUS, to be returned by the scanner.  */
    static final int UMINUS = 272;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;


    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    ASTNode getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an errorin a user-defined way.
     *
     *
     * @param msg The string for the error message.
     */
     void yyerror(String msg);


  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Cantrip(Lexer yylexer)
  {

    this.yylexer = yylexer;

  }



  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors() { return yynerrs; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror(msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    private ASTNode[] valueStack = new ASTNode[16];

    public int size = 16;
    public int height = -1;

    public final void push(int state, ASTNode value) {
      height++;
      if (size == height) {
        int[] newStateStack = new int[size * 2];
        System.arraycopy(stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;

        ASTNode[] newValueStack = new ASTNode[size * 2];
        System.arraycopy(valueStack, 0, newValueStack, 0, height);
        valueStack = newValueStack;

        size *= 2;
      }

      stateStack[height] = state;
      valueStack[height] = value;
    }

    public final void pop() {
      pop(1);
    }

    public final void pop(int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt(int i) {
      return stateStack[height - i];
    }

    public final ASTNode valueAt(int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print(java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++) {
        out.print(' ');
        out.print(stateStack[i]);
      }
      out.println();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState(int yystate, int yysym) {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen)
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    ASTNode yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

    switch (yyn)
      {
          case 2: /* Program: Statements  */
  if (yyn == 2)
    /* "Cantrip.y":89  */
                           { root = ((Statement_List)(yystack.valueAt (0))); };
  break;


  case 3: /* Statements: Statements Statement  */
  if (yyn == 3)
    /* "Cantrip.y":92  */
                                     { ((Statement_List)(yystack.valueAt (1))).statements.add(((Statement)(yystack.valueAt (0)))); yyval = ((Statement_List)(yystack.valueAt (1))); };
  break;


  case 4: /* Statements: Statement  */
  if (yyn == 4)
    /* "Cantrip.y":93  */
                          { Statement_List st = new Statement_List();
                            st.statements.add(((Statement)(yystack.valueAt (0))));
                            yyval = st; };
  break;


  case 5: /* Statement: If_Statement  */
  if (yyn == 5)
    /* "Cantrip.y":98  */
                             { yyval = ((If_Statement)(yystack.valueAt (0))); };
  break;


  case 6: /* Statement: While_Statement  */
  if (yyn == 6)
    /* "Cantrip.y":99  */
                                { yyval = ((While_Statement)(yystack.valueAt (0))); };
  break;


  case 7: /* Statement: Expression ';'  */
  if (yyn == 7)
    /* "Cantrip.y":100  */
                               { Expression_Statement es = new Expression_Statement();
                                 es.root_expr = ((Expression)(yystack.valueAt (1)));
                                 yyval = es; };
  break;


  case 8: /* If_Statement: IF '(' Expression ')' Block_Or_Statement ELSE Block_Or_Statement  */
  if (yyn == 8)
    /* "Cantrip.y":106  */
                {
                    If_Statement is = new If_Statement();
                    is.condition = ((Expression)(yystack.valueAt (4)));
                    is.if_branch = ((Statement_List)(yystack.valueAt (2)));
                    is.else_branch = ((Statement_List)(yystack.valueAt (0)));
                    yyval = is;
                };
  break;


  case 9: /* If_Statement: IF '(' Expression ')' Block_Or_Statement  */
  if (yyn == 9)
    /* "Cantrip.y":114  */
                {
                    If_Statement is = new If_Statement();
                    is.condition = ((Expression)(yystack.valueAt (2)));
                    is.if_branch = ((Statement_List)(yystack.valueAt (0)));
                    yyval = is;
                };
  break;


  case 10: /* While_Statement: WHILE '(' Expression ')' Block_Or_Statement  */
  if (yyn == 10)
    /* "Cantrip.y":123  */
                {
                    While_Statement ws = new While_Statement();
                    ws.condition = ((Expression)(yystack.valueAt (2)));
                    ws.body = ((Statement_List)(yystack.valueAt (0)));
                    yyval = ws;
                };
  break;


  case 11: /* Expression: Expression '+' Expression  */
  if (yyn == 11)
    /* "Cantrip.y":131  */
                                          { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),'+',((Expression)(yystack.valueAt (0)))); };
  break;


  case 12: /* Expression: Expression '-' Expression  */
  if (yyn == 12)
    /* "Cantrip.y":132  */
                                          { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),'-',((Expression)(yystack.valueAt (0)))); };
  break;


  case 13: /* Expression: Expression '*' Expression  */
  if (yyn == 13)
    /* "Cantrip.y":133  */
                                          { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),'*',((Expression)(yystack.valueAt (0)))); };
  break;


  case 14: /* Expression: Expression '/' Expression  */
  if (yyn == 14)
    /* "Cantrip.y":134  */
                                          { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),'/',((Expression)(yystack.valueAt (0)))); };
  break;


  case 15: /* Expression: Expression '%' Expression  */
  if (yyn == 15)
    /* "Cantrip.y":135  */
                                          { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),'%',((Expression)(yystack.valueAt (0)))); };
  break;


  case 16: /* Expression: Expression "==" Expression  */
  if (yyn == 16)
    /* "Cantrip.y":136  */
                                           { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),Lexer.EQUALS,((Expression)(yystack.valueAt (0)))); };
  break;


  case 17: /* Expression: Expression "!=" Expression  */
  if (yyn == 17)
    /* "Cantrip.y":137  */
                                           { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),Lexer.NOT_EQUALS,((Expression)(yystack.valueAt (0)))); };
  break;


  case 18: /* Expression: Expression '<' Expression  */
  if (yyn == 18)
    /* "Cantrip.y":138  */
                                          { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),'<',((Expression)(yystack.valueAt (0)))); };
  break;


  case 19: /* Expression: Expression "<=" Expression  */
  if (yyn == 19)
    /* "Cantrip.y":139  */
                                           { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),Lexer.LT_EQUALS,((Expression)(yystack.valueAt (0)))); };
  break;


  case 20: /* Expression: Expression ">=" Expression  */
  if (yyn == 20)
    /* "Cantrip.y":140  */
                                           { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),Lexer.GT_EQUALS,((Expression)(yystack.valueAt (0)))); };
  break;


  case 21: /* Expression: Expression '>' Expression  */
  if (yyn == 21)
    /* "Cantrip.y":141  */
                                          { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),'>',((Expression)(yystack.valueAt (0)))); };
  break;


  case 22: /* Expression: Expression "&&" Expression  */
  if (yyn == 22)
    /* "Cantrip.y":142  */
                                           { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),Lexer.AND,((Expression)(yystack.valueAt (0)))); };
  break;


  case 23: /* Expression: Expression "||" Expression  */
  if (yyn == 23)
    /* "Cantrip.y":143  */
                                           { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),Lexer.OR,((Expression)(yystack.valueAt (0)))); };
  break;


  case 24: /* Expression: Expression '=' Expression  */
  if (yyn == 24)
    /* "Cantrip.y":144  */
                                          { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),'=',((Expression)(yystack.valueAt (0)))); };
  break;


  case 25: /* Expression: Expression "#=" Expression  */
  if (yyn == 25)
    /* "Cantrip.y":145  */
                                           { yyval = new Binary_Expression(((Expression)(yystack.valueAt (2))),Lexer.REF_ASSN,((Expression)(yystack.valueAt (0)))); };
  break;


  case 26: /* Expression: '-' Expression  */
  if (yyn == 26)
    /* "Cantrip.y":146  */
                                            { yyval = new Unary_Expression('-',((Expression)(yystack.valueAt (0)))); };
  break;


  case 27: /* Expression: '!' Expression  */
  if (yyn == 27)
    /* "Cantrip.y":147  */
                               { yyval = new Unary_Expression('!',((Expression)(yystack.valueAt (0)))); };
  break;


  case 28: /* Expression: '(' Expression ')'  */
  if (yyn == 28)
    /* "Cantrip.y":148  */
                                   { yyval = ((Expression)(yystack.valueAt (1))); };
  break;


  case 29: /* Expression: LAMBDA '(' Parameter_List ')' Block  */
  if (yyn == 29)
    /* "Cantrip.y":150  */
                {
                    Value v = new Value();
                    v.type = Type.FUNCTION;
                    v.is_literal = true;
                    
                    Function f = new Function();
                    v.func_value = f;
                    
                    f.formal_parameters = ((Parameter_List)(yystack.valueAt (2))).parameters;
                    f.body = ((Statement_List)(yystack.valueAt (0)));

                    yyval = v;
                };
  break;


  case 30: /* Expression: Expression '(' Expression_List ')'  */
  if (yyn == 30)
    /* "Cantrip.y":163  */
                                                   { yyval = new Function_Call_Expression(((Expression)(yystack.valueAt (3))),((Expression_List)(yystack.valueAt (1))).value); };
  break;


  case 31: /* Expression: '@'  */
  if (yyn == 31)
    /* "Cantrip.y":165  */
                {
                    Value v = new Value();
                    v.type = Type.AGGREGATE;
                    v.is_literal = true;

                    yyval = v;
                };
  break;


  case 32: /* Expression: Expression '.' IDENTIFIER  */
  if (yyn == 32)
    /* "Cantrip.y":172  */
                                          { yyval = new Aggregate_Access_Expression(((Expression)(yystack.valueAt (2))),((Identifier)(yystack.valueAt (0))).name); };
  break;


  case 33: /* Expression: '[' Expression ']'  */
  if (yyn == 33)
    /* "Cantrip.y":173  */
                                   { yyval = new Array_Access_Expression(null,((Expression)(yystack.valueAt (1)))); };
  break;


  case 34: /* Expression: Expression '[' Expression ']'  */
  if (yyn == 34)
    /* "Cantrip.y":174  */
                                              { yyval = new Array_Access_Expression(((Expression)(yystack.valueAt (3))),((Expression)(yystack.valueAt (1)))); };
  break;


  case 35: /* Expression: IDENTIFIER  */
  if (yyn == 35)
    /* "Cantrip.y":175  */
                           { yyval = ((Identifier)(yystack.valueAt (0))); };
  break;


  case 36: /* Expression: LITERAL  */
  if (yyn == 36)
    /* "Cantrip.y":176  */
                        { yyval = ((Value)(yystack.valueAt (0))); };
  break;


  case 37: /* Expression_List: Expression_List ',' Expression  */
  if (yyn == 37)
    /* "Cantrip.y":179  */
                                                { ((Expression_List)(yystack.valueAt (2))).value.add(((Expression)(yystack.valueAt (0)))); yyval = ((Expression_List)(yystack.valueAt (2))); };
  break;


  case 38: /* Expression_List: Expression  */
  if (yyn == 38)
    /* "Cantrip.y":180  */
                           { Expression_List el = new Expression_List(); el.value.add(((Expression)(yystack.valueAt (0)))); yyval = el; };
  break;


  case 39: /* Expression_List: %empty  */
  if (yyn == 39)
    /* "Cantrip.y":181  */
                          { yyval = new Expression_List(); };
  break;


  case 40: /* Block_Or_Statement: Block  */
  if (yyn == 40)
    /* "Cantrip.y":184  */
                          { yyval = ((Statement_List)(yystack.valueAt (0))); };
  break;


  case 41: /* Block_Or_Statement: Statement  */
  if (yyn == 41)
    /* "Cantrip.y":185  */
                          { Statement_List sl = new Statement_List();
                            sl.statements.add(((Statement)(yystack.valueAt (0))));
                            yyval = sl; };
  break;


  case 42: /* Block: '{' Statements '}'  */
  if (yyn == 42)
    /* "Cantrip.y":190  */
                                   { yyval = ((Statement_List)(yystack.valueAt (1))); };
  break;


  case 43: /* Block: '{' '}'  */
  if (yyn == 43)
    /* "Cantrip.y":191  */
                        { yyval = new Statement_List(); };
  break;


  case 44: /* Parameter_List: Parameter_List ',' Parameter  */
  if (yyn == 44)
    /* "Cantrip.y":194  */
                                             { ((Parameter_List)(yystack.valueAt (2))).parameters.add(((Parameter)(yystack.valueAt (0)))); yyval = ((Parameter_List)(yystack.valueAt (2))); };
  break;


  case 45: /* Parameter_List: Parameter  */
  if (yyn == 45)
    /* "Cantrip.y":195  */
                          { Parameter_List pl = new Parameter_List();
                            pl.parameters.add(((Parameter)(yystack.valueAt (0))));
                            yyval = pl; };
  break;


  case 46: /* Parameter_List: %empty  */
  if (yyn == 46)
    /* "Cantrip.y":198  */
                          { yyval = new Parameter_List(); };
  break;


  case 47: /* Parameter: IDENTIFIER  */
  if (yyn == 47)
    /* "Cantrip.y":201  */
                           { Parameter p = new Parameter(); p.name = ((Identifier)(yystack.valueAt (0))).name; yyval = p; };
  break;


  case 48: /* Parameter: '&' IDENTIFIER  */
  if (yyn == 48)
    /* "Cantrip.y":202  */
                               { Parameter p = new Parameter();
                                 p.name = ((Identifier)(yystack.valueAt (0))).name;
                                 p.is_reference = true;
                                 yyval = p; };
  break;



/* "Cantrip.java":871  */

        default: break;
      }

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval);
    return YYNEWSTATE;
  }




  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException

  {


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;



    /* Semantic value of the lookahead.  */
    ASTNode yylval = null;



    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
              label = YYDEFAULT;
            }

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError(yyn)) {
                  label = YYERRLAB;
                } else {
                  yyn = -yyn;
                  label = YYREDUCE;
                }
              }

            else
              {
                /* Shift the lookahead token.  */
                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push(yystate, yylval);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt(0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError(new Context(this, yystack, yytoken));
          }

        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt(0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yystack.pop ();
            yystate = yystack.stateAt(0);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context {
    Context(Cantrip parser, YYStack stack, SymbolKind token) {
      yyparser = parser;
      yystack = stack;
      yytoken = token;
    }

    private Cantrip yyparser;
    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken() {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = Cantrip.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt(0)];
      if (!yyPactValueIsDefault(yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }





  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      yyerror("syntax error");
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault(int yyvalue) {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError(int yyvalue) {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -73;
  private static final byte yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
     363,   -73,   -73,    -8,    -7,    -6,   -73,   397,   397,   397,
     397,    15,   363,   -73,   -73,   -73,    36,   397,   397,     5,
      76,   108,    34,    34,   -73,   -73,   397,   397,   397,   397,
     397,   397,   397,   397,   397,   -73,   397,   397,   397,   397,
     397,   397,   397,   397,    14,   140,   172,   -73,    16,   -21,
     -73,   -73,   -73,   404,   404,   376,   376,   285,   268,   236,
     236,   -16,   204,   236,   376,   376,   354,   354,    34,    34,
      34,   -73,   306,   306,   -73,     2,     5,   -73,   397,   -73,
     325,   -73,     7,   -73,   -73,   -73,   -73,   236,   -73,   344,
     306,   -73,   -73
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte[] yydefact_ = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       0,    35,    36,     0,     0,     0,    31,     0,     0,     0,
       0,     0,     2,     4,     5,     6,     0,     0,     0,    46,
       0,     0,    26,    27,     1,     3,     0,     0,     0,     0,
       0,     0,     0,    39,     0,     7,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,    47,     0,     0,
      45,    28,    33,    16,    17,    19,    20,    22,    23,    25,
      38,     0,     0,    24,    18,    21,    11,    12,    13,    14,
      15,    32,     0,     0,    48,     0,     0,    30,     0,    34,
       0,    41,     9,    40,    10,    29,    44,    37,    43,     0,
       0,    42,     8
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -73,   -73,   -32,     0,   -73,   -73,    -4,   -73,   -72,   -26,
     -73,   -24
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,    11,    12,    81,    14,    15,    16,    61,    82,    83,
      49,    50
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte[] yytable_ = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
      13,    84,    75,    20,    21,    22,    23,    77,    47,    17,
      18,    19,    25,    45,    46,    24,    76,    71,    92,    74,
      80,    78,    53,    54,    55,    56,    57,    58,    59,    60,
      62,    90,    63,    64,    65,    66,    67,    68,    69,    70,
      48,    26,    27,    28,    29,    30,    31,    32,    89,    85,
       0,    33,    86,    33,    34,     0,    34,     0,    35,     0,
       0,    36,    37,    38,    39,    40,    41,    42,    43,     0,
      44,     0,    44,     0,    87,     0,     0,     0,     0,     0,
      13,    26,    27,    28,    29,    30,    31,    32,     0,    25,
       0,     0,     0,    33,     0,     0,    34,     0,     0,    51,
       0,    36,    37,    38,    39,    40,    41,    42,    43,     0,
       0,     0,    44,    26,    27,    28,    29,    30,    31,    32,
       0,     0,     0,     0,     0,    33,     0,     0,    34,    52,
       0,     0,     0,    36,    37,    38,    39,    40,    41,    42,
      43,     0,     0,     0,    44,    26,    27,    28,    29,    30,
      31,    32,     0,     0,     0,     0,     0,    33,     0,     0,
      34,     0,     0,    72,     0,    36,    37,    38,    39,    40,
      41,    42,    43,     0,     0,     0,    44,    26,    27,    28,
      29,    30,    31,    32,     0,     0,     0,     0,     0,    33,
       0,     0,    34,     0,     0,    73,     0,    36,    37,    38,
      39,    40,    41,    42,    43,     0,     0,     0,    44,    26,
      27,    28,    29,    30,    31,    32,     0,     0,     0,     0,
       0,    33,     0,     0,    34,    79,     0,     0,     0,    36,
      37,    38,    39,    40,    41,    42,    43,     0,     0,     0,
      44,    26,    27,    28,    29,    30,    31,    32,     0,     0,
       0,     0,     0,    33,     0,     0,    34,     0,     0,     0,
       0,    36,    37,    38,    39,    40,    41,    42,    43,     0,
       0,     0,    44,    26,    27,    28,    29,    30,     0,     0,
       0,     0,     0,     0,     0,    33,     0,     0,    34,     0,
      26,    27,    28,    29,    37,    38,    39,    40,    41,    42,
      43,     0,    33,     0,    44,    34,     0,     0,     0,     1,
       2,    37,    38,    39,    40,    41,    42,    43,     3,     4,
       5,    44,     6,     7,    80,     0,     8,     0,     1,     2,
       0,     0,     0,     0,     0,     9,     0,     3,     4,     5,
      10,     6,     7,     0,    88,     8,     0,     1,     2,     0,
       0,     0,     0,     0,     9,     0,     3,     4,     5,    10,
       6,     7,     0,    91,     8,     0,     1,     2,     0,     0,
       0,    33,     0,     9,    34,     3,     4,     5,    10,     6,
       7,    26,    27,     8,    41,    42,    43,     0,     0,     0,
      44,     0,     9,    33,     0,     0,    34,    10,     0,     0,
       1,     2,     0,     0,    39,    40,    41,    42,    43,     0,
       0,     5,    44,     6,     7,     0,     0,     8,     0,     0,
       0,    33,     0,     0,    34,     0,     9,     0,     0,     0,
       0,    10,    39,    40,    41,    42,    43,     0,     0,     0,
      44
    };
  }

private static final byte[] yycheck_ = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       0,    73,    23,     7,     8,     9,    10,    23,     3,    17,
      17,    17,    12,    17,    18,     0,    37,     3,    90,     3,
      18,    37,    26,    27,    28,    29,    30,    31,    32,    33,
      34,    24,    36,    37,    38,    39,    40,    41,    42,    43,
      35,     5,     6,     7,     8,     9,    10,    11,    80,    75,
      -1,    17,    76,    17,    20,    -1,    20,    -1,    22,    -1,
      -1,    25,    26,    27,    28,    29,    30,    31,    32,    -1,
      36,    -1,    36,    -1,    78,    -1,    -1,    -1,    -1,    -1,
      80,     5,     6,     7,     8,     9,    10,    11,    -1,    89,
      -1,    -1,    -1,    17,    -1,    -1,    20,    -1,    -1,    23,
      -1,    25,    26,    27,    28,    29,    30,    31,    32,    -1,
      -1,    -1,    36,     5,     6,     7,     8,     9,    10,    11,
      -1,    -1,    -1,    -1,    -1,    17,    -1,    -1,    20,    21,
      -1,    -1,    -1,    25,    26,    27,    28,    29,    30,    31,
      32,    -1,    -1,    -1,    36,     5,     6,     7,     8,     9,
      10,    11,    -1,    -1,    -1,    -1,    -1,    17,    -1,    -1,
      20,    -1,    -1,    23,    -1,    25,    26,    27,    28,    29,
      30,    31,    32,    -1,    -1,    -1,    36,     5,     6,     7,
       8,     9,    10,    11,    -1,    -1,    -1,    -1,    -1,    17,
      -1,    -1,    20,    -1,    -1,    23,    -1,    25,    26,    27,
      28,    29,    30,    31,    32,    -1,    -1,    -1,    36,     5,
       6,     7,     8,     9,    10,    11,    -1,    -1,    -1,    -1,
      -1,    17,    -1,    -1,    20,    21,    -1,    -1,    -1,    25,
      26,    27,    28,    29,    30,    31,    32,    -1,    -1,    -1,
      36,     5,     6,     7,     8,     9,    10,    11,    -1,    -1,
      -1,    -1,    -1,    17,    -1,    -1,    20,    -1,    -1,    -1,
      -1,    25,    26,    27,    28,    29,    30,    31,    32,    -1,
      -1,    -1,    36,     5,     6,     7,     8,     9,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    17,    -1,    -1,    20,    -1,
       5,     6,     7,     8,    26,    27,    28,    29,    30,    31,
      32,    -1,    17,    -1,    36,    20,    -1,    -1,    -1,     3,
       4,    26,    27,    28,    29,    30,    31,    32,    12,    13,
      14,    36,    16,    17,    18,    -1,    20,    -1,     3,     4,
      -1,    -1,    -1,    -1,    -1,    29,    -1,    12,    13,    14,
      34,    16,    17,    -1,    19,    20,    -1,     3,     4,    -1,
      -1,    -1,    -1,    -1,    29,    -1,    12,    13,    14,    34,
      16,    17,    -1,    19,    20,    -1,     3,     4,    -1,    -1,
      -1,    17,    -1,    29,    20,    12,    13,    14,    34,    16,
      17,     5,     6,    20,    30,    31,    32,    -1,    -1,    -1,
      36,    -1,    29,    17,    -1,    -1,    20,    34,    -1,    -1,
       3,     4,    -1,    -1,    28,    29,    30,    31,    32,    -1,
      -1,    14,    36,    16,    17,    -1,    -1,    20,    -1,    -1,
      -1,    17,    -1,    -1,    20,    -1,    29,    -1,    -1,    -1,
      -1,    34,    28,    29,    30,    31,    32,    -1,    -1,    -1,
      36
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,    12,    13,    14,    16,    17,    20,    29,
      34,    39,    40,    41,    42,    43,    44,    17,    17,    17,
      44,    44,    44,    44,     0,    41,     5,     6,     7,     8,
       9,    10,    11,    17,    20,    22,    25,    26,    27,    28,
      29,    30,    31,    32,    36,    44,    44,     3,    35,    48,
      49,    23,    21,    44,    44,    44,    44,    44,    44,    44,
      44,    45,    44,    44,    44,    44,    44,    44,    44,    44,
      44,     3,    23,    23,     3,    23,    37,    23,    37,    21,
      18,    41,    46,    47,    46,    47,    49,    44,    19,    40,
      24,    19,    46
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    38,    39,    40,    40,    41,    41,    41,    42,    42,
      43,    44,    44,    44,    44,    44,    44,    44,    44,    44,
      44,    44,    44,    44,    44,    44,    44,    44,    44,    44,
      44,    44,    44,    44,    44,    44,    44,    45,    45,    45,
      46,    46,    47,    47,    48,    48,    48,    49,    49
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     2,     1,     1,     1,     2,     7,     5,
       5,     3,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     3,     3,     2,     2,     3,     5,
       4,     1,     3,     3,     4,     1,     1,     3,     1,     0,
       1,     1,     3,     2,     3,     1,     0,     1,     2
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 272;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    34,     2,     2,     2,    32,    35,     2,
      17,    23,    30,    28,    37,    29,    36,    31,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,    22,
      26,    25,    27,     2,    16,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,    20,     2,    21,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    18,     2,    19,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    24,    33
    };
  }


  private static final int YYLAST_ = 440;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 24;
  private static final int YYNTOKENS_ = 38;

/* Unqualified %code blocks.  */
/* "Cantrip.y":22  */

     public static void main(String[] args) throws IOException
     {
          Cantrip builtins = new Cantrip(new Yylex(new InputStreamReader(new ByteArrayInputStream(CAN_Library.source))));
          boolean b_parsed = builtins.parse();
          assert(b_parsed);
          
          Cantrip parser = new Cantrip(new Yylex(new InputStreamReader(new FileInputStream(new File(args[0])))));
          if(parser.parse())
               System.out.println("Parsing successful.");
          else
               System.out.println("Program failed to parse.");

          Interpreter runner = new Interpreter();
          runner.visit(builtins.root);
          runner.visit(parser.root);
     }
 
/* "Cantrip.y":41  */

    public Statement_List root;
 

/* "Cantrip.java":1530  */

}
