package interviewQuestions;

import java.util.Random;

/*
 * Problem set: Delete Middle Node
 * Implement an algorithm to delete a node in the middle
 * 
 */
public class DeleteMiddleNode {
	
	public static void deleteMiddleNode(Node node) {
		Node index1 = node;
		Node index2 = node;
		
		if (index1.next == null) {
			return;
		} else if (index1.next.next == null) {
			index1.next = index1.next.next;
		}
		
		// second index starts two places ahead
		index2 = index2.next.next;
		while (index2.next.next != null) {
			index2 = index2.next.next;
			index1 = index1.next;
			
			// check if next is null to avoid null pointer exceptions
			if (index2.next == null)
				break;
		}
		
		index1.next = index1.next.next;
	}
	
	private static Node generateLinkedlist() {
		Random r = new Random();
		Node root = new Node(r.nextInt(100));
		for (int i = 0; i < 4; i++) {
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
		deleteMiddleNode(root);
		root.print();
	}
}
