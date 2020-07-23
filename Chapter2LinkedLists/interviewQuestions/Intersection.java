package interviewQuestions;

import java.util.Hashtable;

/* 
 * Problem set: Intersection
 * Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is defined 
 * based on reference, not value.
 * That is, if the kth node of the first linked list is the exact 
 * same node (by reference) as the jth node of the second linked list, 
 * then they are intersecting.
 */
public class Intersection {
	
	private static Node intersection(Node ll1, Node ll2) {
		Hashtable<Node, Integer> hashtable = new Hashtable<Node, Integer>();
		
		// fill hash table with references
		hashtable.put(ll1, 1);
		while (ll1.next != null) {
			ll1 = ll1.next;
			hashtable.put(ll1, 1);
		}
		
		if (hashtable.containsKey(ll2)) {
			return ll2;
		}
		
		while (ll2.next != null) {
			ll2 = ll2.next;
			if (hashtable.containsKey(ll2)) {
				return ll2;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Node ll = new Node(1);
		ll.next = new Node(2);
		ll.next.next = new Node(3);
		ll.next.next.next = new Node(4);
		
		Node x = new Node(2);
		x.next = ll.next;
		
		Node n = intersection(ll, x);
		if (n != null) {
			System.out.println("Memory reference: " + Integer.toHexString(System.identityHashCode(n)));
			System.out.println("Value of node: " + n.value);
		} else {
			System.out.println("Could not find any intersections between the two linked lists");
		}
	}

}
