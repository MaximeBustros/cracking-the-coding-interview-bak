package stringBuilder;

import java.util.ArrayList;

public class StringBuilder {
	private ArrayList<String> arr;
	
	public StringBuilder() {
		arr = new ArrayList<String>();
	}
	
	public void append(String s) {
		arr.add(s);
	}
	
	public void printString() {
		for (String s : arr) {
			System.out.print(s + " ");
		}
	}

}
