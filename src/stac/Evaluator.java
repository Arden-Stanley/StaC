package stac;

import static stac.AST.*;
import static stac.Value.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Evaluator implements Visitor<StackVal> {
	
	//map variable names to stacks
	private HashMap<String, StackVal> _env = new HashMap<>();

	//maps funciton names to their definitions
	private HashMap<String, FunctionDef> _functions = new HashMap<>();

	private Random _random = new Random();
	private Scanner _scanner = new Scanner(System.in);

	//entry point - scans for all functin defs and calls main
	public void run(Program p) {
		p.accept(this);
	}

	// top level
	
	@Override
	public StackVal visit(Program p) {
		// first pass: register all function defs
		for (ASTNode node : p.body()){
			if (node instanceof FunctionDef) {
				FunctionDef fd = (FunctionDef) node;
				_functions.put(fd.name(), fd);
			}
		}
		//second pass: execute top level declarations
		for (ASTNode node : p.body()){
			if (node instanceof DeclarationExp) {
				node.accept(this);
			}
		}
		// find and calls main
		if (!_functions.containsKey("main")) {
			throw new RuntimeException("Error: no main function found.");
		}
		callFunction(_functions.get("main"), new ArrayList<>());
		return null;
	}

	public StackVal visit (FunctionDef e) {
		return null;
	}

	@Override
	public StackVal visit(Param e) {
		return null;
	}

	// function calls
	private StackVal callFunction(FunctionDef def, List<StackVal> args) {
		//save current env
		HashMap<String, StackVal> savedEnv = new HashMap<>(_env);

		//bind arguements
		List<Param> params = def.params();
		for (int i = 0; i < params.size(); i++) {
			_env.put(params.get(i).name(), new StackVal(args.get(i)));
		}
		// function name stack
		_env.put(def.name(), new StackVal(def.returnType()));
		//execute body
		StackVal returnVal = null;
		try {
			for (Exp stmt : def.body()){
				stmt.accept(this);
			}
		}
		catch (ReturnException r) {
			returnVal = r.value;
		}
		//grab return stack if no explicite return was thrown
		if (returnVal == null) {
			returnVal = _env.get(def.name());
		}
		//restore env
		_env = savedEnv;
		return returnVal;
	}
	
	// use an exception to hand return statements
	private static class ReturnException extends RuntimeException {
		StackVal value;
		ReturnException(StackVal value) { this.value = value; }
	}
	
	@Override
	public StackVal visit(FunctionCallExp e) {
		if(!_functions.containsKey(e.name())) {
			throw new RuntimeException("Undefined function: " + e.name());
		}
		FunctionDef def = _functions.get(e.name());

		//collect arg stacks
		List<StackVal> args = new ArrayList<>();
		for (String argName : e.args()) {
			if (!_env.containsKey(argName)) {
				throw new RuntimeException("Undefined variable: " + argName);
			}
			args.add(new StackVal(_env.get(argName)));
		}
		return callFunction(def, args);
	}
	
	// Declarations
	@Override
	public StackVal visit(DeclarationExp e) {
		StackVal stack = new StackVal(e.type());
		_env.put(e.name(), stack);

		if (e.initializer() != null) {
			// '<==' assignment 
			if (e.isDump()) {
				StackVal source = e.initializer().accept(this);
				dumpInto(stack, source);
			}
			// '<=' assignment
			else{
				StackVal source = e.initializer().accept(this);
				if (!source.isEmpty()) {
					stack.push(source.pop());
				}
			}
		}
		return stack;
	}

	//TODO: Implement below
	//transfers
	@Override
	public StackVal visit(TransferExp e){}
	@Override
	public StackVal visit(DumpExp e) {}

	// swap
	@Override
	public StackVal visit(TopSwapExp e) {}
	@Override
	public StackVal visit(FullSwapExp e) {}
	
	//builtin calls
	@Override
	public StackVal visit(DupExp e) {}
	@Override
	public StackVal visit(PopExp e) {}
	@Override
	public StackVal visit(ReturnExp e) {}
	
	//builtin expressions
	@Override
	public StackVal visit(RandIntExp e) {}
	@Override
	public StackVal visit(ScanIntExp e) {}
	@Override 
	public StackVal visit(ScanExp e) {}
	@Override
	public StackVal visit(DepthExp e) {}

	// control flow
	@Override
	public StackVal visit(IfExp e) {}
	@Override
	public StackVal visit(WhileExp e) {}
	@Override
	public StackVal visit (ForExp e) {}

	// Conditions
	private boolean evalConditon(Condition c) {
		return (boolean) c.accept(this);
	}
	
	@Override
	public StackVal visit(ComparisonCondition e) {}
	@Override
	public StackVal visit(TruthyCondition e) {}
	@Override
	public StackVal visit(EmptyCondition e) {}
	
	//literals
	@Override
	public StackVal visit(IntLiteralExp e) {}
	@Override 
	public StackVal visit(CharLiteralExp e) {}
	@Override
	public StackVal visit(StringLiteralExp e) {}
	//variable reference
	@Override
	public StackVal visit(VarExp e) {}
	// arithmetic
	@Override
	public StackVal visit(AddExp e) {}
	@Override
	public StackVal visit(SubExp e) {}
	@Override
	public StackVal visit(MulExp e) {}
	@Override
	public StackVal visit(DivExp e) {}
	@Override
	public StackVal visit(ModExp e) {}
	
	// Helpers
	private StackVal getVar(String name) {
		if(!_env.containsKey(name)) {
			throw new RuntimeException("Undefined variable: " + name);
		}
		return _env.get(name);
	}

	private StackVal getSink(String name) {
		if(!_env.containsKey(name)) {
			throw new RuntimeException("Undefined variable: " + name);
		}
		return _env.get(name);
	}
	
	private void dumpInto(StackVal dest, StackVal source) {
		List<Integer> vals = new ArrayList<>(source.raw());
		for (int i = vals.size() - 1; i >= 0; i--){
			dest.push(vals.get(i));
		}
	}

	private void printValue(int val, String type) {
		if (type.equals("char")){
			System.out.print((char) val);
		}
		else{
			System.out.print(val);
		}
	}
}