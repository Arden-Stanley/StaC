package stac;

import static stac.AST.*;
import static stac.Value.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import stac.AST.ASTNode;
import stac.AST.AddExp;
import stac.AST.CharLiteralExp;
import stac.AST.ComparisonCondition;
import stac.AST.Condition;
import stac.AST.DeclarationExp;
import stac.AST.DepthExp;
import stac.AST.DivExp;
import stac.AST.DumpExp;
import stac.AST.DupExp;
import stac.AST.EmptyCondition;
import stac.AST.Exp;
import stac.AST.ForExp;
import stac.AST.FullSwapExp;
import stac.AST.FunctionCallExp;
import stac.AST.FunctionDef;
import stac.AST.IfExp;
import stac.AST.IntLiteralExp;
import stac.AST.ModExp;
import stac.AST.MulExp;
import stac.AST.Param;
import stac.AST.PopExp;
import stac.AST.Program;
import stac.AST.RandIntExp;
import stac.AST.ReturnExp;
import stac.AST.ScanExp;
import stac.AST.ScanIntExp;
import stac.AST.StringLiteralExp;
import stac.AST.SubExp;
import stac.AST.TopSwapExp;
import stac.AST.TransferExp;
import stac.AST.TruthyCondition;
import stac.AST.VarExp;
import stac.AST.Visitor;
import stac.AST.WhileExp;
import stac.Value.StackVal;

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
		_env = new HashMap<>();

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
	public StackVal visit(TransferExp e){
		StackVal source = e.source().accept(this);
		if( !source.isEmpty()) {
			int val = source.pop();	
			if (e.sink().equals("print")) {
				printValue(val,source.type());
			}
			else {
				getSink(e.sink()).push(val);
			}
		}
		return null;
	}
	@Override
	public StackVal visit(DumpExp e) {
        List<Exp> sources = e.sources();

        // Start with the rightmost source
        StackVal combined = sources.get(sources.size() - 1).accept(this);

        // Zip each successive source to the left into combined
        for (int i = sources.size() - 2; i >= 0; i--) {
            StackVal left = sources.get(i).accept(this);
            StackVal result = new StackVal(combined.type());
            // zip left and combined top-down until shortest exhausted
            while (!left.isEmpty() && !combined.isEmpty()) {
                result.push(left.pop() + combined.pop());
            }
            combined = result;
        }

        // Dump combined into sink
        if (e.sink().equals("print")) {
            while (!combined.isEmpty()) {
                printValue(combined.pop(), combined.type());
            }
        } else {
            dumpInto(getSink(e.sink()), combined);
        }
        return null;
	}

	// swap
	@Override
	public StackVal visit(TopSwapExp e) {
		StackVal left = getVar(e.left());
		StackVal right = getVar(e.right());

		if(left.isEmpty() && right.isEmpty()) { return null; }
		if (left.isEmpty()) {
			left.push(right.pop());
		}
		else if (right.isEmpty()) {
			right.push(left.pop());
		}
		else {
			int l = left.pop();
			int r = right.pop();
			left.push(r);
			right.push(l);
		}
		return null;
	}

	@Override
	public StackVal visit(FullSwapExp e) {
		StackVal left = getVar(e.left());
		StackVal right = getVar(e.right());

		java.util.Deque<Integer> tmp = left.raw();

		StackVal newLeft = new StackVal(left.type());
		StackVal newRight = new StackVal(right.type());
		
		List<Integer> rightVals = new ArrayList<>(right.raw());
		List<Integer> leftVals = new ArrayList<>(left.raw());
		for (int v : leftVals) newRight.raw().addLast(v);
		for (int v : rightVals) newLeft.raw().addLast(v);
		_env.put(e.left(), newLeft);
		_env.put(e.right(), newRight);
		return null;
	}
	
	//builtin calls
	@Override
	public StackVal visit(DupExp e) {
		StackVal stack = getVar(e.name());
		if(!stack.isEmpty()) {
			stack.push(stack.peek());
		}
		return null;
	}
	@Override
	public StackVal visit(PopExp e) {
		StackVal stack = getVar(e.name());
		if(!stack.isEmpty()) {
			stack.pop();
		}
		return null;
	}
	@Override
	public StackVal visit(ReturnExp e) {
		for (String key : _functions.keySet()){
			if(_env.containsKey(key)){
				throw new ReturnException(_env.get(key));
			}
		}
		throw new ReturnException(new StackVal("int"));
	}
	
	//builtin expressions
	@Override
	public StackVal visit(RandIntExp e) {
		StackVal minStack = e.min().accept(this);
		StackVal maxStack = e.max().accept(this);
		int min = minStack.pop();
		int max = maxStack.pop();
		StackVal result = new StackVal("int");
		result.push(min + _random.nextInt(max - min + 1));
		return result;
	}
	@Override
	public StackVal visit(ScanIntExp e) {
		StackVal result = new StackVal("int");
		result.push(_scanner.nextInt());
		return result;
	}
	@Override 
	public StackVal visit(ScanExp e) {
		String line = _scanner.nextLine();
		StackVal result = new StackVal("char");
		for (int i = line.length() - 1; i >= 0; i--){
			result.push((int) line.charAt(i));
		}
		return result;
	}
	@Override
	public StackVal visit(DepthExp e) {
		StackVal stack = getVar(e.name());
		StackVal result = new StackVal("int");
		result.push(stack.depth());
		return result;
	}

	// control flow
	@Override
	public StackVal visit(IfExp e) {
		if (evalCondition(e.condition())) {
			for (Exp stmt : e.thenBody()) stmt.accept(this);
		}
		else if (e.elseBody() != null) {
			for (Exp stmt : e.elseBody()) stmt.accept(this);
		}
		return null;
	}
	@Override
	public StackVal visit(WhileExp e) {
		while (evalCondition(e.condition())) {
			for (Exp stmt : e.body()) stmt.accept(this);
		}
		return null;
	}
	@Override
	public StackVal visit (ForExp e) {
		e.init().accept(this);
		while (evalCondition(e.condition())) {
			for (Exp stmt : e.body()) stmt.accept(this);
			e.step().accept(this);
		}
		return null;
	}

	// Conditions
	private boolean evalCondition(Condition c) {
		StackVal result = c.accept(this);
		return !result.isEmpty() && result.peek() != 0;
	}
	
	@Override
	public StackVal visit(ComparisonCondition e) {
		StackVal left = e.left().accept(this);
		StackVal right = e.right().accept(this);
		int l = left.peek();
		int r = right.peek();
		boolean result = switch(e.op()) {
			case "<" -> l < r;
			case ">" -> l > r;
			case "=" -> l == r;
			case  "!=" -> l != r;
			case "!<" -> l >= r;
			case "!>" -> l <= r;
			default -> throw new RuntimeException("Unknown comparison operator: " + e.op());
		};
		StackVal res = new StackVal("int");
		res.push(result ? 1 : 0);
		return res;
	}
	@Override
	public StackVal visit(TruthyCondition e) {
		StackVal stack = getVar(e.name());
		StackVal result = new StackVal("int");
		result.push(stack.isEmpty() ? 0 : 1);
		return result;
	}
	@Override
	public StackVal visit(EmptyCondition e) {
		StackVal stack = getVar(e.name());
		StackVal result = new StackVal("int");
		result.push(stack.isEmpty() ? 1 : 0);
		return result;
	}
	
	//literals
	@Override
	public StackVal visit(IntLiteralExp e) {
		StackVal result = new StackVal("int");
		result.push(e.val());
		return result;
	}
	@Override 
	public StackVal visit(CharLiteralExp e) {
		StackVal result = new StackVal("char");
		result.push(e.val());
		return result;
	}
	@Override
	public StackVal visit(StringLiteralExp e) {
		StackVal result = new StackVal("char");
		String s = e.val()
						.replace("\\n", "\n")
						.replace("\\t", "\t")
						.replace("\\r", "\r")
						.replace("\\\"", "\"")
						.replace("\\\\", "\\")
						;
		for (int i = 0; i < s.length(); i++){
			result.push((int) s.charAt(i));
		}
		return result;
	}
	//variable reference
	@Override
	public StackVal visit(VarExp e) {
		return getVar(e.name());
	}
	// arithmetic
	@Override
	public StackVal visit(AddExp e) {
		int left = e.left().accept(this).pop();
		int right = e.right().accept(this).pop();
		StackVal result = new StackVal("int");
		result.push(left + right);
		return result;
	}
	@Override
	public StackVal visit(SubExp e) {
		int left = e.left().accept(this).pop();
		int right = e.right().accept(this).pop();
		StackVal result = new StackVal("int");
		result.push(left - right);
		return result;
	}
	@Override
	public StackVal visit(MulExp e) {
		int left = e.left().accept(this).pop();
		int right = e.right().accept(this).pop();
		StackVal result = new StackVal("int");
		result.push(left * right);
		return result;
	}
	@Override
	public StackVal visit(DivExp e) {
		int left = e.left().accept(this).pop();
		int right = e.right().accept(this).pop();
		StackVal result = new StackVal("int");
		result.push(left / right);
		return result;
	}
	@Override
	public StackVal visit(ModExp e) {
		int left = e.left().accept(this).pop();
		int right = e.right().accept(this).pop();
		StackVal result = new StackVal("int");
		result.push(left % right);
		return result;
	}

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
		for (int i = 0; i < vals.size(); i++){
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