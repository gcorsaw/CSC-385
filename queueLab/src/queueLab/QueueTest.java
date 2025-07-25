package queueLab;

public class QueueTest {

	public static void main(String[] args) {
		LinkedQueue<Integer> intQ = new LinkedQueue<>();
		
		for(int i = 0; i < 10; i++) {
			intQ.enqueue(i);
		}
		
		while(!intQ.isEmpty()) {
//			System.out.println(intQ.dequeue());
			System.out.println(intQ.getFront());
			intQ.dequeue();
		}
		
		intQ.dequeue();
	}

}
