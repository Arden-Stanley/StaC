// Generated from StaC.g by ANTLR 4.5
package stac.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StaCLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "INT", "CHAR", "IF", "ELSE", "WHILE", "FOR", "RETURN", 
		"PRINT", "DUP", "POP", "EMPTY", "DEPTH", "SCAN", "SCANINT", "RANDINT", 
		"FULL_SWAP", "DUMP", "TRANSFER", "TOP_SWAP", "LTE", "GTE", "NEQ", "LT", 
		"GT", "EQ", "NOT", "INT_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "ESC_SEQ", 
		"IDENTIFIER", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
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


	public StaCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "StaC.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2.\u0125\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\6\'\u00e7\n\'\r\'\16\'\u00e8\3(\3(\3(\5(\u00ee\n(\3"+
		"(\3(\3)\3)\3)\7)\u00f5\n)\f)\16)\u00f8\13)\3)\3)\3*\3*\3*\3+\3+\7+\u0101"+
		"\n+\f+\16+\u0104\13+\3,\6,\u0107\n,\r,\16,\u0108\3,\3,\3-\3-\3-\3-\7-"+
		"\u0111\n-\f-\16-\u0114\13-\3-\3-\3.\3.\3.\3.\7.\u011c\n.\f.\16.\u011f"+
		"\13.\3.\3.\3.\3.\3.\3\u011d\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S\2U+W,Y-[.\3\2\n"+
		"\3\2\62;\5\2\f\f))^^\5\2\f\f$$^^\b\2$$))^^ppttvv\4\2C\\c|\6\2\62;C\\a"+
		"ac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u012b\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\3]\3\2\2\2\5_\3\2\2\2\7a\3\2\2\2\tc\3\2\2\2\13e\3\2\2\2\rg\3\2\2"+
		"\2\17i\3\2\2\2\21k\3\2\2\2\23m\3\2\2\2\25o\3\2\2\2\27q\3\2\2\2\31s\3\2"+
		"\2\2\33w\3\2\2\2\35|\3\2\2\2\37\177\3\2\2\2!\u0084\3\2\2\2#\u008a\3\2"+
		"\2\2%\u008e\3\2\2\2\'\u0095\3\2\2\2)\u009b\3\2\2\2+\u009f\3\2\2\2-\u00a3"+
		"\3\2\2\2/\u00a9\3\2\2\2\61\u00af\3\2\2\2\63\u00b4\3\2\2\2\65\u00bc\3\2"+
		"\2\2\67\u00c4\3\2\2\29\u00c9\3\2\2\2;\u00cd\3\2\2\2=\u00d0\3\2\2\2?\u00d4"+
		"\3\2\2\2A\u00d7\3\2\2\2C\u00da\3\2\2\2E\u00dd\3\2\2\2G\u00df\3\2\2\2I"+
		"\u00e1\3\2\2\2K\u00e3\3\2\2\2M\u00e6\3\2\2\2O\u00ea\3\2\2\2Q\u00f1\3\2"+
		"\2\2S\u00fb\3\2\2\2U\u00fe\3\2\2\2W\u0106\3\2\2\2Y\u010c\3\2\2\2[\u0117"+
		"\3\2\2\2]^\7=\2\2^\4\3\2\2\2_`\7*\2\2`\6\3\2\2\2ab\7+\2\2b\b\3\2\2\2c"+
		"d\7}\2\2d\n\3\2\2\2ef\7\177\2\2f\f\3\2\2\2gh\7.\2\2h\16\3\2\2\2ij\7-\2"+
		"\2j\20\3\2\2\2kl\7/\2\2l\22\3\2\2\2mn\7,\2\2n\24\3\2\2\2op\7\61\2\2p\26"+
		"\3\2\2\2qr\7\'\2\2r\30\3\2\2\2st\7k\2\2tu\7p\2\2uv\7v\2\2v\32\3\2\2\2"+
		"wx\7e\2\2xy\7j\2\2yz\7c\2\2z{\7t\2\2{\34\3\2\2\2|}\7k\2\2}~\7h\2\2~\36"+
		"\3\2\2\2\177\u0080\7g\2\2\u0080\u0081\7n\2\2\u0081\u0082\7u\2\2\u0082"+
		"\u0083\7g\2\2\u0083 \3\2\2\2\u0084\u0085\7y\2\2\u0085\u0086\7j\2\2\u0086"+
		"\u0087\7k\2\2\u0087\u0088\7n\2\2\u0088\u0089\7g\2\2\u0089\"\3\2\2\2\u008a"+
		"\u008b\7h\2\2\u008b\u008c\7q\2\2\u008c\u008d\7t\2\2\u008d$\3\2\2\2\u008e"+
		"\u008f\7t\2\2\u008f\u0090\7g\2\2\u0090\u0091\7v\2\2\u0091\u0092\7w\2\2"+
		"\u0092\u0093\7t\2\2\u0093\u0094\7p\2\2\u0094&\3\2\2\2\u0095\u0096\7r\2"+
		"\2\u0096\u0097\7t\2\2\u0097\u0098\7k\2\2\u0098\u0099\7p\2\2\u0099\u009a"+
		"\7v\2\2\u009a(\3\2\2\2\u009b\u009c\7f\2\2\u009c\u009d\7w\2\2\u009d\u009e"+
		"\7r\2\2\u009e*\3\2\2\2\u009f\u00a0\7r\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2"+
		"\7r\2\2\u00a2,\3\2\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7o\2\2\u00a5\u00a6"+
		"\7r\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7{\2\2\u00a8.\3\2\2\2\u00a9\u00aa"+
		"\7f\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7r\2\2\u00ac\u00ad\7v\2\2\u00ad"+
		"\u00ae\7j\2\2\u00ae\60\3\2\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1\7e\2\2\u00b1"+
		"\u00b2\7c\2\2\u00b2\u00b3\7p\2\2\u00b3\62\3\2\2\2\u00b4\u00b5\7u\2\2\u00b5"+
		"\u00b6\7e\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7K\2\2"+
		"\u00b9\u00ba\7p\2\2\u00ba\u00bb\7v\2\2\u00bb\64\3\2\2\2\u00bc\u00bd\7"+
		"t\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7f\2\2\u00c0\u00c1"+
		"\7K\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7v\2\2\u00c3\66\3\2\2\2\u00c4\u00c5"+
		"\7>\2\2\u00c5\u00c6\7?\2\2\u00c6\u00c7\7?\2\2\u00c7\u00c8\7@\2\2\u00c8"+
		"8\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca\u00cb\7?\2\2\u00cb\u00cc\7?\2\2\u00cc"+
		":\3\2\2\2\u00cd\u00ce\7>\2\2\u00ce\u00cf\7?\2\2\u00cf<\3\2\2\2\u00d0\u00d1"+
		"\7>\2\2\u00d1\u00d2\7?\2\2\u00d2\u00d3\7@\2\2\u00d3>\3\2\2\2\u00d4\u00d5"+
		"\7#\2\2\u00d5\u00d6\7@\2\2\u00d6@\3\2\2\2\u00d7\u00d8\7#\2\2\u00d8\u00d9"+
		"\7>\2\2\u00d9B\3\2\2\2\u00da\u00db\7#\2\2\u00db\u00dc\7?\2\2\u00dcD\3"+
		"\2\2\2\u00dd\u00de\7>\2\2\u00deF\3\2\2\2\u00df\u00e0\7@\2\2\u00e0H\3\2"+
		"\2\2\u00e1\u00e2\7?\2\2\u00e2J\3\2\2\2\u00e3\u00e4\7#\2\2\u00e4L\3\2\2"+
		"\2\u00e5\u00e7\t\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9N\3\2\2\2\u00ea\u00ed\7)\2\2\u00eb\u00ee"+
		"\5S*\2\u00ec\u00ee\n\3\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f0\7)\2\2\u00f0P\3\2\2\2\u00f1\u00f6\7$\2\2\u00f2"+
		"\u00f5\5S*\2\u00f3\u00f5\n\4\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3\3\2\2"+
		"\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9"+
		"\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\7$\2\2\u00faR\3\2\2\2\u00fb\u00fc"+
		"\7^\2\2\u00fc\u00fd\t\5\2\2\u00fdT\3\2\2\2\u00fe\u0102\t\6\2\2\u00ff\u0101"+
		"\t\7\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103V\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0107\t\b\2\2"+
		"\u0106\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\b,\2\2\u010bX\3\2\2\2\u010c\u010d"+
		"\7\61\2\2\u010d\u010e\7\61\2\2\u010e\u0112\3\2\2\2\u010f\u0111\n\t\2\2"+
		"\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\b-\2\2\u0116"+
		"Z\3\2\2\2\u0117\u0118\7\61\2\2\u0118\u0119\7,\2\2\u0119\u011d\3\2\2\2"+
		"\u011a\u011c\13\2\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011e"+
		"\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0121\7,\2\2\u0121\u0122\7\61\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b."+
		"\2\2\u0124\\\3\2\2\2\13\2\u00e8\u00ed\u00f4\u00f6\u0102\u0108\u0112\u011d"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}