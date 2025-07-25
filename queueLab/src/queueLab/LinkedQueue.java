package queueLab;

public class LinkedQueue<T> {
	
	private Node<T> front;
	private Node<T> back;
	
	private int size;
	
	public LinkedQueue() {
		clear();
	}
	
	public T getFront() {
		if(isEmpty()) {
			throw new EmptyQueueException("The queue is empty but getFront was called.");
		}
		
		return front.data;
	}
	
	public void enqueue(T newData) {
		Node<T> newNode = new Node<>();
		newNode.data = newData;
		if(isEmpty()) {
			front = newNode;
			back = newNode;
		}else {
			back.next = newNode;
			back = newNode;
		}
		size += 1; 
	}
	
	public T dequeue() {
		if(isEmpty()) {
			throw new EmptyQueueException("The queue is empty but dequeue was called.");
		}
		Node<T> temp = front;
	
		if(size == 1) {
			clear();
		}else {
			front = front.next;
			temp.next = null;
			size -= 1;
		}
		
		return temp.data;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		front = null;
		back = null;
		size = 0;		
	}
	
	private class Node<E>{
		E data;
		Node<E> next;
	}
}
