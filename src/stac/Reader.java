package stac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.antlr.v4.runtime.*;
import stac.parser.*;
import stac.AST.*;

//if StaCParser and getParser are generating errors, make sure to run the ANTLR tool on the grammar file to generate the parser and lexer classes
public class Reader {
	public Program read(String fileName) throws IOException {
		String programText = readFile(fileName);
		return parse(programText);
	}
	public Program parse(String programText) {
		Lexer l = getLexer(new ANTLRInputStream(programText));
		StaCParser p = getParser(new CommonTokenStream(l));
		Program program = p.program().ast;
		return program;
	}
	protected Lexer getLexer(ANTLRInputStream s) {
		return new StaCLexer(s);
	}
	protected StaCParser getParser(CommonTokenStream s){
		return new StaCParser(s);
	}
	private String readFile(String fileName) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			return sb.toString();
		}
	}
}
