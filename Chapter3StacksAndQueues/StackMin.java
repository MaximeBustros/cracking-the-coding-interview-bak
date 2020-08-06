import java.util.EmptyStackException;


/*
 * Problem set: Stack Min
 * How would you design a stack which, in addition to push and pop, 
 * has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time. 
 */

/*
 * Solution:
 * We extended our stack and made it so our generic type is comparable.
 * We create a stack to contain each of our minimum values.
 * Whenever we push an item to the stack we check to see if it is smaller
 * than the top of the minimum stack using compareTo.
 * Whenever we remove an item we check to see if the removed item has the 
 * same reference as the top of the minimum stack if it does then
 * we pop it from the minimum stack too
 */

public class StackMin<T extends Comparable<T>>  extends MyStack<T> {
	private MyStack<T> minStack;
	
	public StackMin() {
		super();
		minStack = new MyStack<T>();
	}
	
	@Override
	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		if (top != null) {
			t.next = top;
			if (t.data.compareTo(minStack.peek()) < 0) {
				minStack.push(t.data);
			}
		} else {
			minStack.push(t.data);
		}
		top = t;
	}
	
	@Override
	public T pop() {
		if (top == null) throw new EmptyStackException();
		T item = top.data;
		/*
		 *  NOTE: we compare the reference of the data and not the nodes
		 *  because whenever we push we create a new node but not a 
		 *  new variable.
		 */
		if (top.data == minStack.top.data) {
			minStack.pop();
		}
		top = top.next;
		return item;
	}
	
	/*
	 * Return the current minimum
	 */
	public T currentMin() {
		if (minStack == null) throw new EmptyStackException();
		return minStack.peek();
	}

	public static void main(String[] args) {
		StackMin<Integer> stack = new StackMin<Integer>();
		for (int i = 0; i < 10; i++) {
			// push values from 10 to 0
			stack.push(new Integer(10 - i));
		}
		
		System.out.println(stack.currentMin());
		// this will remove 1-2-3-4-5 so the expected smallest value should be 6
		for (int i = 0; i < 5; i++) {
			stack.pop();
		}
		System.out.println(stack.currentMin());
	}

}
