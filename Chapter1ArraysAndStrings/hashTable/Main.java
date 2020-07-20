package hashTable;

public class Main {

	public static void main(String[] args) {
		
//		LinkedList l = new LinkedList(new Node("number1"));
//		l.append("number2");
//		System.out.println(l);
		HashTable hashtable = new HashTable();
		String text = "test";
		String text2 = "test2";
		hashtable.append(text);
		hashtable.append(text);
		hashtable.append(text);
		hashtable.append(text2);
		hashtable.append(text2);
		
		int hashcode = hashtable.hashCode(text);
		int hashcode2 = hashtable.hashCode(text2);
		System.out.println(hashcode);
		LinkedList l = hashtable.getByIndex(hashcode);
		LinkedList l2 = hashtable.getByIndex(hashcode2);
		System.out.println(l.toString());
		System.out.println(l2.toString());
	}

}
