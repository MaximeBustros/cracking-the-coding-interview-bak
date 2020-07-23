package interviewQuestions;

import java.util.Hashtable;
import java.util.Random;

/*
 * Problem set: Remove dups
 * Write code to remove duplicates from an unsorted linked list.
 */

public class RemoveDups {
	
	private static void removeDups(Node n) {
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		
		table.put(n.value, 1);
		
		while (n.next != null) {
			Node previous = n;
			n = n.next;
			if (!table.containsKey(n.value)) {
				table.put(n.value, 1);
			} else {
				previous.next = n.next;
			}
		}
	}
	
	private static Node generateLinkedlist() {
		Random r = new Random();
		Node root = new Node(r.nextInt(100));
		for (int i = 0; i < 99; i++) {
			int x = r.nextInt(100);
			root.appendToTail(x);
		}
		return root;
	}

	public static void main(String[] args) {
		// create and fill linkedList
		Node root = generateLinkedlist();
		
		root.print();
		removeDups(root);
		System.out.println();
		root.print();
	}

}
