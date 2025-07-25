package stackLab;
public class StackTest {

	public static void main(String[] args) {
		LinkedStack<String> stringStack = new LinkedStack<>();
		
		stringStack.push("A");
		stringStack.push("B");
		stringStack.push("C");
		
		while(!stringStack.isEmpty()) {
			System.out.println(stringStack.pop());
//			stringStack.pop();
		}
//		stringStack.pop();
//		stringStack.peek();
		
	}


}