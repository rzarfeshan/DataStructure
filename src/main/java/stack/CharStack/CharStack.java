package stack.CharStack;

public class CharStack implements Stack {
	private char[] value;
	private int top;
	
	public CharStack (int size) {
		value = new char[size];
		top = -1;
	}
	
	@Override
	public void push(char ch) {
		if (top == value.length - 1) {
			return;
		}
		value[++top] = ch;
	}
	
	@Override
	public char pop() {
		if (top == -1) {
			return 0;
		}
		return value[top--];
	}
	
	@Override
	public int top() {
		return top;
	}

	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}
	
	
}
