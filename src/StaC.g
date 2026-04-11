grammar StaC;

// Parser Rules

program
	: ( functionDef | declaration )* EOF
	;

//declarations
	: type IDENTIFIER ( '<=' expression | '<==' expression )? ';'
	;

type
	: 'int'
	| 'char'
	;

//functions
functionDef
	: type IDENTIFIER '(' paramList? ')' '{' statement* '}'
	;

paramList
	: param ( ',' param )*
	;

param
	: type IDENTIFIER
	;

// Statements
statement
	: declaration
	| transferStmt
    	| dumpStmt
    	| topSwapStmt
    	| fullSwapStmt
    	| ifStmt
   	| whileStmt
    	| forStmt
    	| returnStmt
    	| builtinCallStmt
    	;
transferStmt
    	: sink '<=' expression ';'
    	;

// Chained dump — right-to-left associative
dumpStmt
	: sink ( '<==' expression )+ ';'
    	;

topSwapStmt
    	: IDENTIFIER '<=>' IDENTIFIER ';'
    	;

fullSwapStmt
    	: IDENTIFIER '<==>' IDENTIFIER ';'
    	;

returnStmt
    	: 'return' ';'
    	;

sink
    	: IDENTIFIER
    	| 'print'
    	;

// Control Flow
ifStmt
    	: 'if' '(' condition ')' '{' statement* '}'
    	  ( 'else' '{' statement* '}' )?
    	;

whileStmt
    	: 'while' '(' condition ')' '{' statement* '}'
    	;

forStmt
    	: 'for' '(' declaration condition ';' forStep ')' '{' statement* '}'
    	;

forStep
    	: IDENTIFIER '<=' expression
    	;

// Conditions — never consume values
condition
    	: expression compOp expression      // comparison
    	| '!' IDENTIFIER                    // logical not: stack is empty
    	| IDENTIFIER                        // truthy: stack is non-empty
    	| 'empty' '(' IDENTIFIER ')'        // explicit empty check
    	| '!' 'empty' '(' IDENTIFIER ')'    // explicit non-empty check
    	;

compOp
    	: '<'
    	| '>'
    	| '='
    	| '!='
    	| '!<'
    	| '!>'
    	;

// Expressions — always consume
expression
    	: term ( ( '+' | '-' ) term )*
    	;

term
    	: factor ( ( '*' | '/' | '%' ) factor )*
    	;

factor
    	: IDENTIFIER
    	| literal
    	| functionCall
    	| builtinExpr
    	| '(' expression ')'
    	;

functionCall
    	: IDENTIFIER '(' argList? ')'
    	;

argList
    	: IDENTIFIER ( ',' IDENTIFIER )*
    	;

builtinExpr
    	: 'randInt' '(' expression ',' expression ')'
    	| 'scanInt' '(' ')'
    	| 'scan' '(' ')'
    	| 'depth' '(' IDENTIFIER ')'
    	;

builtinCallStmt
    	: ( 'dup' | 'pop' ) '(' IDENTIFIER ')' ';'
    	;

// ─── Literals ────────────────────────────────────────────────────────────────
// string_literal is a char stack with the LAST character on top.
// Always use <== to load a full string — <= only pushes the last character.

literal
    	: INT_LITERAL
    	| CHAR_LITERAL
    	| STRING_LITERAL
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

