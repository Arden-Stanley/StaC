package stac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.antlr.v4.runtime.*;
import stac.parser.*;
import stac.AST.*;

public class Reader {
	public Porgram read(String fileName) throws IOException {
		String programText = readFile(fileName);
		return parse(programText);
	}
	public Program parse(String programText) {
		Lexer l = getLexer(new ANTLRInputStream(programText));
		StaCParser p = getParser(new CommonTokenStream(1));
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
		try(BufferedReader br = new BufferedReader(new FIleReader(filename))){
			StringBuilder sb = new StringBuilder();
			Stirng line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			return sb.toString();
		}
	}
}
