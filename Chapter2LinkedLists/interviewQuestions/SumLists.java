package interviewQuestions;

import java.util.Random;

/*
 * Problem set: Sum Lists
 * You have two numbers represented by a linked list, 
 * where each node contains a single digit.
 * The digits are stored in reverse order, 
 * such that the 1's digit is at the head of the list. 
 * Write a function that adds the two numbers and returns 
 * the sum as a linked list.
 * 
 */
public class SumLists {

	private static Node sumLists(Node l1, Node l2) {
		int count = 0;
		int sum = l1.value + l2.value + count;
		Node root = new Node(0);
		if (sum >= 10) {
			count = 1;
		} else {
			count = 0;
		}
		root.value = sum % 10;
		
		Node sumlist = root;
		while (true) {
			if (l1.next != null && l2.next != null) {
				l1 = l1.next;
				l2 = l2.next;
				sum = l1.value + l2.value + count;
				if (sum >= 10) {
					count = 1;
				} else {
					count = 0;
				}
				sumlist.next = new Node(sum % 10);
				sumlist = sumlist.next;
			} else if (l1.next != null) {
				l1 = l1.next;
				sumlist.next = new Node(l1.value + count);
			} else if (l2.next != null) {
				l2 = l2.next;
				sumlist.next = new Node(l1.value + count);
			} else if (count == 1) {
				sumlist.next = new Node(count);
				count = 0;
			} else {
				return root;
			}
		}
	}
	
	private static Node generateLinkedlist(int size) {
		Random r = new Random();
		Node root = new Node(r.nextInt(10));
		for (int i = 0; i < size - 1; i++) {
			int x = r.nextInt(10);
			root.appendToTail(x);
		}
		return root;
	}
	
	public static void main(String[] args) {
		// create two linked list of 3 digits representing a 3 digit number 
		// where the head of the list represent the first digit
		Node l1 = generateLinkedlist(3);
		Node l2 = generateLinkedlist(3);
		l1.print();
		System.out.println();
		l2.print();
		System.out.println();
		Node newRoot = sumLists(l1, l2);
		System.out.println("Sum =");
		newRoot.print();
	}
}
