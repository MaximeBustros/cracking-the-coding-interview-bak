package interviewQuestions;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import java.util.Stack;

/*
 * Problem set: Palindrome
 * Implement a function to check if a linked list is a palindrome
 */

public class Palindrome {
	
	private static boolean isPalindrome(Node ll) {
		Stack<Integer> stack = pushToStack(ll);
		
		int size = stack.size() / 2;
		// iterate in reverse order
		ListIterator<Integer> it = stack.listIterator(stack.size());
		for (int i = 0; i < size; i++) {
			int val = it.previous();
			System.out.println(val);
			if (val != ll.value) {
				return false;
			}
			ll = ll.next;
		}
		return true;
	}
	
	private static Stack<Integer> pushToStack(Node ll) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(ll.value);
		
		while(ll.next != null) {
			ll = ll.next;
			stack.push(ll.value);
		}
		return stack;
	}
	
	public static void main(String[] args) {
		// create two linked list of 3 digits representing a 3 digit number 
		// where the head of the list represent the first digit
		Node root = new Node(3);
		root.next = new Node(1);
		root.next.next = new Node(2);
		root.next.next.next = new Node(1);
		root.next.next.next.next = new Node(3);
		root.print();
		System.out.println();
		System.out.println("Is a palindrome: " + isPalindrome(root));
	}

}
