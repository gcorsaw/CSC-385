package list.tests;

import listi.DoublyLinkedList;

public class DoublyLinkedListTest {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<Character> dll = new DoublyLinkedList<Character>();
		
		System.out.println(dll);
		dll.add(0, 'a');
		dll.add(0, 'b');
		dll.add(1, 'c');
		dll.append('d');
		dll.prepend('e');
		dll.add(2, 'h');
		System.out.println(dll);
		dll.removeFirst();
		System.out.println(dll);
		dll.remove(new Character('a'));
		System.out.println(dll);
		dll.remove(dll.getSize() -1);
		System.out.println(dll);
		dll.remove(1);
		System.out.println(dll);
		
	}
}