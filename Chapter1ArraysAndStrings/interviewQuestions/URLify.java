package interviewQuestions;

public class URLify {

	/*
	 * Problem set: URLify
	 * Write a method to replace all spaces in a string with '%20'.
	 * You may assume that the string has sufficient space at the 
	 * end to hold the additional characters, and that you are given the "true"
	 * length of the string. (Note: Use a character array in java)
	 */
	
	public static char[] urlify(String s) {
		// convert to Array of characters
		int maxPossibleSize = s.length() * 3;
		char[] urlifiedChars = new char[maxPossibleSize];
		char[] chars = s.toCharArray();
		
		int urlifiedIndex = 0;
		for (int index = 0; index < chars.length; index++, urlifiedIndex++) {
			if (chars[index] == ' ') {
				urlifiedChars[urlifiedIndex++] = '%';
				urlifiedChars[urlifiedIndex++] = '2';
				urlifiedChars[urlifiedIndex] = '0';
			} else {
				urlifiedChars[urlifiedIndex] = chars[index];
			}
		}
		return urlifiedChars;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Mr John Smith";
		String s2 = "             ";
		System.out.println(urlify(s));
		System.out.println(urlify(s2));
	}

}
