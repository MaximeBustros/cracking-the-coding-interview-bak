package hashTable;

public class HashTable {
	LinkedList[] table;
	final int N = (int) Math.pow(2, 28);
	
	public HashTable() {
		table = new LinkedList[N];
	}
	
	public void append(String value) {
		int hash = hashCode(value);
		if (table[hash] == null) {
			table[hash] = new LinkedList(new Node(value));
		} else {
			table[hash].append(value);
		}

	}
	
	public int hashCode(String str) {
		int hash = 0;
		int p = 7;
		int p_pow = 1;
		for (int i = 0; i < str.length(); i++) {
			int c = str.charAt(i);
			hash = (hash + c * p) % N;
	        p_pow = (p_pow * p) % N;
		}
		// an integer is 4 bytes so we can set p = 31 and us
		hash = hash % N;
		System.out.println(hash);
		return hash;
	}
	
	public LinkedList getByIndex(int index) {
		return this.table[index];
	}
}
