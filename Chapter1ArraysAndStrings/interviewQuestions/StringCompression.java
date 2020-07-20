package interviewQuestions;

public class StringCompression {

	/* 
	 * Problem set: String compression:
	 * Implement a method to perform basic string compression using 
	 * the counts of repeated characters.
	 * For example, the string aabcccccaaa would become a2b1c5a3. 
	 * If the "compressed" string would not become smaller than the original string, 
	 * your method should return the original string.
	 * You can assume the string has only uppercase and lowercase letters(a-z)
	 */
	
	public static char[] compress(char[] word) {
		char currentLetter = word[0];
		int count = 1;
		char[] compressedWord = new char[word.length * 2];
		compressedWord[0] = currentLetter;
		
		int compressedIndex = 1;
		for (int wordIndex = 1; wordIndex < word.length; wordIndex++) {
			if (word[wordIndex] != currentLetter) {
				compressedWord[compressedIndex] = (char) (count + '0');
				compressedIndex++;
				
				currentLetter = word[wordIndex];
				compressedWord[compressedIndex] = currentLetter;
				compressedIndex++;
				count = 1;
			} else {
				count++;
			}
		}
		compressedWord[compressedIndex] = (char) (count + '0');
		
		/* 	Explanation:
		 *  Since the max size of the compressed string can be larger than
		 *  the size of the uncompressed word we can try to see length by comparing
		 *  the value at the last index of the uncompressed word.
		 *  
		 *  If that value is the default \u0000 of an undefined char in a char[]
		 *  then we return the compressed word as it is smaller
		 *  if not then we return the original word
		 */
		if (compressedWord[word.length - 1] != '\u0000') {
			return word;
		}
		return compressedWord;
	}
	
	public static void main(String[] args) {
		char[] word = "aabbcc".toCharArray();	// compressed is of same size
		char[] word2 = "abbcc".toCharArray(); 	// compressed is larger
		char[] word3 = "aabbccc".toCharArray(); // compress is shorter
		System.out.println(compress(word)); 	// should return word
		System.out.println(compress(word2));	// should return word
		System.out.println(compress(word3));	// should return compressed
	}

}
