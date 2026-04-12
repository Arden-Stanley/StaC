package stac;
import java.io.IOException;
import stac.AST.*;

public class Interpreter {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Usage: stac <filename>");
			return;
		}

		Reader reader = new Reader();
		Evaluator eval = new Evaluator();

		Program p = null;
		try {
			p = reader.read(args[0]);
			if(p == null || p.body() == null || p.body().isEmpty()){
				System.out.println("Error: empty program.");
				return;
			}
			eval.run(p);
		}
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
