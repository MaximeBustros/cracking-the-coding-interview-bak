package interviewQuestions;

import java.util.Hashtable;

/* 
 * Problem set: Loop Detection
 * Given a circular linked list, implement an algorithm that returns 
 * the node at the beginning of the loop.
 * 
 * Definition: Circular linked list: A (corrupt) linked list in which 
 * a node's next pointer points to an earlier node, 
 * so as to make a loop in the linked list.
 */

public class LoopDetection {

	private static boolean hasLoop(Node ll) {
		Hashtable<Node, Integer> hashtable = new Hashtable<Node, Integer>();
		hashtable.put(ll,1);
		
		while (ll.next != null) {
			ll = ll.next;
			if (hashtable.containsKey(ll)) {
				return true;
			}
			hashtable.put(ll,1);
		}
		return false;
	}
	
	public static void main(String[] args) {
		Node ll = new Node(1);
		ll.next = new Node(2);
		ll.next.next = new Node(3);
		ll.next.next.next = ll.next;
		// should return true
		System.out.println(hasLoop(ll));
		
		Node ll2 = new Node(1);
		ll2.next = new Node(2);
		ll2.next.next = new Node(3);
		// should return false;
		System.out.println(hasLoop(ll2));
		
	}

}
