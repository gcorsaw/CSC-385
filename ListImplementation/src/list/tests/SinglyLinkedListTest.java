package list.tests;

import listi.SinglyLinkedList;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList<Character> sll = new SinglyLinkedList<Character>();
		sll.append('i'); //0
		sll.append('2'); //1
		sll.append('b'); //2
		System.out.println(sll);
		sll.set(2, 'c');
		System.out.println(sll);


//		sll.append('a'); //1
//		sll.append('b'); //2
//		sll.append('c'); //3
//		sll.append('d'); //4
//		sll.append('e'); //5
//		sll.append('f'); //6
//		sll.append('g'); //7
//		System.out.println(sll);
//		sll.set(5, 'q');
//		System.out.println(sll);
//		sll.set(0, 'z');
//		System.out.println(sll);
//		System.out.println(sll.indexOf('o'));


//		System.out.println(sll);
//		sll.add(0, 'a');
//		System.out.println(sll);
//		sll.add(1, 'b');
//		System.out.println(sll);
//		sll.add(0, 'c');
//		System.out.println(sll);
//		sll.append('i');
//		System.out.println(sll);
//		sll.prepend('e');
//		System.out.println(sll);
//		System.out.println(sll.getSize());
//		sll.clear();
//		System.out.println(sll);
	}

}
