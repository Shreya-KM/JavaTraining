package assignment4;

public class IntQueue {
	private int values[];
	private int front = 0;
	private int rear = 0;
	private int count = 0;
	
	public IntQueue(int size) {
		values = new int[size];
	}
	
	public boolean enqueue(int value) {
		if(isFull()) {
			return false;
		}
		values[rear] = value;
		rear = (rear + 1) % values.length;
		count++;
		return true;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			return -1;
		}
		int value = values[front];
		front = (front + 1) % values.length;
		count--;
		return value;
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		return values[front];
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == values.length;
	}
}
