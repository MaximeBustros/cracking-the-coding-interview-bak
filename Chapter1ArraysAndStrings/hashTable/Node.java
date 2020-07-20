package hashTable;

public class Node {
	String value;
	Node next;
	
	public Node() {
		this.value = null;
		this.next = null;
	}
	
	public Node(String value) {
		this.value = value;
		this.next = null;
	}
	
	public Node getNext() {
		return next;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
}
