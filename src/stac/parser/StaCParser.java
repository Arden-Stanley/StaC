// Generated from StaC.g by ANTLR 4.5
package stac.parser;

    import stac.AST.*;
    import java.util.ArrayList;
    import java.util.List;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StaCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, INT=12, CHAR=13, IF=14, ELSE=15, WHILE=16, FOR=17, 
		RETURN=18, PRINT=19, DUP=20, POP=21, EMPTY=22, DEPTH=23, SCAN=24, SCANINT=25, 
		RANDINT=26, FULL_SWAP=27, DUMP=28, TRANSFER=29, TOP_SWAP=30, LTE=31, GTE=32, 
		NEQ=33, LT=34, GT=35, EQ=36, NOT=37, INT_LITERAL=38, CHAR_LITERAL=39, 
		STRING_LITERAL=40, IDENTIFIER=41, WS=42, LINE_COMMENT=43, BLOCK_COMMENT=44;
	public static final int
		RULE_program = 0, RULE_topLevel = 1, RULE_declaration = 2, RULE_type = 3, 
		RULE_functionDef = 4, RULE_paramList = 5, RULE_param = 6, RULE_statement = 7, 
		RULE_transferStmt = 8, RULE_dumpStmt = 9, RULE_topSwapStmt = 10, RULE_fullSwapStmt = 11, 
		RULE_returnStmt = 12, RULE_sink = 13, RULE_block = 14, RULE_ifStmt = 15, 
		RULE_whileStmt = 16, RULE_forStmt = 17, RULE_forStep = 18, RULE_condition = 19, 
		RULE_compOp = 20, RULE_expression = 21, RULE_term = 22, RULE_factor = 23, 
		RULE_functionCall = 24, RULE_argList = 25, RULE_builtinExpr = 26, RULE_builtinCallStmt = 27, 
		RULE_literal = 28;
	public static final String[] ruleNames = {
		"program", "topLevel", "declaration", "type", "functionDef", "paramList", 
		"param", "statement", "transferStmt", "dumpStmt", "topSwapStmt", "fullSwapStmt", 
		"returnStmt", "sink", "block", "ifStmt", "whileStmt", "forStmt", "forStep", 
		"condition", "compOp", "expression", "term", "factor", "functionCall", 
		"argList", "builtinExpr", "builtinCallStmt", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'{'", "'}'", "','", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'int'", "'char'", "'if'", "'else'", "'while'", "'for'", "'return'", 
		"'print'", "'dup'", "'pop'", "'empty'", "'depth'", "'scan'", "'scanInt'", 
		"'randInt'", "'<==>'", "'<=='", "'<='", "'<=>'", "'!>'", "'!<'", "'!='", 
		"'<'", "'>'", "'='", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"INT", "CHAR", "IF", "ELSE", "WHILE", "FOR", "RETURN", "PRINT", "DUP", 
		"POP", "EMPTY", "DEPTH", "SCAN", "SCANINT", "RANDINT", "FULL_SWAP", "DUMP", 
		"TRANSFER", "TOP_SWAP", "LTE", "GTE", "NEQ", "LT", "GT", "EQ", "NOT", 
		"INT_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "IDENTIFIER", "WS", "LINE_COMMENT", 
		"BLOCK_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "StaC.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StaCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public TopLevelContext body;
		public TerminalNode EOF() { return getToken(StaCParser.EOF, 0); }
		public List<TopLevelContext> topLevel() {
			return getRuleContexts(TopLevelContext.class);
		}
		public TopLevelContext topLevel(int i) {
			return getRuleContext(TopLevelContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==CHAR) {
				{
				{
				setState(58);
				((ProgramContext)_localctx).body = topLevel();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(EOF);
			 
			        List<ASTNode> nodes = new ArrayList<>();
			        for (TopLevelContext t : _localctx.topLevel()) nodes.add(t.ast);
			        ((ProgramContext)_localctx).ast =  new Program(nodes);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopLevelContext extends ParserRuleContext {
		public ASTNode ast;
		public FunctionDefContext functionDef;
		public DeclarationContext declaration;
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TopLevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevel; }
	}

	public final TopLevelContext topLevel() throws RecognitionException {
		TopLevelContext _localctx = new TopLevelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevel);
		try {
			setState(73);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				((TopLevelContext)_localctx).functionDef = functionDef();
				 ((TopLevelContext)_localctx).ast =  ((TopLevelContext)_localctx).functionDef.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				((TopLevelContext)_localctx).declaration = declaration();
				 ((TopLevelContext)_localctx).ast =  ((TopLevelContext)_localctx).declaration.ast; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationExp ast;
		public TypeContext t;
		public Token IDENTIFIER;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((DeclarationContext)_localctx).t = type();
				setState(76);
				((DeclarationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(77);
				match(TRANSFER);
				setState(78);
				((DeclarationContext)_localctx).expression = expression();
				setState(79);
				match(T__0);
				 ((DeclarationContext)_localctx).ast =  new DeclarationExp(((DeclarationContext)_localctx).t.text, (((DeclarationContext)_localctx).IDENTIFIER!=null?((DeclarationContext)_localctx).IDENTIFIER.getText():null), ((DeclarationContext)_localctx).expression.ast, false); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((DeclarationContext)_localctx).t = type();
				setState(83);
				((DeclarationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(84);
				match(DUMP);
				setState(85);
				((DeclarationContext)_localctx).expression = expression();
				setState(86);
				match(T__0);
				 ((DeclarationContext)_localctx).ast =  new DeclarationExp(((DeclarationContext)_localctx).t.text, (((DeclarationContext)_localctx).IDENTIFIER!=null?((DeclarationContext)_localctx).IDENTIFIER.getText():null), ((DeclarationContext)_localctx).expression.ast, true); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				((DeclarationContext)_localctx).t = type();
				setState(90);
				((DeclarationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(91);
				match(T__0);
				 ((DeclarationContext)_localctx).ast =  new DeclarationExp(((DeclarationContext)_localctx).t.text, (((DeclarationContext)_localctx).IDENTIFIER!=null?((DeclarationContext)_localctx).IDENTIFIER.getText():null), null, false); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public String text;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(100);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(INT);
				 ((TypeContext)_localctx).text =  "int"; 
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(CHAR);
				 ((TypeContext)_localctx).text =  "char"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefContext extends ParserRuleContext {
		public FunctionDef ast;
		public TypeContext t;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((FunctionDefContext)_localctx).t = type();
			setState(103);
			((FunctionDefContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(104);
			match(T__1);
			setState(106);
			_la = _input.LA(1);
			if (_la==INT || _la==CHAR) {
				{
				setState(105);
				paramList();
				}
			}

			setState(108);
			match(T__2);
			setState(109);
			match(T__3);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << PRINT) | (1L << DUP) | (1L << POP) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(110);
				statement();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			match(T__4);

			        List<Param> params = (_localctx.paramList() != null) ? _localctx.paramList().ast : new ArrayList<>();
			        List<Exp> stmts = new ArrayList<>();
			        for (StatementContext s : _localctx.statement()) stmts.add(s.ast);
			        ((FunctionDefContext)_localctx).ast =  new FunctionDef(((FunctionDefContext)_localctx).t.text, (((FunctionDefContext)_localctx).IDENTIFIER!=null?((FunctionDefContext)_localctx).IDENTIFIER.getText():null), params, stmts);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamListContext extends ParserRuleContext {
		public List<Param> ast;
		public ParamContext first;
		public ParamContext rest;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((ParamListContext)_localctx).first = param();

			        ((ParamListContext)_localctx).ast =  new ArrayList<>();
			        _localctx.ast.add(((ParamListContext)_localctx).first.ast);
			      
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(121);
				match(T__5);
				setState(122);
				((ParamListContext)_localctx).rest = param();
				 _localctx.ast.add(((ParamListContext)_localctx).rest.ast); 
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public Param ast;
		public TypeContext t;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			((ParamContext)_localctx).t = type();
			setState(131);
			((ParamContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 ((ParamContext)_localctx).ast =  new Param(((ParamContext)_localctx).t.text, (((ParamContext)_localctx).IDENTIFIER!=null?((ParamContext)_localctx).IDENTIFIER.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Exp ast;
		public DeclarationContext declaration;
		public TransferStmtContext transferStmt;
		public DumpStmtContext dumpStmt;
		public TopSwapStmtContext topSwapStmt;
		public FullSwapStmtContext fullSwapStmt;
		public IfStmtContext ifStmt;
		public WhileStmtContext whileStmt;
		public ForStmtContext forStmt;
		public ReturnStmtContext returnStmt;
		public BuiltinCallStmtContext builtinCallStmt;
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TransferStmtContext transferStmt() {
			return getRuleContext(TransferStmtContext.class,0);
		}
		public DumpStmtContext dumpStmt() {
			return getRuleContext(DumpStmtContext.class,0);
		}
		public TopSwapStmtContext topSwapStmt() {
			return getRuleContext(TopSwapStmtContext.class,0);
		}
		public FullSwapStmtContext fullSwapStmt() {
			return getRuleContext(FullSwapStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public BuiltinCallStmtContext builtinCallStmt() {
			return getRuleContext(BuiltinCallStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				((StatementContext)_localctx).declaration = declaration();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).declaration.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				((StatementContext)_localctx).transferStmt = transferStmt();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).transferStmt.ast; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				((StatementContext)_localctx).dumpStmt = dumpStmt();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).dumpStmt.ast; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				((StatementContext)_localctx).topSwapStmt = topSwapStmt();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).topSwapStmt.ast; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				((StatementContext)_localctx).fullSwapStmt = fullSwapStmt();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).fullSwapStmt.ast; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(149);
				((StatementContext)_localctx).ifStmt = ifStmt();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).ifStmt.ast; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(152);
				((StatementContext)_localctx).whileStmt = whileStmt();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).whileStmt.ast; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(155);
				((StatementContext)_localctx).forStmt = forStmt();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).forStmt.ast; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(158);
				((StatementContext)_localctx).returnStmt = returnStmt();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).returnStmt.ast; 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(161);
				((StatementContext)_localctx).builtinCallStmt = builtinCallStmt();
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).builtinCallStmt.ast; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransferStmtContext extends ParserRuleContext {
		public TransferExp ast;
		public SinkContext s;
		public ExpressionContext e;
		public SinkContext sink() {
			return getRuleContext(SinkContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TransferStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transferStmt; }
	}

	public final TransferStmtContext transferStmt() throws RecognitionException {
		TransferStmtContext _localctx = new TransferStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_transferStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			((TransferStmtContext)_localctx).s = sink();
			setState(167);
			match(TRANSFER);
			setState(168);
			((TransferStmtContext)_localctx).e = expression();
			setState(169);
			match(T__0);
			 ((TransferStmtContext)_localctx).ast =  new TransferExp(((TransferStmtContext)_localctx).s.text, ((TransferStmtContext)_localctx).e.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DumpStmtContext extends ParserRuleContext {
		public DumpExp ast;
		public SinkContext s;
		public ExpressionContext expression;
		public List<ExpressionContext> sources = new ArrayList<ExpressionContext>();
		public SinkContext sink() {
			return getRuleContext(SinkContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DumpStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dumpStmt; }
	}

	public final DumpStmtContext dumpStmt() throws RecognitionException {
		DumpStmtContext _localctx = new DumpStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dumpStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			((DumpStmtContext)_localctx).s = sink();
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(173);
				match(DUMP);
				setState(174);
				((DumpStmtContext)_localctx).expression = expression();
				((DumpStmtContext)_localctx).sources.add(((DumpStmtContext)_localctx).expression);
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DUMP );
			setState(179);
			match(T__0);

			        List<Exp> srcs = new ArrayList<>();
			        for (ExpressionContext e : ((DumpStmtContext)_localctx).sources) srcs.add(e.ast);
			        ((DumpStmtContext)_localctx).ast =  new DumpExp(((DumpStmtContext)_localctx).s.text, srcs);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopSwapStmtContext extends ParserRuleContext {
		public TopSwapExp ast;
		public Token left;
		public Token right;
		public List<TerminalNode> IDENTIFIER() { return getTokens(StaCParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StaCParser.IDENTIFIER, i);
		}
		public TopSwapStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topSwapStmt; }
	}

	public final TopSwapStmtContext topSwapStmt() throws RecognitionException {
		TopSwapStmtContext _localctx = new TopSwapStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_topSwapStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			((TopSwapStmtContext)_localctx).left = match(IDENTIFIER);
			setState(183);
			match(TOP_SWAP);
			setState(184);
			((TopSwapStmtContext)_localctx).right = match(IDENTIFIER);
			setState(185);
			match(T__0);
			 ((TopSwapStmtContext)_localctx).ast =  new TopSwapExp((((TopSwapStmtContext)_localctx).left!=null?((TopSwapStmtContext)_localctx).left.getText():null), (((TopSwapStmtContext)_localctx).right!=null?((TopSwapStmtContext)_localctx).right.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullSwapStmtContext extends ParserRuleContext {
		public FullSwapExp ast;
		public Token left;
		public Token right;
		public List<TerminalNode> IDENTIFIER() { return getTokens(StaCParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StaCParser.IDENTIFIER, i);
		}
		public FullSwapStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullSwapStmt; }
	}

	public final FullSwapStmtContext fullSwapStmt() throws RecognitionException {
		FullSwapStmtContext _localctx = new FullSwapStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fullSwapStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			((FullSwapStmtContext)_localctx).left = match(IDENTIFIER);
			setState(189);
			match(FULL_SWAP);
			setState(190);
			((FullSwapStmtContext)_localctx).right = match(IDENTIFIER);
			setState(191);
			match(T__0);
			 ((FullSwapStmtContext)_localctx).ast =  new FullSwapExp((((FullSwapStmtContext)_localctx).left!=null?((FullSwapStmtContext)_localctx).left.getText():null), (((FullSwapStmtContext)_localctx).right!=null?((FullSwapStmtContext)_localctx).right.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStmtContext extends ParserRuleContext {
		public ReturnExp ast;
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(RETURN);
			setState(195);
			match(T__0);
			 ((ReturnStmtContext)_localctx).ast =  new ReturnExp(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SinkContext extends ParserRuleContext {
		public String text;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public SinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sink; }
	}

	public final SinkContext sink() throws RecognitionException {
		SinkContext _localctx = new SinkContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sink);
		try {
			setState(202);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				((SinkContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((SinkContext)_localctx).text =  (((SinkContext)_localctx).IDENTIFIER!=null?((SinkContext)_localctx).IDENTIFIER.getText():null); 
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(PRINT);
				 ((SinkContext)_localctx).text =  "print"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<Exp> ast;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__3);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << PRINT) | (1L << DUP) | (1L << POP) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(205);
				statement();
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(211);
			match(T__4);

			      ((BlockContext)_localctx).ast =  new ArrayList<>();
			      for (StatementContext s : _localctx.statement()) _localctx.ast.add(s.ast);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public IfExp ast;
		public ConditionContext c;
		public BlockContext thenBlock;
		public BlockContext elseBlock;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(IF);
			setState(215);
			match(T__1);
			setState(216);
			((IfStmtContext)_localctx).c = condition();
			setState(217);
			match(T__2);
			setState(218);
			((IfStmtContext)_localctx).thenBlock = block();
			setState(221);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(219);
				match(ELSE);
				setState(220);
				((IfStmtContext)_localctx).elseBlock = block();
				}
			}


			        List<Exp> elseStmts = (_localctx.elseBlock != null) ? _localctx.elseBlock.ast : null;
			        ((IfStmtContext)_localctx).ast =  new IfExp(((IfStmtContext)_localctx).c.ast, _localctx.thenBlock.ast, elseStmts);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtContext extends ParserRuleContext {
		public WhileExp ast;
		public ConditionContext c;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(WHILE);
			setState(226);
			match(T__1);
			setState(227);
			((WhileStmtContext)_localctx).c = condition();
			setState(228);
			match(T__2);
			setState(229);
			block();

			        ((WhileStmtContext)_localctx).ast =  new WhileExp(((WhileStmtContext)_localctx).c.ast, _localctx.block().ast);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStmtContext extends ParserRuleContext {
		public ForExp ast;
		public DeclarationContext init;
		public ConditionContext c;
		public ForStepContext step;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ForStepContext forStep() {
			return getRuleContext(ForStepContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(FOR);
			setState(233);
			match(T__1);
			setState(234);
			((ForStmtContext)_localctx).init = declaration();
			setState(235);
			((ForStmtContext)_localctx).c = condition();
			setState(236);
			match(T__0);
			setState(237);
			((ForStmtContext)_localctx).step = forStep();
			setState(238);
			match(T__2);
			setState(239);
			block();

			        ((ForStmtContext)_localctx).ast =  new ForExp(((ForStmtContext)_localctx).init.ast, ((ForStmtContext)_localctx).c.ast, ((ForStmtContext)_localctx).step.ast, _localctx.block().ast);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStepContext extends ParserRuleContext {
		public TransferExp ast;
		public Token IDENTIFIER;
		public ExpressionContext e;
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStep; }
	}

	public final ForStepContext forStep() throws RecognitionException {
		ForStepContext _localctx = new ForStepContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			((ForStepContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(243);
			match(TRANSFER);
			setState(244);
			((ForStepContext)_localctx).e = expression();
			 ((ForStepContext)_localctx).ast =  new TransferExp((((ForStepContext)_localctx).IDENTIFIER!=null?((ForStepContext)_localctx).IDENTIFIER.getText():null), ((ForStepContext)_localctx).e.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public Condition ast;
		public ExpressionContext left;
		public CompOpContext op;
		public ExpressionContext right;
		public Token IDENTIFIER;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condition);
		try {
			setState(268);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				((ConditionContext)_localctx).left = expression();
				setState(248);
				((ConditionContext)_localctx).op = compOp();
				setState(249);
				((ConditionContext)_localctx).right = expression();
				 ((ConditionContext)_localctx).ast =  new ComparisonCondition(((ConditionContext)_localctx).left.ast, ((ConditionContext)_localctx).op.text, ((ConditionContext)_localctx).right.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				match(NOT);
				setState(253);
				((ConditionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((ConditionContext)_localctx).ast =  new EmptyCondition((((ConditionContext)_localctx).IDENTIFIER!=null?((ConditionContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				((ConditionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((ConditionContext)_localctx).ast =  new TruthyCondition((((ConditionContext)_localctx).IDENTIFIER!=null?((ConditionContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				match(EMPTY);
				setState(258);
				match(T__1);
				setState(259);
				((ConditionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(260);
				match(T__2);
				 ((ConditionContext)_localctx).ast =  new EmptyCondition((((ConditionContext)_localctx).IDENTIFIER!=null?((ConditionContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(262);
				match(NOT);
				setState(263);
				match(EMPTY);
				setState(264);
				match(T__1);
				setState(265);
				((ConditionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(266);
				match(T__2);
				 ((ConditionContext)_localctx).ast =  new TruthyCondition((((ConditionContext)_localctx).IDENTIFIER!=null?((ConditionContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public String text;
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_compOp);
		try {
			setState(282);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				match(LT);
				 ((CompOpContext)_localctx).text =  "<"; 
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(GT);
				 ((CompOpContext)_localctx).text =  ">"; 
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				match(EQ);
				 ((CompOpContext)_localctx).text =  "="; 
				}
				break;
			case NEQ:
				enterOuterAlt(_localctx, 4);
				{
				setState(276);
				match(NEQ);
				 ((CompOpContext)_localctx).text =  "!="; 
				}
				break;
			case GTE:
				enterOuterAlt(_localctx, 5);
				{
				setState(278);
				match(GTE);
				 ((CompOpContext)_localctx).text =  "!<"; 
				}
				break;
			case LTE:
				enterOuterAlt(_localctx, 6);
				{
				setState(280);
				match(LTE);
				 ((CompOpContext)_localctx).text =  "!>"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Exp ast;
		public TermContext left;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			((ExpressionContext)_localctx).left = term();
			 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).left.ast; 
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__7) {
				{
				setState(294);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(286);
					match(T__6);
					setState(287);
					((ExpressionContext)_localctx).right = term();
					 ((ExpressionContext)_localctx).ast =  new AddExp(_localctx.ast, ((ExpressionContext)_localctx).right.ast); 
					}
					break;
				case T__7:
					{
					setState(290);
					match(T__7);
					setState(291);
					((ExpressionContext)_localctx).right = term();
					 ((ExpressionContext)_localctx).ast =  new SubExp(_localctx.ast, ((ExpressionContext)_localctx).right.ast); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public Exp ast;
		public FactorContext left;
		public FactorContext right;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			((TermContext)_localctx).left = factor();
			 ((TermContext)_localctx).ast =  ((TermContext)_localctx).left.ast; 
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) {
				{
				setState(313);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(301);
					match(T__8);
					setState(302);
					((TermContext)_localctx).right = factor();
					 ((TermContext)_localctx).ast =  new MulExp(_localctx.ast, ((TermContext)_localctx).right.ast); 
					}
					break;
				case T__9:
					{
					setState(305);
					match(T__9);
					setState(306);
					((TermContext)_localctx).right = factor();
					 ((TermContext)_localctx).ast =  new DivExp(_localctx.ast, ((TermContext)_localctx).right.ast); 
					}
					break;
				case T__10:
					{
					setState(309);
					match(T__10);
					setState(310);
					((TermContext)_localctx).right = factor();
					 ((TermContext)_localctx).ast =  new ModExp(_localctx.ast, ((TermContext)_localctx).right.ast); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public Exp ast;
		public Token IDENTIFIER;
		public LiteralContext literal;
		public FunctionCallContext functionCall;
		public BuiltinExprContext builtinExpr;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public BuiltinExprContext builtinExpr() {
			return getRuleContext(BuiltinExprContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_factor);
		try {
			setState(334);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				((FactorContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((FactorContext)_localctx).ast =  new VarExp((((FactorContext)_localctx).IDENTIFIER!=null?((FactorContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				((FactorContext)_localctx).literal = literal();
				 ((FactorContext)_localctx).ast =  ((FactorContext)_localctx).literal.ast; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(323);
				((FactorContext)_localctx).functionCall = functionCall();
				 ((FactorContext)_localctx).ast =  ((FactorContext)_localctx).functionCall.ast; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(326);
				((FactorContext)_localctx).builtinExpr = builtinExpr();
				 ((FactorContext)_localctx).ast =  ((FactorContext)_localctx).builtinExpr.ast; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(329);
				match(T__1);
				setState(330);
				((FactorContext)_localctx).expression = expression();
				setState(331);
				match(T__2);
				 ((FactorContext)_localctx).ast =  ((FactorContext)_localctx).expression.ast; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallExp ast;
		public Token IDENTIFIER;
		public ArgListContext a;
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			((FunctionCallContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(337);
			match(T__1);
			setState(339);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(338);
				((FunctionCallContext)_localctx).a = argList();
				}
			}

			setState(341);
			match(T__2);

			        List<String> args = (_localctx.argList() != null) ? _localctx.argList().ast : new ArrayList<>();
			        ((FunctionCallContext)_localctx).ast =  new FunctionCallExp((((FunctionCallContext)_localctx).IDENTIFIER!=null?((FunctionCallContext)_localctx).IDENTIFIER.getText():null), args);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public List<String> ast;
		public Token first;
		public Token rest;
		public List<TerminalNode> IDENTIFIER() { return getTokens(StaCParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StaCParser.IDENTIFIER, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			((ArgListContext)_localctx).first = match(IDENTIFIER);

			        ((ArgListContext)_localctx).ast =  new ArrayList<>();
			        _localctx.ast.add((((ArgListContext)_localctx).first!=null?((ArgListContext)_localctx).first.getText():null));
			      
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(346);
				match(T__5);
				setState(347);
				((ArgListContext)_localctx).rest = match(IDENTIFIER);
				 _localctx.ast.add((((ArgListContext)_localctx).rest!=null?((ArgListContext)_localctx).rest.getText():null)); 
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltinExprContext extends ParserRuleContext {
		public Exp ast;
		public ExpressionContext min;
		public ExpressionContext max;
		public Token IDENTIFIER;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public BuiltinExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinExpr; }
	}

	public final BuiltinExprContext builtinExpr() throws RecognitionException {
		BuiltinExprContext _localctx = new BuiltinExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_builtinExpr);
		try {
			setState(375);
			switch (_input.LA(1)) {
			case RANDINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				match(RANDINT);
				setState(355);
				match(T__1);
				setState(356);
				((BuiltinExprContext)_localctx).min = expression();
				setState(357);
				match(T__5);
				setState(358);
				((BuiltinExprContext)_localctx).max = expression();
				setState(359);
				match(T__2);
				 ((BuiltinExprContext)_localctx).ast =  new RandIntExp(((BuiltinExprContext)_localctx).min.ast, ((BuiltinExprContext)_localctx).max.ast); 
				}
				break;
			case SCANINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(SCANINT);
				setState(363);
				match(T__1);
				setState(364);
				match(T__2);
				 ((BuiltinExprContext)_localctx).ast =  new ScanIntExp(); 
				}
				break;
			case SCAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(366);
				match(SCAN);
				setState(367);
				match(T__1);
				setState(368);
				match(T__2);
				 ((BuiltinExprContext)_localctx).ast =  new ScanExp(); 
				}
				break;
			case DEPTH:
				enterOuterAlt(_localctx, 4);
				{
				setState(370);
				match(DEPTH);
				setState(371);
				match(T__1);
				setState(372);
				((BuiltinExprContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(373);
				match(T__2);
				 ((BuiltinExprContext)_localctx).ast =  new DepthExp((((BuiltinExprContext)_localctx).IDENTIFIER!=null?((BuiltinExprContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltinCallStmtContext extends ParserRuleContext {
		public Exp ast;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(StaCParser.IDENTIFIER, 0); }
		public BuiltinCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinCallStmt; }
	}

	public final BuiltinCallStmtContext builtinCallStmt() throws RecognitionException {
		BuiltinCallStmtContext _localctx = new BuiltinCallStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_builtinCallStmt);
		try {
			setState(389);
			switch (_input.LA(1)) {
			case DUP:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(DUP);
				setState(378);
				match(T__1);
				setState(379);
				((BuiltinCallStmtContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(380);
				match(T__2);
				setState(381);
				match(T__0);
				 ((BuiltinCallStmtContext)_localctx).ast =  new DupExp((((BuiltinCallStmtContext)_localctx).IDENTIFIER!=null?((BuiltinCallStmtContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case POP:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				match(POP);
				setState(384);
				match(T__1);
				setState(385);
				((BuiltinCallStmtContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(386);
				match(T__2);
				setState(387);
				match(T__0);
				 ((BuiltinCallStmtContext)_localctx).ast =  new PopExp((((BuiltinCallStmtContext)_localctx).IDENTIFIER!=null?((BuiltinCallStmtContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public Exp ast;
		public Token INT_LITERAL;
		public Token CHAR_LITERAL;
		public Token STRING_LITERAL;
		public TerminalNode INT_LITERAL() { return getToken(StaCParser.INT_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(StaCParser.CHAR_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(StaCParser.STRING_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_literal);
		try {
			setState(397);
			switch (_input.LA(1)) {
			case INT_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				((LiteralContext)_localctx).INT_LITERAL = match(INT_LITERAL);
				 ((LiteralContext)_localctx).ast =  new IntLiteralExp(Integer.parseInt((((LiteralContext)_localctx).INT_LITERAL!=null?((LiteralContext)_localctx).INT_LITERAL.getText():null))); 
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				((LiteralContext)_localctx).CHAR_LITERAL = match(CHAR_LITERAL);

				        // strip surrounding quotes and handle escape sequences
				        String raw = (((LiteralContext)_localctx).CHAR_LITERAL!=null?((LiteralContext)_localctx).CHAR_LITERAL.getText():null);
				        raw = raw.substring(1, raw.length() - 1);
				        char val = raw.equals("\\n") ? '\n'
				                 : raw.equals("\\t") ? '\t'
				                 : raw.equals("\\r") ? '\r'
				                 : raw.equals("\\\\") ? '\\'
				                 : raw.equals("\\'") ? '\''
				                 : raw.equals("\\\"") ? '"'
				                 : raw.charAt(0);
				        ((LiteralContext)_localctx).ast =  new CharLiteralExp(val);
				      
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(395);
				((LiteralContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);

				        // strip surrounding quotes
				        String raw = (((LiteralContext)_localctx).STRING_LITERAL!=null?((LiteralContext)_localctx).STRING_LITERAL.getText():null);
				        raw = raw.substring(1, raw.length() - 1);
				        ((LiteralContext)_localctx).ast =  new StringLiteralExp(raw);
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u0192\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\7\2>\n\2\f\2\16"+
		"\2A\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3L\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4a\n\4"+
		"\3\5\3\5\3\5\3\5\5\5g\n\5\3\6\3\6\3\6\3\6\5\6m\n\6\3\6\3\6\3\6\7\6r\n"+
		"\6\f\6\16\6u\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0080\n\7\f"+
		"\7\16\7\u0083\13\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\t\u00a7\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\6"+
		"\13\u00b2\n\13\r\13\16\13\u00b3\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17"+
		"\u00cd\n\17\3\20\3\20\7\20\u00d1\n\20\f\20\16\20\u00d4\13\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e0\n\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u010f\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u011d\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\7\27\u0129\n\27\f\27\16\27\u012c\13\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u013c\n\30\f\30\16\30\u013f"+
		"\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0151\n\31\3\32\3\32\3\32\5\32\u0156\n\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\33\7\33\u0160\n\33\f\33\16\33\u0163\13"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u017a\n\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0188\n\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u0190\n\36\3\36\2\2\37\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\2\u01a3\2?\3\2\2\2\4K\3\2"+
		"\2\2\6`\3\2\2\2\bf\3\2\2\2\nh\3\2\2\2\fy\3\2\2\2\16\u0084\3\2\2\2\20\u00a6"+
		"\3\2\2\2\22\u00a8\3\2\2\2\24\u00ae\3\2\2\2\26\u00b8\3\2\2\2\30\u00be\3"+
		"\2\2\2\32\u00c4\3\2\2\2\34\u00cc\3\2\2\2\36\u00ce\3\2\2\2 \u00d8\3\2\2"+
		"\2\"\u00e3\3\2\2\2$\u00ea\3\2\2\2&\u00f4\3\2\2\2(\u010e\3\2\2\2*\u011c"+
		"\3\2\2\2,\u011e\3\2\2\2.\u012d\3\2\2\2\60\u0150\3\2\2\2\62\u0152\3\2\2"+
		"\2\64\u015a\3\2\2\2\66\u0179\3\2\2\28\u0187\3\2\2\2:\u018f\3\2\2\2<>\5"+
		"\4\3\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7"+
		"\2\2\3CD\b\2\1\2D\3\3\2\2\2EF\5\n\6\2FG\b\3\1\2GL\3\2\2\2HI\5\6\4\2IJ"+
		"\b\3\1\2JL\3\2\2\2KE\3\2\2\2KH\3\2\2\2L\5\3\2\2\2MN\5\b\5\2NO\7+\2\2O"+
		"P\7\37\2\2PQ\5,\27\2QR\7\3\2\2RS\b\4\1\2Sa\3\2\2\2TU\5\b\5\2UV\7+\2\2"+
		"VW\7\36\2\2WX\5,\27\2XY\7\3\2\2YZ\b\4\1\2Za\3\2\2\2[\\\5\b\5\2\\]\7+\2"+
		"\2]^\7\3\2\2^_\b\4\1\2_a\3\2\2\2`M\3\2\2\2`T\3\2\2\2`[\3\2\2\2a\7\3\2"+
		"\2\2bc\7\16\2\2cg\b\5\1\2de\7\17\2\2eg\b\5\1\2fb\3\2\2\2fd\3\2\2\2g\t"+
		"\3\2\2\2hi\5\b\5\2ij\7+\2\2jl\7\4\2\2km\5\f\7\2lk\3\2\2\2lm\3\2\2\2mn"+
		"\3\2\2\2no\7\5\2\2os\7\6\2\2pr\5\20\t\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2"+
		"st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7\7\2\2wx\b\6\1\2x\13\3\2\2\2yz\5\16"+
		"\b\2z\u0081\b\7\1\2{|\7\b\2\2|}\5\16\b\2}~\b\7\1\2~\u0080\3\2\2\2\177"+
		"{\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\r\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\5\b\5\2\u0085\u0086\7+\2\2"+
		"\u0086\u0087\b\b\1\2\u0087\17\3\2\2\2\u0088\u0089\5\6\4\2\u0089\u008a"+
		"\b\t\1\2\u008a\u00a7\3\2\2\2\u008b\u008c\5\22\n\2\u008c\u008d\b\t\1\2"+
		"\u008d\u00a7\3\2\2\2\u008e\u008f\5\24\13\2\u008f\u0090\b\t\1\2\u0090\u00a7"+
		"\3\2\2\2\u0091\u0092\5\26\f\2\u0092\u0093\b\t\1\2\u0093\u00a7\3\2\2\2"+
		"\u0094\u0095\5\30\r\2\u0095\u0096\b\t\1\2\u0096\u00a7\3\2\2\2\u0097\u0098"+
		"\5 \21\2\u0098\u0099\b\t\1\2\u0099\u00a7\3\2\2\2\u009a\u009b\5\"\22\2"+
		"\u009b\u009c\b\t\1\2\u009c\u00a7\3\2\2\2\u009d\u009e\5$\23\2\u009e\u009f"+
		"\b\t\1\2\u009f\u00a7\3\2\2\2\u00a0\u00a1\5\32\16\2\u00a1\u00a2\b\t\1\2"+
		"\u00a2\u00a7\3\2\2\2\u00a3\u00a4\58\35\2\u00a4\u00a5\b\t\1\2\u00a5\u00a7"+
		"\3\2\2\2\u00a6\u0088\3\2\2\2\u00a6\u008b\3\2\2\2\u00a6\u008e\3\2\2\2\u00a6"+
		"\u0091\3\2\2\2\u00a6\u0094\3\2\2\2\u00a6\u0097\3\2\2\2\u00a6\u009a\3\2"+
		"\2\2\u00a6\u009d\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a7"+
		"\21\3\2\2\2\u00a8\u00a9\5\34\17\2\u00a9\u00aa\7\37\2\2\u00aa\u00ab\5,"+
		"\27\2\u00ab\u00ac\7\3\2\2\u00ac\u00ad\b\n\1\2\u00ad\23\3\2\2\2\u00ae\u00b1"+
		"\5\34\17\2\u00af\u00b0\7\36\2\2\u00b0\u00b2\5,\27\2\u00b1\u00af\3\2\2"+
		"\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\u00b6\7\3\2\2\u00b6\u00b7\b\13\1\2\u00b7\25\3\2\2\2\u00b8"+
		"\u00b9\7+\2\2\u00b9\u00ba\7 \2\2\u00ba\u00bb\7+\2\2\u00bb\u00bc\7\3\2"+
		"\2\u00bc\u00bd\b\f\1\2\u00bd\27\3\2\2\2\u00be\u00bf\7+\2\2\u00bf\u00c0"+
		"\7\35\2\2\u00c0\u00c1\7+\2\2\u00c1\u00c2\7\3\2\2\u00c2\u00c3\b\r\1\2\u00c3"+
		"\31\3\2\2\2\u00c4\u00c5\7\24\2\2\u00c5\u00c6\7\3\2\2\u00c6\u00c7\b\16"+
		"\1\2\u00c7\33\3\2\2\2\u00c8\u00c9\7+\2\2\u00c9\u00cd\b\17\1\2\u00ca\u00cb"+
		"\7\25\2\2\u00cb\u00cd\b\17\1\2\u00cc\u00c8\3\2\2\2\u00cc\u00ca\3\2\2\2"+
		"\u00cd\35\3\2\2\2\u00ce\u00d2\7\6\2\2\u00cf\u00d1\5\20\t\2\u00d0\u00cf"+
		"\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7\7\2\2\u00d6\u00d7\b\20"+
		"\1\2\u00d7\37\3\2\2\2\u00d8\u00d9\7\20\2\2\u00d9\u00da\7\4\2\2\u00da\u00db"+
		"\5(\25\2\u00db\u00dc\7\5\2\2\u00dc\u00df\5\36\20\2\u00dd\u00de\7\21\2"+
		"\2\u00de\u00e0\5\36\20\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e2\b\21\1\2\u00e2!\3\2\2\2\u00e3\u00e4\7\22\2"+
		"\2\u00e4\u00e5\7\4\2\2\u00e5\u00e6\5(\25\2\u00e6\u00e7\7\5\2\2\u00e7\u00e8"+
		"\5\36\20\2\u00e8\u00e9\b\22\1\2\u00e9#\3\2\2\2\u00ea\u00eb\7\23\2\2\u00eb"+
		"\u00ec\7\4\2\2\u00ec\u00ed\5\6\4\2\u00ed\u00ee\5(\25\2\u00ee\u00ef\7\3"+
		"\2\2\u00ef\u00f0\5&\24\2\u00f0\u00f1\7\5\2\2\u00f1\u00f2\5\36\20\2\u00f2"+
		"\u00f3\b\23\1\2\u00f3%\3\2\2\2\u00f4\u00f5\7+\2\2\u00f5\u00f6\7\37\2\2"+
		"\u00f6\u00f7\5,\27\2\u00f7\u00f8\b\24\1\2\u00f8\'\3\2\2\2\u00f9\u00fa"+
		"\5,\27\2\u00fa\u00fb\5*\26\2\u00fb\u00fc\5,\27\2\u00fc\u00fd\b\25\1\2"+
		"\u00fd\u010f\3\2\2\2\u00fe\u00ff\7\'\2\2\u00ff\u0100\7+\2\2\u0100\u010f"+
		"\b\25\1\2\u0101\u0102\7+\2\2\u0102\u010f\b\25\1\2\u0103\u0104\7\30\2\2"+
		"\u0104\u0105\7\4\2\2\u0105\u0106\7+\2\2\u0106\u0107\7\5\2\2\u0107\u010f"+
		"\b\25\1\2\u0108\u0109\7\'\2\2\u0109\u010a\7\30\2\2\u010a\u010b\7\4\2\2"+
		"\u010b\u010c\7+\2\2\u010c\u010d\7\5\2\2\u010d\u010f\b\25\1\2\u010e\u00f9"+
		"\3\2\2\2\u010e\u00fe\3\2\2\2\u010e\u0101\3\2\2\2\u010e\u0103\3\2\2\2\u010e"+
		"\u0108\3\2\2\2\u010f)\3\2\2\2\u0110\u0111\7$\2\2\u0111\u011d\b\26\1\2"+
		"\u0112\u0113\7%\2\2\u0113\u011d\b\26\1\2\u0114\u0115\7&\2\2\u0115\u011d"+
		"\b\26\1\2\u0116\u0117\7#\2\2\u0117\u011d\b\26\1\2\u0118\u0119\7\"\2\2"+
		"\u0119\u011d\b\26\1\2\u011a\u011b\7!\2\2\u011b\u011d\b\26\1\2\u011c\u0110"+
		"\3\2\2\2\u011c\u0112\3\2\2\2\u011c\u0114\3\2\2\2\u011c\u0116\3\2\2\2\u011c"+
		"\u0118\3\2\2\2\u011c\u011a\3\2\2\2\u011d+\3\2\2\2\u011e\u011f\5.\30\2"+
		"\u011f\u012a\b\27\1\2\u0120\u0121\7\t\2\2\u0121\u0122\5.\30\2\u0122\u0123"+
		"\b\27\1\2\u0123\u0129\3\2\2\2\u0124\u0125\7\n\2\2\u0125\u0126\5.\30\2"+
		"\u0126\u0127\b\27\1\2\u0127\u0129\3\2\2\2\u0128\u0120\3\2\2\2\u0128\u0124"+
		"\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"-\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\5\60\31\2\u012e\u013d\b\30\1"+
		"\2\u012f\u0130\7\13\2\2\u0130\u0131\5\60\31\2\u0131\u0132\b\30\1\2\u0132"+
		"\u013c\3\2\2\2\u0133\u0134\7\f\2\2\u0134\u0135\5\60\31\2\u0135\u0136\b"+
		"\30\1\2\u0136\u013c\3\2\2\2\u0137\u0138\7\r\2\2\u0138\u0139\5\60\31\2"+
		"\u0139\u013a\b\30\1\2\u013a\u013c\3\2\2\2\u013b\u012f\3\2\2\2\u013b\u0133"+
		"\3\2\2\2\u013b\u0137\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e/\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\7+\2\2\u0141"+
		"\u0151\b\31\1\2\u0142\u0143\5:\36\2\u0143\u0144\b\31\1\2\u0144\u0151\3"+
		"\2\2\2\u0145\u0146\5\62\32\2\u0146\u0147\b\31\1\2\u0147\u0151\3\2\2\2"+
		"\u0148\u0149\5\66\34\2\u0149\u014a\b\31\1\2\u014a\u0151\3\2\2\2\u014b"+
		"\u014c\7\4\2\2\u014c\u014d\5,\27\2\u014d\u014e\7\5\2\2\u014e\u014f\b\31"+
		"\1\2\u014f\u0151\3\2\2\2\u0150\u0140\3\2\2\2\u0150\u0142\3\2\2\2\u0150"+
		"\u0145\3\2\2\2\u0150\u0148\3\2\2\2\u0150\u014b\3\2\2\2\u0151\61\3\2\2"+
		"\2\u0152\u0153\7+\2\2\u0153\u0155\7\4\2\2\u0154\u0156\5\64\33\2\u0155"+
		"\u0154\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\7\5"+
		"\2\2\u0158\u0159\b\32\1\2\u0159\63\3\2\2\2\u015a\u015b\7+\2\2\u015b\u0161"+
		"\b\33\1\2\u015c\u015d\7\b\2\2\u015d\u015e\7+\2\2\u015e\u0160\b\33\1\2"+
		"\u015f\u015c\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162"+
		"\3\2\2\2\u0162\65\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165\7\34\2\2\u0165"+
		"\u0166\7\4\2\2\u0166\u0167\5,\27\2\u0167\u0168\7\b\2\2\u0168\u0169\5,"+
		"\27\2\u0169\u016a\7\5\2\2\u016a\u016b\b\34\1\2\u016b\u017a\3\2\2\2\u016c"+
		"\u016d\7\33\2\2\u016d\u016e\7\4\2\2\u016e\u016f\7\5\2\2\u016f\u017a\b"+
		"\34\1\2\u0170\u0171\7\32\2\2\u0171\u0172\7\4\2\2\u0172\u0173\7\5\2\2\u0173"+
		"\u017a\b\34\1\2\u0174\u0175\7\31\2\2\u0175\u0176\7\4\2\2\u0176\u0177\7"+
		"+\2\2\u0177\u0178\7\5\2\2\u0178\u017a\b\34\1\2\u0179\u0164\3\2\2\2\u0179"+
		"\u016c\3\2\2\2\u0179\u0170\3\2\2\2\u0179\u0174\3\2\2\2\u017a\67\3\2\2"+
		"\2\u017b\u017c\7\26\2\2\u017c\u017d\7\4\2\2\u017d\u017e\7+\2\2\u017e\u017f"+
		"\7\5\2\2\u017f\u0180\7\3\2\2\u0180\u0188\b\35\1\2\u0181\u0182\7\27\2\2"+
		"\u0182\u0183\7\4\2\2\u0183\u0184\7+\2\2\u0184\u0185\7\5\2\2\u0185\u0186"+
		"\7\3\2\2\u0186\u0188\b\35\1\2\u0187\u017b\3\2\2\2\u0187\u0181\3\2\2\2"+
		"\u01889\3\2\2\2\u0189\u018a\7(\2\2\u018a\u0190\b\36\1\2\u018b\u018c\7"+
		")\2\2\u018c\u0190\b\36\1\2\u018d\u018e\7*\2\2\u018e\u0190\b\36\1\2\u018f"+
		"\u0189\3\2\2\2\u018f\u018b\3\2\2\2\u018f\u018d\3\2\2\2\u0190;\3\2\2\2"+
		"\32?K`fls\u0081\u00a6\u00b3\u00cc\u00d2\u00df\u010e\u011c\u0128\u012a"+
		"\u013b\u013d\u0150\u0155\u0161\u0179\u0187\u018f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}