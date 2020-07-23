package interviewQuestions;

import java.util.Random;

/* 
 * Problem set: Return Kth to Last
 */

public class ReturnKthToLast {
	
	private static void returnKthToLast(Node n, int k) {
		Node kIndex = n;
		for (int i = 0; i < k; i++) {
			if (kIndex.next == null) {
				System.out.println("There are less elements than k");
				return;
			}
			kIndex = kIndex.next;
		}
		
		while (kIndex.next != null) {
			n = n.next;
			kIndex = kIndex.next;
		}
		System.out.println(k + "th last element is "+ n.value);
		
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
		System.out.println();
		returnKthToLast(root, 0);
	}

}
