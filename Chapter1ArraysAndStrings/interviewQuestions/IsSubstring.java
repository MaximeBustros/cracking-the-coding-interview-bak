package interviewQuestions;

public class IsSubstring {

	/* Problem set: String Rotation
	 * Assume you have a method isSubstring which checks if one word 
	 * is a substring of another.
	 * Given two strings, s1 and s2, write code to check if s2 is a 
	 * rotation of s1 using only one call to isSubstring 
	 * (e.g., "waterbottle" is a rotation of "erbottlewat").
	 */
	
	public static int getFirstMatch(char[] a, char[] b) {
		// iterate over b to find the first letter that matches a's first letter
		for (int i = 0; i < b.length; i++) {
			if (b[i] == a[0]) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean isSubstring(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		
		// convert to char to iterate
		char[] aCharArray = a.toCharArray();
		char[] bCharArray = b.toCharArray();
		
		int matchIndex = getFirstMatch(aCharArray, bCharArray);
		if (matchIndex > -1) {
			// if found a match proceed comparison
			for (int i = 1; i < aCharArray.length; i++) {
				matchIndex = (matchIndex + 1) % bCharArray.length;
				if (aCharArray[i] != bCharArray[matchIndex]) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "waterbottle";
		String b = "erbottlewat";
		String c = "terbottlewa";
		
		System.out.println(isSubstring(a,b));
		System.out.println(isSubstring(a,c));
		System.out.println(isSubstring(b,c));
	}

}
