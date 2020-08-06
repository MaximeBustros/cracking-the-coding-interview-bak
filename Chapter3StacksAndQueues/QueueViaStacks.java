import java.util.EmptyStackException;
import java.util.Random;

/*
 * Problem set: Queue via stacks
 * Implement a MyQueue class which implements a queue using two stacks
 */

/*
 * Solution:
 * Create two stacks. one responsible for pushing new elements and one for popping
 * Whenever the second stack is empty we copy the elements from stack1 to stack2 before
 * popping. This makes it so that pushing is O(1) and popping O(N) at worst.
 */

public class QueueViaStacks<X> {
	private static class Queue<T> {
		private MyStack<T> stack1;
		private MyStack<T> stack2;
		
		public Queue() {
			stack1 = new MyStack<T>();
			stack2 = new MyStack<T>();
		}
		
		public void push(T item) {
			stack1.push(item);
		}
		
		private void copyFromTo(MyStack<T> s1, MyStack<T> s2) {
			try {
				T i = s1.pop();
				s2.push(i);
				while (true) {
					i = s1.pop();
					s2.push(i);
				}
			} catch (EmptyStackException e) {}
		}
		
		public T pop() throws EmptyStackException {
			// copy from stack1 to stack2
			if (stack2.isEmpty()) {
				copyFromTo(stack1, stack2);
			}
			return stack2.pop();
		}
		
		public T peek() throws EmptyStackException {
			if (stack2.isEmpty()) {
				copyFromTo(stack1, stack2);
			}
			return stack2.peek();
		}
		
		public void print() {
			try {
				while (true) {
					System.out.println(stack1.pop());
				}
			} catch (EmptyStackException e) {}
		}
	}
	
	static boolean testPush(Queue<Integer> mq) {
		Integer arr[] = new Integer[100];
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			int val = r.nextInt(100);
			arr[i] = new Integer(val);
			mq.push(new Integer(val));
		}
		
		for (int i = 0; i < 100; i++) {
			if (!mq.pop().equals(arr[i])) {
				return false;
			}
		}
		return true;
	}
	
	static boolean testPop(Queue<Integer> mq) {
		// fill
		Integer arr[] = new Integer[100];
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			int val = r.nextInt(100);
			arr[i] = new Integer(val);
			mq.push(new Integer(val));
		}
		
		for (int i = 0; i < 3; i++) {
			Integer value = mq.peek();
			if (!value.equals(mq.pop())) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> mq = new Queue<Integer>();
		
		System.out.println(testPush(mq));
		System.out.println(testPop(mq));
	}

}
