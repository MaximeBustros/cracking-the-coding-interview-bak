import java.util.Random;

public class ThreeInOne {

	/*
	 * Problem set: Three in one
	 * Describe how you could use a single array to implement three stacks
	 */
	
	int[] data; 		// contains the actual data
	int[] top;			// contains the index of the top element of each stack
	int[] next;			// 
	int addIndex = 0;
	
	public ThreeInOne(int numberOfElements) {
		final int NUMBER_OF_STACKS = 3;
		this.top = new int[NUMBER_OF_STACKS];
		this.next = new int[numberOfElements + NUMBER_OF_STACKS];
		this.data = new int[numberOfElements + NUMBER_OF_STACKS];
		
		// Initialize top as -1
		for (int i = 0; i < NUMBER_OF_STACKS; i++) {
			this.top[i] = i;
			this.next[i] = -1; // next = -1 indicates that there is no value;
			this.data[i] = -1;
			addIndex++;
		}
		
		// containing all data
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			int d = r.nextInt(100);
			// push random data to a random stack
			push(d, r.nextInt(NUMBER_OF_STACKS));
		}
	}
	
	public void push(int item, int stackNumber) {
		// add data
		data[addIndex] = item;
		// make next point to previous top
		this.next[addIndex] = this.top[stackNumber];
		// new top is the index of the new item
		this.top[stackNumber] = addIndex;
		// increment add index
		addIndex++;
	}
	
	public int pop(int stackNumber) {
		int index = this.top[stackNumber];
		this.top[stackNumber] = this.next[index];
		return this.data[index];
	}
	
	public void printStack(int stackNumber) {
		// points to the index of the top
		int stack = this.top[stackNumber];
		while(data[stack] != -1) {
			System.out.println(data[stack]);
			stack = next[stack];
		}
	}
	
	
	public static void main(String args[]) {
		ThreeInOne tio = new ThreeInOne(100);
		tio.printStack(2);
	}
	
}
