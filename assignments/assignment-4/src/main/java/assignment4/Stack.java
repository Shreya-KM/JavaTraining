package assignment4;

public class Stack<T> {
	private Object values[];
	private int top = -1;
	
	public Stack(int size) {
		values = new Object[size];
	}
	
	public boolean push(T value) {
		if(isFull()) {
			return false;
		}
		top++;
		values[top] = value;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		T value = (T) values[top];
		top--;
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		return (T) values[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == values.length-1;
	}
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = top;
			public boolean hasNext() {
				return index >= 0;
			}
			@SuppressWarnings("unchecked")
			public T next() {
				if(index < 0) {
					return null;
				}
				T value = (T) values[index];
				index--;
				return value;
			}
		};
	}
}
