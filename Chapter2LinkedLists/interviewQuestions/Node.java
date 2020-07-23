package interviewQuestions;

public class Node {
	public int value;
	public Node next = null;
	
	public Node(int val) {
		value = val;
	}
	
	public void print() {
		Node n = this;
		System.out.print(n.value +", ");
		while (n.next != null) {
			n = n.next;
			System.out.print(n.value + ", ");
		}
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
