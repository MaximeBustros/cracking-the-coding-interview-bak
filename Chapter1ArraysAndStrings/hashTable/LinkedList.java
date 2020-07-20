package hashTable;

public class LinkedList {
	Node root;
	
	public LinkedList() {
		this.root = new Node();
	}
	
	public LinkedList(Node root) {
		this.root = root;
	}
	
	public void append(String value) {
		Node node = this.root;
		while (node.getNext() != null) {
			node = node.getNext();
		}
		node.setNext(new Node(value));
	}
	
	@Override
	public String toString() {
		Node node = this.root;
		String str = node.getValue();
		node = node.getNext();
		while (node != null) {
			String val = node.getValue();
			str += ", " + val;
			node = node.getNext();
		}
		return str;
	}
}
