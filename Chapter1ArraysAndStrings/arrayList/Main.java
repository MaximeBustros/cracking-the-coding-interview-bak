package arrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList dynamicArray = new ArrayList();
		// Code for testing arrayList
		// We try to see how the size evolves (x2) when we reach the max size
		dynamicArray.append(10);
		dynamicArray.logSize();
		dynamicArray.append(10);
		dynamicArray.append(10);
		dynamicArray.logSize();
		dynamicArray.append(10);
		dynamicArray.append(10);
		dynamicArray.append(10);
		dynamicArray.append(10);
		dynamicArray.logSize();		
	}

}
