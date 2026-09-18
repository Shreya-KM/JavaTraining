package assignment4;

public class LinkedList<T> {
	private Node head;
	private Node tail;
	private int size;
	
	private class Node {
		T value;
		Node next;
		
		Node(T value) {
			this.value = value;
		}
	}
	
	public void addFirst(T value) {
		Node node = new Node(value);
		node.next = head;
		head = node;
		if(tail == null) {
			tail = node;
		}
		size++;
	}
	
	public void addLast(T value) {
		Node node = new Node(value);
		if(tail == null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public void insert(int position, T value) {
		if(position < 0 || position > size) {
			return;
		}
		if(position == 0) {
			addFirst(value);
			return;
		}
		if(position == size) {
			addLast(value);
			return;
		}
		Node previous = head;
		for(int i=1;i<position;i++) {
			previous = previous.next;
		}
		Node node = new Node(value);
		node.next = previous.next;
		previous.next = node;
		size++;
	}
	
	public T delete(int position) {
		if(position < 0 || position >= size) {
			return null;
		}
		if(position == 0) {
			T value = head.value;
			head = head.next;
			size--;
			if(size == 0) {
				tail = null;
			}
			return value;
		}
		Node previous = head;
		for(int i=1;i<position;i++) {
			previous = previous.next;
		}
		T value = previous.next.value;
		if(previous.next == tail) {
			tail = previous;
		}
		previous.next = previous.next.next;
		size--;
		return value;
	}
	
	public int size() {
		return size;
	}
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node current = head;
			public boolean hasNext() {
				return current != null;
			}
			public T next() {
				if(current == null) {
					return null;
				}
				T value = current.value;
				current = current.next;
				return value;
			}
		};
	}
}
