package interviewQuestions;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class CheckPermutation {
	/*
	 * Problem set: CheckPermutation
	 * Given two strings, write a method to decide if one is a permutation of the other
	 */
	
	/*
	 * Before we speak about a solution let's make sure that we re talking about the 
	 * same thing a permutation is a string of equal length that contains 
	 * exactly the same characters, but in a different order
	 * 
	 * In my opinion the use of a hashtable can be essential for counting the 
	 * number of times each character appears
	 */
	
	public static Hashtable<Character, Integer> countOccurrences(String str) {
		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (table.containsKey(c)) {
				Integer oldVal = table.get(c);
				Integer newVal = oldVal+1;
				table.replace(c, newVal);
			} else {
				table.put(c,1);
			}
		}
		return table;
	}
	
	public static boolean checkPermutationUsingHashTables (Hashtable hash1, Hashtable hash2) {
		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<Character, Integer>> it = hash1.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Character, Integer> entry = it.next();
			Character key = entry.getKey();
			Integer val = entry.getValue();
			if (hash2.containsKey(key) && hash2.get(key) == val) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPermutation(String s1, String s2) {
		// the first check we can do is make sure that both string are of equal length
		if (s1.length() != s2.length()) {
			return false;
		}
		
		// Now we can add all the characters of s1 to a hashtable and count the 
		// number of occurrences
		Hashtable hash1 = countOccurrences(s1);
		// simple solution would be to do the same for s2 and see for each key
		// if the value matches.
		Hashtable hash2 = countOccurrences(s2);
		return checkPermutationUsingHashTables(hash1, hash2);
	}
	
	public static void main(String[] args) {
		// Should equal false
		System.out.println(isPermutation("car", "race"));
		
		// Should be true
		System.out.println(isPermutation("car", "rac"));
		System.out.println(isPermutation("rac", "car"));
		System.out.println(isPermutation("rracc", "ccarr"));
		
		// Should be true
		System.out.println(isPermutation("care", "race"));
		
	}

}
