import java.util.ArrayList;

/*
 * Problem set: Stack of Plates
 * Image a (literal) stack of plates. If the stack gets too high,
 * it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous 
 * stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks and should create a new stack 
 * once the previous one exceeds capacity.
 * SetOfStacks.push() and Set OfStacks.pop() should behave identically to a single stack.
 * Implement a function popAt(int index) which performs a pop operation 
 * on a specific sub-stack.
 */
public class StackOfPlates<T> {
	private static class SetOfStacks<T> {
		private int capacity;
		private ArrayList<MyStack<T>> stacks;
		private ArrayList<Integer> sizes;
		private int currentStackIndex = 0;
		
		public SetOfStacks(int capacity) {
			this.capacity = capacity;
			stacks = new ArrayList<MyStack<T>>();
			sizes = new ArrayList<Integer>();
			stacks.add(new MyStack<T>());
			sizes.add(new Integer(0));
		}
		
		public void push(T item) {
			if(sizes.get(currentStackIndex).equals(capacity)) {
				currentStackIndex++;
				stacks.add(new MyStack<T>());
				sizes.add(new Integer(0));
			}
			stacks.get(currentStackIndex).push(item);
			sizes.set(currentStackIndex, sizes.get(currentStackIndex) + 1);
		}
		
		public T pop() {
			if (stacks.get(currentStackIndex).top == null) {
				stacks.remove(currentStackIndex);
				sizes.remove(currentStackIndex);
				currentStackIndex--;
				return pop(); 	// if we remove all items in a the before last stack
								// and try to pop from the last stack the last item
								// then it will try to pop from an empty stack
								// and throw an error
			}
			T item = stacks.get(currentStackIndex).pop();
			sizes.set(currentStackIndex, sizes.get(currentStackIndex) - 1);
			return item;
		}
		
		public T popAt(int index) throws Exception {
			T s;
			try {
				s = stacks.get(index).pop();
				sizes.set(index, sizes.get(index) - 1);
			} catch (Exception e) {
				throw e;
			}
			return s;
		}
		
		public T peek() {
			return stacks.get(currentStackIndex).peek();
		}
	}
	
	
	public static void main(String[] args) {
		SetOfStacks<Integer> set = new SetOfStacks<Integer>(10);
		for (int i = 1; i <= 31; i++) {
			set.push(i);
		}
		// first stack 1-10, second 11-20, third 21-30, fourth 31 only
		System.out.println(set.peek()); // should return 31
		
		// now let's pop all from third
		for (int i = 0; i < 10; i++) {
			try {
				set.popAt(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(set.peek()); // should still return 31
		
		System.out.println(set.pop()); // should pop 31
		
		System.out.println(set.pop()); // should return 20 as 21-30 have been removed
	}
}


