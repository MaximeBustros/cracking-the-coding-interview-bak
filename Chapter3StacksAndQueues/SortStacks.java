import java.util.EmptyStackException;
import java.util.Random;

/*
 * Problem set: Sort Stacks
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements into 
 * any other data structure (such as an array). The stack supports the following
 * operations: push, pop, peek, and isEmpty.
 */
public class SortStacks {
	
	private static class MySortedStack<T extends Comparable<T>> {
		MyStack<T> stack1;
		MyStack<T> stack2;
		
		public MySortedStack() {
			this.stack1 = new MyStack<T>();
			this.stack2 = new MyStack<T>();
		}
		
		private void copyFrom(MyStack<T> stack1, MyStack<T> stack2) throws EmptyStackException {
			while(true) {
				T popped = stack1.pop();
				stack2.push(popped);
			}
		}
		
		public void push(T item) {
			try {
				T top = stack1.peek();
				if (item.compareTo(top) < 0) {
					stack1.push(item);
				} else {
					T popped = stack1.pop();
					stack2.push(popped);
					
					popped = stack1.pop();
					while(item.compareTo(popped) > 0) {
						stack2.push(popped);
						popped = stack1.pop();
					}
					// if item is smaller than a certain element
					stack1.push(popped); 	// reinsert element
					stack1.push(item); 		// push our element
				}
			} catch (EmptyStackException e) {
				stack1.push(item);	// will be thrown if peek or pop throws 
									// an empty stack exception
			}
			
			try {
				copyFrom(stack2, stack1);
			} catch (EmptyStackException e) {}
		}
		
		public T pop() {
			return stack1.pop();
		}
		
		public T peek() {
			return stack1.peek();
		}
		
		public boolean isEmpty() {
			return stack1.isEmpty();
		}
		
		public void print() {
			try {
				while (true) {
					System.out.println(stack1.pop());
				}
			} catch (EmptyStackException e) {}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySortedStack<Integer> mss = new MySortedStack<Integer>();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			mss.push(new Integer(r.nextInt(100)));
		}
		
		try {
			for (int i = 0; i < 5; i++) {
				mss.pop();
			}
		} catch (EmptyStackException e) {}
		
		// we can see that even after adding and removing elements
		// our stack is still ordered
		mss.print();
	}

}
