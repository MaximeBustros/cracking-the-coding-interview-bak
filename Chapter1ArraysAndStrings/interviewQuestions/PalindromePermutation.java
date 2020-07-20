package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutation {
	/*
	 * Problem set: Palindrome Permutation
	 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same fowards and backwards.
	 * A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
	 * Example
	 * Input:		Tact Coa
	 * Output:		True (permutations: "taco cat", atco cta)
	 */
	
	/* Solution:
	 * so the idea is to check if a given word is a permutation of a palindrome
	 * The idea would be that we would write a function that would check if a word
	 * is a palindrome
	 * and the second thing to do would be to create all the possible permutation and run
	 * them against that function.
	 * If any of the permutation return true then the function returns true
	 */
	
	public static boolean isPalindrome(ArrayList<Character> chars) {
		int len = chars.size();
		for (int index = 0; index < len; index++) {
			if (chars.get(index) != chars.get(len-index-1))
				return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static void ret(ArrayList<Character> currentCharacters, ArrayList<Character> charactersLeft, ArrayList<ArrayList<Character>> permutations) {
		if (charactersLeft.isEmpty()) {
//			printArrayList(currentCharacters);
			permutations.add(currentCharacters);
			return;
		}
		
		for (int i = 0; i < charactersLeft.size(); i++) {
			ArrayList<Character> charactersLeftCopy = (ArrayList<Character>) charactersLeft.clone();
			ArrayList<Character> currentCharactersCopy = (ArrayList<Character>) currentCharacters.clone();
			
			currentCharactersCopy.add(charactersLeft.get(i));
			charactersLeftCopy.remove(i);
			ret(currentCharactersCopy, charactersLeftCopy, permutations);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<ArrayList<Character>> getPermutations(ArrayList<Character> str) {
		ArrayList<ArrayList<Character>> permutations = new ArrayList<ArrayList<Character>>();
		for (int i = 0; i < str.size(); i++) {
			ArrayList<Character> charactersLeft = (ArrayList<Character>) str.clone();
			ArrayList<Character> currentCharacters = new ArrayList<Character>();
			
			currentCharacters.add(charactersLeft.get(i));
			charactersLeft.remove(i);
			ret(currentCharacters, charactersLeft, permutations);
		}
		return permutations;
	}
	
	public static void printArrayList(List<Character> str) {
		for (Character ch: str) {
			System.out.print(ch);
		}
		System.out.println();
	}
	
	public static void printListOfWords(ArrayList<ArrayList<Character>> listOfWords) {
		for (ArrayList<Character> str: listOfWords) {
			printArrayList(str);
		}
	}
	
	public static boolean isPalindromePermutation(ArrayList<Character> word ) {
		// gets all possible permutations
		ArrayList<ArrayList<Character>> listOfPermutations = getPermutations(word);
		// printListOfWords(listOfPermutations);
		
		// test if any word is a palindrome
		for (ArrayList<Character> w : listOfPermutations) {
			if (isPalindrome(w))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[] c = "test".toLowerCase().toCharArray();
		ArrayList<Character> word = new ArrayList<Character>();
		
		// copy to array list
		for (int i = 0; i< c.length; i++) {
			word.add(c[i]);
		}
		
		System.out.println(isPalindromePermutation(word));
	}

}
