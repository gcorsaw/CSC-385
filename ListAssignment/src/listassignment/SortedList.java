package listassignment;

public class SortedList<T extends Comparable<? super T>> {
	/*
	 10. removeAll() --> could be improved upon
	 */
	//Fields
	private Node head;
	private Node tail;
	private int size;
	//Constructor
	public SortedList() {
		clear();
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(T data) {
		Node newestNode = new Node();
		newestNode.data = data;
		if(isEmpty()) {
			head = newestNode;
			tail = newestNode;
		}else {
			Node currentNode = head;
			while(currentNode != null) {
				if(currentNode.data.compareTo(newestNode.data) > 0) {
					if(currentNode.previous == null) {
						//adding before the head
						head.previous = newestNode;
						newestNode.next = head;
						head = newestNode;
						size++;
						return;
					}else {
						//add before currentNode
						Node previous = currentNode.previous;
						//Point newest node to current node
						newestNode.next = currentNode;
						//newest previous should be pointed to current node previous
						newestNode.previous = previous;
						//repoint previous to the new node
						previous.next = newestNode;
						//repoint current node previous
						currentNode.previous = newestNode;
						size++;
						return;
					}
				}
				currentNode = currentNode.next;
			}
			newestNode.previous = tail;
			tail.next = newestNode;
			tail = newestNode;
		}
		size++;
	}
	
	public T removeAt(int index) {
		if(isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty collection.");
		}
		if(index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		
		int currentIndex = 0;
		T returnData = null;
		Node currentNode = head;
		while(currentNode != null) {
			if(currentIndex == index) {
				returnData = currentNode.data;
				removeNode(currentNode);
				break;
			}
			currentNode = currentNode.next;
			currentIndex++;
		}
		return returnData;
	}
	

	public T get(int index) {
		if(isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty collection.");
		}
		if(index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		
		int currentIndex = 0;
		T returnData = null;
		Node currentNode = head;
		while(currentNode != null) {
			if(currentIndex == index) {
				returnData = currentNode.data;
				break;
			}
			currentNode = currentNode.next;
			currentIndex++;
		}
		return returnData;
	}
	
	public boolean contains(T data) {
		Node currentNode = head;
		while(currentNode != null) {
			if(currentNode.data == data) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}
	
	public int find(T data) {
		int currentIndex = 0;
		Node currentNode = head;
		while(currentNode != null) {
			if(currentNode.data == data) {
				return currentIndex;
			}
			currentNode = currentNode.next;
			currentIndex++;
		}
		return -1;
	}
	
	public int count(T data) {
		int itemCount = 0;
		Node currentNode = head;
		while(currentNode != null) {
			if(currentNode.data == data) {
				itemCount++;
			}
			currentNode = currentNode.next;
		}
		return itemCount;
	}
	
	public void removeAll(SortedList<T> otherList) {
		Node removeNode = otherList.head;
		Node checkNode = head;
		
		while(removeNode != null) {
			while(checkNode.data.compareTo(removeNode.data) < 0) {
				checkNode = checkNode.next;
			}
			if(removeNode.data == checkNode.data) {
				Node nextNode = checkNode.next;
				removeNode(checkNode);
				checkNode = nextNode;
			}
			removeNode = removeNode.next;
		}
	}
	
	private void removeNode(Node toRemove) {
		Node previousNode = toRemove.previous;
		Node nextNode = toRemove.next;
		if(previousNode == null) {
			head = nextNode;
			head.previous = null;
		}else if(nextNode == null) {
			tail = previousNode;
			tail.next = null;
		}else {
			previousNode.next = toRemove.next;
			nextNode.previous = toRemove.previous;					
		}
		toRemove = null;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		if(!isEmpty()) {
			Node temp = head;
			while(temp.next != null) {
				sb.append(temp.data.toString());
				sb.append(", ");
				temp = temp.next;
			}
			sb.append(temp.data.toString());
		}
		sb.append(")");
		return sb.toString();
	}
	
	//Your node class.  You may move it to a different file but
	//you will need to change this to public class Node
	
	
	private class Node {
		T data;
		Node next;
		Node previous;
	}
}
