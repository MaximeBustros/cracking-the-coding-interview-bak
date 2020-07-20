package interviewQuestions;

public class OneAway {
	
	/*
	 * Problem set: One Away
	 * There are three types of edits that can be performed on strings: 
	 * insert a character, remove a character, or replace a character. 
	 * Given two strings, write a function to check if they are one edit 
	 * (or zero edits away)
	 */
	
	/*
	 * Solution:
	 * Return true if insert remove or replace equates to true
	 * (Solution needs cleanup since there is some repeated code)
	 */

	public static boolean isInsertAway(String a, String b) {
		double diff = Math.abs(a.length() - b.length());
		if (diff != 1) {
			// for difference in size greater than 1 or equal to 0 return false
			return false;
		}
		
		char[] characters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		if(a.length() < b.length()){
			// we insert on a all possible characters at each possible index
			for (int index = 0; index < b.length(); index++) {
				for (int j = 0; j < characters.length; j++) {
					String s = a.substring(0, index) + characters[j] + a.substring(index+1);
					if (s.contentEquals(b)) {
						System.out.println("are one insert away");
						return true;
					}
				}
			}
		} else {
			for (int index = 0; index < a.length(); index++) {
				for (int j = 0; j < characters.length; j++) {
					String s = b.substring(0, index) + characters[j] + b.substring(index);
					if (s.contentEquals(a)) {
						System.out.println("are one insert away: ");
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean isRemoveAway(String a, String b) {
		double diff = Math.abs(a.length() - b.length());
		if (diff != 1) {
			// for difference in size greater than 1 or equal to 0 return false
			return false;
		}
		
		if(a.length() < b.length()) {
			for (int i = 0; i < a.length() + 1; i++) {
				if (a.contentEquals(b.substring(0,i) + b.substring(i+1))) {
					System.out.println("are one remove away");
					return true;
				}
			}
		} else {
			for (int i = 0; i < b.length() + 1; i++) {
				if (b.contentEquals(a.substring(0,i) + a.substring(i+1))) {
					System.out.println("are one remove away");
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isReplaceAway(String a, String b) {
		double diff = Math.abs(a.length() - b.length());
		if (diff > 0) {
			// for difference in size greater or equal to 1 then return false 
			return false;
		}
		char[] characters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < a.length() - 1; i++) {
			for (int j = 0; j < characters.length; j++) {
				String val = a.substring(0, i) + characters[j] + a.substring(i + 1);
				if (b.contentEquals(val)) {
					System.out.println("are one replace away");
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean isOneAway(String a, String b) {
		return isInsertAway(a,b) || isRemoveAway(a,b) || isReplaceAway(a,b);
	}
	public static void main(String[] args) {
		System.out.println(isOneAway("pale", "ple")); // true
		System.out.println(isOneAway("pales", "pale")); // true
		System.out.println(isOneAway("pale", "bale")); // true
		System.out.println(isOneAway("pale", "bake")); // false
		
	}

}
