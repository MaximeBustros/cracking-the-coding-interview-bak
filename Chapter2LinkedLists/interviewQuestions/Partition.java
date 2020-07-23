package interviewQuestions;

import java.util.Random;

/*
 * Problem set: Partition
 * Write code to partition a linked list around a value x, 
 * such that all nodes less than x come before all nodes greater than or equal to x. 
 * if x is contained within the list, the values of x only need to be after 
 * the elements less than x. 
 * The partition element x can appear anywhere in the "right partition"; 
 * It does not need to appear between the left and right partitions.
 */
public class Partition {

	private static Node partition(Node node, int value) {
		Node root = node;
		
		while (node.next != null) {
			if (node.next.value < value) {
				Node smallerThanPartitionNode = node.next;
				if (smallerThanPartitionNode.next != null) {
					node.next = smallerThanPartitionNode.next;
					smallerThanPartitionNode.next = root;
					// new root
					root = smallerThanPartitionNode;
				} else {
					node.next = null;
					smallerThanPartitionNode.next = root;
					root = smallerThanPartitionNode;
					return root;
				}
			} else {
				node = node.next;
			}
		}
		return root;
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
		Node newRoot = partition(root, 20);
		newRoot.print();
	}

}
