package arrayList;

public class ArrayList {
	private int[] array;
	private int array_size;
	private int index;
	
	// Constructor
	public ArrayList() {
		this.index = 0;
		this.array_size = 2;
		this.array = new int[this.array_size];
	}
	
	public void append(int val) {
		this.index++;
		if (this.index >= this.array_size) {
			growArraySize();
		}
		array[this.index] = val;
	}
	
	public void logSize() {
		System.out.println(this.array_size);
	}
	
	private void growArraySize() {
		int[] tmp = new int[this.array_size];
		copy(array, tmp);
		this.array_size *= 2;
		this.array = new int[this.array_size];
		copy(tmp, array);
	}
	
	private static void copy(int[] from, int[] into) {
		for (int i = 0; i < from.length; i++) {
			into[i] = from[i];
		}
	}
}
