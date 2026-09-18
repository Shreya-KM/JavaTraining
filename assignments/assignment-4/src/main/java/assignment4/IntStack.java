package assignment4;

public class IntStack {
	private int values[];
	private int top = -1;
	
	public IntStack(int size) {
		values = new int[size];
	}
	
	public boolean push(int value) {
		if(isFull()) {
			return false;
		}
		top++;
		values[top] = value;
		return true;
	}
	
	public int pop() {
		if(isEmpty()) {
			return -1;
		}
		int value = values[top];
		top--;
		return value;
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		return values[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == values.length-1;
	}
}
