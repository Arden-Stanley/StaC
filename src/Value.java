package stac;

import java.util.ArrayDeque;
import java.util.Deque;

public class Value{
	public stati class StackVal {
		private Deque<Integer> _stack;
		private String _type; // only 'int' or 'char' for now
		
		//empty stack
		public StackVal(String type){
			_type = type;
			_stack = new ArrayDeque<>();
		}

		//copy constructor
		public StackVal(StackVal other) {
			_type = other._type;
			_stack = new ArrayDeque<>(other._stack);
		}

		public void push(int val)	{ _stack.push(val); }
		public int pop()		{ return _stack.pop(); }
		public int peek()		{ return _stack.peek(); }
		public boolean isEmpty()	{ return _stack.isEmpty(); }
		public int depth()		{ return _stack.size(); }
		public String type()		{ return _type; }
		public Deque<Integer> raw()	{ return _stack; }
	}
}
