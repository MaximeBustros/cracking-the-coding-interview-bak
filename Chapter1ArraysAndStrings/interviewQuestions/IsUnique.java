package interviewQuestions;
import java.util.ArrayList;
import java.util.Hashtable;

/* Question:
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data stuctures
 */

/*
 * Answer:
 * The problem we face is that we cannot use hashtables to make sure if a key
 * that was previously added to check for uniqueness of characters
 * 
 * One obvious answer is that we compare any new character with the previously 
 * seen characters
 * 
 * if we were able to use hashtables we could check if key exists before adding
 * if it exists already then we would return false
 */

public class IsUnique {
	
	public static boolean isUnique(String str) {	
		ArrayList<Character> letters = new ArrayList<Character>();

		// iterate over each character in string received
		for (int i = 0; i < str.length(); i++) {
			Character c1 = str.charAt(i);
			for (Character c : letters) {
				if (c == c1) {
					return false;
				}
			}
			// add to arrayList of characters
			letters.add(c1);
		}
		return true;
	}
	
	public static boolean isUniqueWithHash(String str) {
		Hashtable<Character, Integer> hashtable = new Hashtable<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (hashtable.containsKey(c)) {
				return false;
			}
			hashtable.put(c, 1);
		}
		return true;
	}

	public static void main(String[] args) {
		// Dummy solution
		System.out.println(isUnique("test"));
		System.out.println(isUnique("antic"));
		
		// With hashtables
		System.out.println(isUniqueWithHash("test"));
		System.out.println(isUniqueWithHash("antic"));
	}
}
