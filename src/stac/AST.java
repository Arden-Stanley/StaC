package stac;

import java.util.List;



public interface AST {
	public static abstract class ASTNode {
		public abstract <T> T accept(Visitor<T> visitor);
	}
	// top level
	public static class Program extends ASTNode {
		List<ASTNode> _body;
		public Program(List<ASTNode> body) {
			_body = body;
		}
		public List<ASTNode> body() { return _body; }
		public <T> T accept(Visitor<T> visitor){
			return visitor.visit(this);
		}
	}
	// func definition lives at top level of program
	public static class FunctionDef extends ASTNode {
		String _returnType;
		String _name;
		List<Param> _params;
		List<Exp> _body;
		public FunctionDef(String returnType, String name, List<Param> params, List<Exp> body) {
			_returnType = returnType;
			_name       = name;
			_params     = params;
			_body       = body;
		}
		public String returnType() { return _returnType; }
		public String name()       { return _name; }
		public List<Param> params(){ return _params; }
		public List<Exp> body()    { return _body; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}
	// a single parameter in a funciton definition
	public static class Param extends ASTNode {
		String _type;
		String _name;
		public Param(String type, String name) {
			_type = type;
			_name = name;
		}
		public String type() { return _type; }
		public String name() { return _name; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}
	
	//expression base class
	public static abstract class Exp extends ASTNode {}

	// literals
	public static class IntLiteralExp extends Exp {
		int _val;
		public IntLiteralExp(int val) { _val = val; }
		public int val() { return _val; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

    public static class CharLiteralExp extends Exp {
	char _val;
	public CharLiteralExp(char val) { _val = val; }
	public char val() { return _val; }
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
        	}
	}

	public static class StringLiteralExp extends Exp {
		String _val;
		public StringLiteralExp(String val) { _val = val; }
		public String val() { return _val; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	// variable reference
	public static class VarExp extends Exp {
		String _name;
		public VarExp(String name) { _name = name; }
		public String name() { return _name; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	// arithmetic
	public static abstract class BinaryExp extends Exp {
		Exp _left;
		Exp _right;
		public BinaryExp(Exp left, Exp right) {
			_left = left;
			_right = right;
		}
		public Exp left()  { return _left; }
		public Exp right() { return _right; }
	}

	public static class AddExp extends BinaryExp {
		public AddExp(Exp left, Exp right) { super(left, right); }
		public <T> T accept(Visitor<T> visitor) { return visitor.visit(this); }
    	}
 
    	public static class SubExp extends BinaryExp {
        	public SubExp(Exp left, Exp right) { super(left, right); }
        	public <T> T accept(Visitor<T> visitor) { return visitor.visit(this); }
    	}
 
    	public static class MulExp extends BinaryExp {
        	public MulExp(Exp left, Exp right) { super(left, right); }
        	public <T> T accept(Visitor<T> visitor) { return visitor.visit(this); }
    	}
 
    	public static class DivExp extends BinaryExp {
        	public DivExp(Exp left, Exp right) { super(left, right); }
        	public <T> T accept(Visitor<T> visitor) { return visitor.visit(this); }
    	}
 
    	public static class ModExp extends BinaryExp {
        	public ModExp(Exp left, Exp right) { super(left, right); }
        	public <T> T accept(Visitor<T> visitor) { return visitor.visit(this); }
    	}

	// function call
	public static class FunctionCallExp extends Exp {
		String _name;
		List<String> _args;
		public FunctionCallExp(String name, List<String> args) {
			_name = name;
			_args = args;
		}
		public String name()		{return _name;}
		public List<String> args()	{return _args;}
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	// built in expressions
	public static class RandIntExp extends Exp {
		Exp _min;
		Exp _max;
		public RandIntExp(Exp min, Exp max) { _min = min; _max = max;}
		public Exp min() { return _min; }
		public Exp max() { return _max; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	public static class ScanIntExp extends Exp {
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}
	
	public static class ScanExp extends Exp {
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}
	
	public static class DepthExp extends Exp {
		String _name;
		public DepthExp(String name) { _name = name; }
		public String name() { return _name; } 
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	// statements

	// variable declaration with optional initializers <= or <==
	public static class DeclarationExp extends Exp {
		String _type;
		String _name;
		Exp _initializer; // null if no initialization
		boolean _isDump; // true if '<==' false if '<='
	 	public DeclarationExp (String type, String name, Exp initializer, boolean isDump){
			_type		= type;
			_name		= name;
			_initializer 	= initializer;
			_isDump 	= isDump;
		}
		public String type()	{ return _type; }
		public String name()	{ return _name; }
		public Exp initializer(){ return _initializer; }
		public boolean isDump()	{ return _isDump; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	//transfer
	public static class TransferExp extends Exp {
		String _sink;
		Exp _source;
		public TransferExp(String sink, Exp source) {
			_sink = sink;
			_source = source;
		}
		public String sink() { return _sink; }
		public Exp source()  { return _source; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	// dump
	public static class DumpExp extends Exp {
		String _sink;
		List<Exp> _sources;
		public DumpExp(String sink, List<Exp> sources) {
			_sink	= sink;
			_sources= sources;
		}
		public String sink()		{ return _sink; }
		public List<Exp> sources() 	{ return _sources; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	// <=> operator
 	public static class TopSwapExp extends Exp {
        	String _left;
        	String _right;
        	public TopSwapExp(String left, String right) {
            		_left  = left;
            		_right = right;
        	}
        	public String left()  { return _left; }
        	public String right() { return _right; }
        	public <T> T accept(Visitor<T> visitor) { 
		return visitor.visit(this); 
		}
    	}
 
    	// <==> 
    	public static class FullSwapExp extends Exp {
        	String _left;
        	String _right;
        	public FullSwapExp(String left, String right) {
            		_left  = left;
            		_right = right;
        	}
        	public String left()  { return _left; }
        	public String right() { return _right; }
		public <T> T accept(Visitor<T> visitor) {
				return visitor.visit(this); 
		}
	}

	public static class DupExp extends Exp {
		String _name;
		public DupExp(String name) {_name = name; }
		public String name() { return _name; }
		public <T> T accept(Visitor<T> visitor) {
				return visitor.visit(this); 
		}
	}

	public static class PopExp extends Exp {
		String _name;
		public PopExp(String name) { _name = name; }
		public String name() {return _name; }
		public <T> T accept(Visitor<T> visitor) {
				return visitor.visit(this); 
		}
	}

	public static class ReturnExp extends Exp {
		public <T> T accept(Visitor<T> visitor) {
				return visitor.visit(this); 
		}
	}

	//control flow
	public static class IfExp extends Exp {
		Condition _condition;
		List<Exp> _thenBody;
		List<Exp> _elseBody;
		public IfExp(Condition condition, List<Exp> thenBody, List<Exp> elseBody) {
			_condition = condition;
			_thenBody  = thenBody;
			_elseBody  = elseBody;
		}
		public Condition condition() { return _condition; }
		public List<Exp> thenBody()  { return _thenBody; }
		public List<Exp> elseBody()  { return _elseBody; }
		public <T> T accept(Visitor<T> visitor) {
				return visitor.visit(this); 
		}
	}

	public static class WhileExp extends Exp {
		Condition _condition;
		List<Exp> _body;
		public WhileExp (Condition condition, List<Exp> body) {
			_condition = condition;
			_body	   = body;
		}
		public Condition condition() { return _condition; }
		public List<Exp> body()	     { return _body; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this); 
		}
	}

	public static class ForExp extends Exp {
		DeclarationExp _init;
		Condition _condition;
		TransferExp _step;
		List<Exp> _body;
		public ForExp(DeclarationExp init, Condition condition, TransferExp step,  List<Exp> body){
			_init		= init;
			_condition	= condition;
			_step		= step;
			_body		= body;
		}
		public DeclarationExp init() { return _init; }
		public Condition condition() { return _condition; }
		public TransferExp step()    { return _step; }
		public List<Exp> body()      { return _body; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this); 
		}
	}

	// conditions
//
	public static abstract class Condition extends ASTNode {}
	
	public static class ComparisonCondition extends Condition {
		Exp _left;
		Exp _right;
		String _op;
		public ComparisonCondition(Exp left, String op, Exp right){
			_left = left;
			_op = op;
			_right = right;
		}
		public Exp left() 	{ return _left; }
		public Exp right()	{ return _right; }
		public String op() 	{ return _op; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this); 
		}
	}

	public static class TruthyCondition extends Condition {
		String _name;
		public TruthyCondition(String name) { _name = name; }
		public String name() { return _name; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this); 
		}
	}

	public static class EmptyCondition extends Condition{
		String _name;
		public EmptyCondition(String name) { _name = name; }
		public String name() { return _name; }
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this); 
		}
	}

	// visitor
	public interface Visitor<T> {
		// Top level
        	public T visit(AST.Program e);
        	public T visit(AST.FunctionDef e);
        	public T visit(AST.Param e);
 
        // Literals
        	public T visit(AST.IntLiteralExp e);
        	public T visit(AST.CharLiteralExp e);
        	public T visit(AST.StringLiteralExp e);
 
        // Variable
        	public T visit(AST.VarExp e);
 
        // Arithmetic
        	public T visit(AST.AddExp e);
        	public T visit(AST.SubExp e);
        	public T visit(AST.MulExp e);
        	public T visit(AST.DivExp e);
        	public T visit(AST.ModExp e);
 
        // Function call
        	public T visit(AST.FunctionCallExp e);
 
        // Built-ins
        	public T visit(AST.RandIntExp e);
        	public T visit(AST.ScanIntExp e);
        	public T visit(AST.ScanExp e);
        	public T visit(AST.DepthExp e);
 
        // Statements
	        public T visit(AST.DeclarationExp e);
        	public T visit(AST.TransferExp e);
        	public T visit(AST.DumpExp e);
        	public T visit(AST.TopSwapExp e);
        	public T visit(AST.FullSwapExp e);
        	public T visit(AST.DupExp e);
        	public T visit(AST.PopExp e);
        	public T visit(AST.ReturnExp e);
 
        // Control flow
	        public T visit(AST.IfExp e);
        	public T visit(AST.WhileExp e);
        	public T visit(AST.ForExp e);
 
        // Conditions
        	public T visit(AST.ComparisonCondition e);
        	public T visit(AST.TruthyCondition e);
        	public T visit(AST.EmptyCondition e);
	}
}
