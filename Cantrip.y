//Bison parser for the Cantrip programming language.
//Copyright (c) 2016 Patrick Simmons
//License is GPLv3 or later; see LICENSE file for details.
%language "Java"
%define public
%define parser_class_name {Cantrip}
%define api.value.type {ASTNode}

%code imports {
     import java.io.StreamTokenizer;
     import java.io.ByteArrayInputStream;
     import java.io.InputStream;
     import java.io.InputStreamReader;
     import java.io.Reader;
     import java.io.IOException;
     import java.io.FileInputStream;
     import java.io.File;
     
     import java.util.Arrays;
 }

%code {
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
 }

%code {
    public Statement_List root;
 }

//Token aliases
%token <Identifier> IDENTIFIER
%token <Value> LITERAL
%token <Token> EQUALS "=="
%token <Token> NOT_EQUALS "!="
%token LT_EQUALS "<="
%token GT_EQUALS ">="
%token <Token> AND "&&"
%token <Token> OR "||"
%token REF_ASSN "#="

%token <Token> IF WHILE
%token <Token> LAMBDA STATIC
%token <Token> '@' '(' '{' '}' '[' ']' ';'

//Handle dangling else problem
%nonassoc <Token> ')'
%nonassoc <Token> ELSE

%right <Token> '=' "#="
%left "||"
%left "&&"
%left <Token> '<' "<=" ">=" '>'
%left "==" "!="
%left <Token> '+' '-'
%left <Token> '*' '/' '%'

%precedence UMINUS
%left <Token> '!' '&'
%left <Token> '.'

//Types of nonterminals
%type <Statement_List> Program Statements
%type <Statement> Statement
%type <If_Statement> If_Statement
%type <While_Statement> While_Statement
%type <Expression> Expression
%type <Expression_List> Expression_List
%type <Statement_List> Block_Or_Statement Block
%type <Parameter_List> Parameter_List
%type <Parameter> Parameter

%%

Program:        Statements { root = $1; }
        ;

Statements:     Statements Statement { $1.statements.add($2); $$ = $1; }
        |       Statement { Statement_List st = new Statement_List();
                            st.statements.add($1);
                            $$ = st; }
        ;

Statement:      If_Statement { $$ = $1; }
        |       While_Statement { $$ = $1; }
        |       Expression ';' { Expression_Statement es = new Expression_Statement();
                                 es.root_expr = $1;
                                 $$ = es; }
        ;

If_Statement:   IF '(' Expression ')' Block_Or_Statement ELSE Block_Or_Statement
                {
                    If_Statement is = new If_Statement();
                    is.condition = $3;
                    is.if_branch = $5;
                    is.else_branch = $7;
                    $$ = is;
                }
        |       IF '(' Expression ')' Block_Or_Statement
                {
                    If_Statement is = new If_Statement();
                    is.condition = $3;
                    is.if_branch = $5;
                    $$ = is;
                }
        ;

While_Statement: WHILE '(' Expression ')' Block_Or_Statement
                {
                    While_Statement ws = new While_Statement();
                    ws.condition = $3;
                    ws.body = $5;
                    $$ = ws;
                }
        ;

Expression:     Expression '+' Expression { $$ = new Binary_Expression($1,'+',$3); }
        |       Expression '-' Expression { $$ = new Binary_Expression($1,'-',$3); }
        |       Expression '*' Expression { $$ = new Binary_Expression($1,'*',$3); }
        |       Expression '/' Expression { $$ = new Binary_Expression($1,'/',$3); }
        |       Expression '%' Expression { $$ = new Binary_Expression($1,'%',$3); }
        |       Expression "==" Expression { $$ = new Binary_Expression($1,Lexer.EQUALS,$3); }
        |       Expression "!=" Expression { $$ = new Binary_Expression($1,Lexer.NOT_EQUALS,$3); }
        |       Expression '<' Expression { $$ = new Binary_Expression($1,'<',$3); }
        |       Expression "<=" Expression { $$ = new Binary_Expression($1,Lexer.LT_EQUALS,$3); }
        |       Expression ">=" Expression { $$ = new Binary_Expression($1,Lexer.GT_EQUALS,$3); }
        |       Expression '>' Expression { $$ = new Binary_Expression($1,'>',$3); }
        |       Expression "&&" Expression { $$ = new Binary_Expression($1,Lexer.AND,$3); }
        |       Expression "||" Expression { $$ = new Binary_Expression($1,Lexer.OR,$3); }
        |       Expression '=' Expression { $$ = new Binary_Expression($1,'=',$3); }
        |       Expression "#=" Expression { $$ = new Binary_Expression($1,Lexer.REF_ASSN,$3); }
        |       '-' Expression %prec UMINUS { $$ = new Unary_Expression('-',$2); }
        |       '!' Expression { $$ = new Unary_Expression('!',$2); }
        |       '(' Expression ')' { $$ = $2; }
        |       LAMBDA '(' Parameter_List ')' Block
                {
                    Value v = new Value();
                    v.type = Type.FUNCTION;
                    v.is_literal = true;
                    
                    Function f = new Function();
                    v.func_value = f;
                    
                    f.formal_parameters = $3.parameters;
                    f.body = $5;

                    $$ = v;
                }
        |       Expression '(' Expression_List ')' { $$ = new Function_Call_Expression($1,$3.value); }
        |       '@'
                {
                    Value v = new Value();
                    v.type = Type.AGGREGATE;
                    v.is_literal = true;

                    $$ = v;
                }
        |       Expression '.' IDENTIFIER { $$ = new Aggregate_Access_Expression($1,$3.name); }
        |       '[' Expression ']' { $$ = new Array_Access_Expression(null,$2); }
        |       Expression '[' Expression ']' { $$ = new Array_Access_Expression($1,$3); }
        |       IDENTIFIER { $$ = $1; }
        |       LITERAL { $$ = $1; }
        ;

Expression_List: Expression_List ',' Expression { $1.value.add($3); $$ = $1; }
        |       Expression { Expression_List el = new Expression_List(); el.value.add($1); $$ = el; }
        |       /*empty*/ { $$ = new Expression_List(); }
        ;

Block_Or_Statement: Block { $$ = $1; }
        |       Statement { Statement_List sl = new Statement_List();
                            sl.statements.add($1);
                            $$ = sl; }
        ;

Block:          '{' Statements '}' { $$ = $2; }
        |       '{' '}' { $$ = new Statement_List(); }
        ;

Parameter_List: Parameter_List ',' Parameter { $1.parameters.add($3); $$ = $1; }
        |       Parameter { Parameter_List pl = new Parameter_List();
                            pl.parameters.add($1);
                            $$ = pl; }
        |       /*empty*/ { $$ = new Parameter_List(); }
        ;

Parameter:      IDENTIFIER { Parameter p = new Parameter(); p.name = $1.name; $$ = p; }
        |       '&' IDENTIFIER { Parameter p = new Parameter();
                                 p.name = $2.name;
                                 p.is_reference = true;
                                 $$ = p; }
        ;
