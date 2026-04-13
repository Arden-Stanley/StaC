grammar StaC;

@parser::header {
    import stac.AST.*;
    import java.util.ArrayList;
    import java.util.List;
}

// ─── Parser Rules ────────────────────────────────────────────────────────────

program returns [Program ast]
    : body=topLevel* EOF
      { 
        List<ASTNode> nodes = new ArrayList<>();
        for (TopLevelContext t : $ctx.topLevel()) nodes.add(t.ast);
        $ast = new Program(nodes);
      }
    ;

topLevel returns [ASTNode ast]
    : functionDef  { $ast = $functionDef.ast; }
    | declaration  { $ast = $declaration.ast; }
    ;

// ─── Declarations ────────────────────────────────────────────────────────────

declaration returns [DeclarationExp ast]
    : t=type IDENTIFIER '<=' expression ';'
      { $ast = new DeclarationExp($t.text, $IDENTIFIER.text, $expression.ast, false); }
    | t=type IDENTIFIER '<==' expression ';'
      { $ast = new DeclarationExp($t.text, $IDENTIFIER.text, $expression.ast, true); }
    | t=type IDENTIFIER ';'
      { $ast = new DeclarationExp($t.text, $IDENTIFIER.text, null, false); }
    ;

type returns [String text]
    : 'int'  { $text = "int"; }
    | 'char' { $text = "char"; }
    ;

// ─── Functions ───────────────────────────────────────────────────────────────

functionDef returns [FunctionDef ast]
    : t=type IDENTIFIER '(' paramList? ')' '{' statement* '}'
      {
        List<Param> params = ($ctx.paramList() != null) ? $ctx.paramList().ast : new ArrayList<>();
        List<Exp> stmts = new ArrayList<>();
        for (StatementContext s : $ctx.statement()) stmts.add(s.ast);
        $ast = new FunctionDef($t.text, $IDENTIFIER.text, params, stmts);
      }
    ;

paramList returns [List<Param> ast]
    : first=param
      {
        $ast = new ArrayList<>();
        $ast.add($first.ast);
      }
      ( ',' rest=param { $ast.add($rest.ast); } )*
    ;

param returns [Param ast]
    : t=type IDENTIFIER
      { $ast = new Param($t.text, $IDENTIFIER.text); }
    ;

// ─── Statements ──────────────────────────────────────────────────────────────

statement returns [Exp ast]
    : declaration      { $ast = $declaration.ast; }
    | transferStmt     { $ast = $transferStmt.ast; }
    | dumpStmt         { $ast = $dumpStmt.ast; }
    | topSwapStmt      { $ast = $topSwapStmt.ast; }
    | fullSwapStmt     { $ast = $fullSwapStmt.ast; }
    | ifStmt           { $ast = $ifStmt.ast; }
    | whileStmt        { $ast = $whileStmt.ast; }
    | forStmt          { $ast = $forStmt.ast; }
    | returnStmt       { $ast = $returnStmt.ast; }
    | builtinCallStmt  { $ast = $builtinCallStmt.ast; }
    ;

transferStmt returns [TransferExp ast]
    : s=sink '<=' e=expression ';'
      { $ast = new TransferExp($s.text, $e.ast); }
    ;

// Chained dump — right-to-left associative
// e.g. print <== "Max: " <== reverse
dumpStmt returns [DumpExp ast]
    : s=sink ( '<==' sources+=expression )+ ';'
      {
        List<Exp> srcs = new ArrayList<>();
        for (ExpressionContext e : $sources) srcs.add(e.ast);
        $ast = new DumpExp($s.text, srcs);
      }
    ;

topSwapStmt returns [TopSwapExp ast]
    : left=IDENTIFIER '<=>' right=IDENTIFIER ';'
      { $ast = new TopSwapExp($left.text, $right.text); }
    ;

fullSwapStmt returns [FullSwapExp ast]
    : left=IDENTIFIER '<==>' right=IDENTIFIER ';'
      { $ast = new FullSwapExp($left.text, $right.text); }
    ;

returnStmt returns [ReturnExp ast]
    : 'return' ';'
      { $ast = new ReturnExp(); }
    ;

sink returns [String text]
    : IDENTIFIER { $text = $IDENTIFIER.text; }
    | 'print'    { $text = "print"; }
    ;

// ─── Control Flow ────────────────────────────────────────────────────────────
// block is a helper rule to avoid ambiguity with two statments in ifStmt
block returns [List<Exp> ast]
  : '{' statement* '}'
    {
      $ast = new ArrayList<>();
      for (StatementContext s : $ctx.statement()) $ast.add(s.ast);
    }
  ;


ifStmt returns [IfExp ast]
    : 'if' '(' c=condition ')' thenBlock=block
      ( 'else' elseBlock=block )?
      {
        List<Exp> elseStmts = ($ctx.elseBlock != null) ? $ctx.elseBlock.ast : null;
        $ast = new IfExp($c.ast, $ctx.thenBlock.ast, elseStmts);
      }
    ;

whileStmt returns [WhileExp ast]
    : 'while' '(' c=condition ')' block
      {
        $ast = new WhileExp($c.ast, $ctx.block().ast);
      }
    ;

forStmt returns [ForExp ast]
    : 'for' '(' init=declaration c=condition ';' step=forStep ')' block
      {
        $ast = new ForExp($init.ast, $c.ast, $step.ast, $ctx.block().ast);
      }
    ;

forStep returns [TransferExp ast]
    : IDENTIFIER '<=' e=expression
      { $ast = new TransferExp($IDENTIFIER.text, $e.ast); }
    ;

// ─── Conditions ──────────────────────────────────────────────────────────────

condition returns [Condition ast]
    : left=expression op=compOp right=expression
      { $ast = new ComparisonCondition($left.ast, $op.text, $right.ast); }
    | '!' IDENTIFIER
      { $ast = new EmptyCondition($IDENTIFIER.text); }
    | IDENTIFIER
      { $ast = new TruthyCondition($IDENTIFIER.text); }
    | 'empty' '(' IDENTIFIER ')'
      { $ast = new EmptyCondition($IDENTIFIER.text); }
    | '!' 'empty' '(' IDENTIFIER ')'
      { $ast = new TruthyCondition($IDENTIFIER.text); }
    ;

compOp returns [String text]
    : '<'   { $text = "<"; }
    | '>'   { $text = ">"; }
    | '='   { $text = "="; }
    | '!='  { $text = "!="; }
    | '!<'  { $text = "!<"; }
    | '!>'  { $text = "!>"; }
    ;

// ─── Expressions ─────────────────────────────────────────────────────────────

expression returns [Exp ast]
    : left=term { $ast = $left.ast; }
      ( '+' right=term { $ast = new AddExp($ast, $right.ast); }
      | '-' right=term { $ast = new SubExp($ast, $right.ast); }
      )*
    ;

term returns [Exp ast]
    : left=factor { $ast = $left.ast; }
      ( '*' right=factor { $ast = new MulExp($ast, $right.ast); }
      | '/' right=factor { $ast = new DivExp($ast, $right.ast); }
      | '%' right=factor { $ast = new ModExp($ast, $right.ast); }
      )*
    ;

factor returns [Exp ast]
    : IDENTIFIER    { $ast = new VarExp($IDENTIFIER.text); }
    | literal       { $ast = $literal.ast; }
    | functionCall  { $ast = $functionCall.ast; }
    | builtinExpr   { $ast = $builtinExpr.ast; }
    | '(' expression ')' { $ast = $expression.ast; }
    ;

functionCall returns [FunctionCallExp ast]
    : IDENTIFIER '(' a=argList? ')'
      {
        List<String> args = ($ctx.argList() != null) ? $ctx.argList().ast : new ArrayList<>();
        $ast = new FunctionCallExp($IDENTIFIER.text, args);
      }
    ;

argList returns [List<String> ast]
    : first=IDENTIFIER
      {
        $ast = new ArrayList<>();
        $ast.add($first.text);
      }
      ( ',' rest=IDENTIFIER { $ast.add($rest.text); } )*
    ;

builtinExpr returns [Exp ast]
    : 'randInt' '(' min=expression ',' max=expression ')'
      { $ast = new RandIntExp($min.ast, $max.ast); }
    | 'scanInt' '(' ')'
      { $ast = new ScanIntExp(); }
    | 'scan' '(' ')'
      { $ast = new ScanExp(); }
    | 'depth' '(' IDENTIFIER ')'
      { $ast = new DepthExp($IDENTIFIER.text); }
    ;

builtinCallStmt returns [Exp ast]
    : 'dup' '(' IDENTIFIER ')' ';'
      { $ast = new DupExp($IDENTIFIER.text); }
    | 'pop' '(' IDENTIFIER ')' ';'
      { $ast = new PopExp($IDENTIFIER.text); }
    ;

// ─── Literals ────────────────────────────────────────────────────────────────

literal returns [Exp ast]
    : INT_LITERAL
      { $ast = new IntLiteralExp(Integer.parseInt($INT_LITERAL.text)); }
    | CHAR_LITERAL
      {
        // strip surrounding quotes and handle escape sequences
        String raw = $CHAR_LITERAL.text;
        raw = raw.substring(1, raw.length() - 1);
        char val = raw.equals("\\n") ? '\n'
                 : raw.equals("\\t") ? '\t'
                 : raw.equals("\\r") ? '\r'
                 : raw.equals("\\\\") ? '\\'
                 : raw.equals("\\'") ? '\''
                 : raw.equals("\\\"") ? '"'
                 : raw.charAt(0);
        $ast = new CharLiteralExp(val);
      }
    | STRING_LITERAL
      {
        // strip surrounding quotes
        String raw = $STRING_LITERAL.text;
        raw = raw.substring(1, raw.length() - 1);
        $ast = new StringLiteralExp(raw);
      }
    ;

// ─── Lexer Rules ─────────────────────────────────────────────────────────────

// Keywords
INT     : 'int' ;
CHAR    : 'char' ;
IF      : 'if' ;
ELSE    : 'else' ;
WHILE   : 'while' ;
FOR     : 'for' ;
RETURN  : 'return' ;
PRINT   : 'print' ;
DUP     : 'dup' ;
POP     : 'pop' ;
EMPTY   : 'empty' ;
DEPTH   : 'depth' ;
SCAN    : 'scan' ;
SCANINT : 'scanInt' ;
RANDINT : 'randInt' ;

// Operators (longest match first)
FULL_SWAP   : '<==>' ;
DUMP        : '<==' ;
TRANSFER    : '<=' ;
TOP_SWAP    : '<=>' ;
LTE         : '!>' ;
GTE         : '!<' ;
NEQ         : '!=' ;
LT          : '<' ;
GT          : '>' ;
EQ          : '=' ;
NOT         : '!' ;

// Literals
INT_LITERAL
    	: [0-9]+
    	;

CHAR_LITERAL
    	: '\'' ( ESC_SEQ | ~['\\\n] ) '\''
    	;

STRING_LITERAL
    	: '"' ( ESC_SEQ | ~["\\\n] )* '"'
    	;

fragment ESC_SEQ
    	: '\\' ( 'n' | 't' | 'r' | '\\' | '\'' | '"' )
    	;

// Identifiers
IDENTIFIER
    	: [a-zA-Z] [a-zA-Z0-9_]*
    	;

// Whitespace and Comments
WS
    	: [ \t\r\n]+ -> skip
    	;

LINE_COMMENT
    	: '//' ~[\r\n]* -> skip
    	;

BLOCK_COMMENT
    	: '/*' .*? '*/' -> skip
    	;

