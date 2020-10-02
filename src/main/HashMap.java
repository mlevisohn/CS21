/**
 * Maya Levisohn
 * COSI21 
 * PA3 due 7/5
 * mlevisohn@brandeis.edu
 */
package main;

public class HashMap {
	
	private Entry[] table; 
	private int capacity;
	private int size; 
	
	public HashMap() {
		capacity = 10; 
		table = new Entry[capacity];
	}
	
	/**
	 * Method sets a GraphNode and value in the hashMap
	 * @param key - graphNode
	 * @param value - int value representing index in heap 
	 */
	public void set(GraphNode key, int value) {
		if ((double) size/capacity>0.5) { 
			table=this.reHash(); 
		}
		boolean placed = false;  
		int putItHereIfItsNotAnywhereElse = capacity; 
		for (int i=0; i<capacity; i++) {
			int index = this.hash(key, i);
			if (table[index]!=null&&table[index].getKey()==key&&table[index].getValue()!=-1) {
				table[index].setValue(value);
				placed = true; 
				break;
			}
			else if (table[index]==null) {
				if (putItHereIfItsNotAnywhereElse==capacity) {
					putItHereIfItsNotAnywhereElse = index; 
				}
				break;
			}
			else if (table[index].getValue()==-1) {
				if (putItHereIfItsNotAnywhereElse==capacity) {
					putItHereIfItsNotAnywhereElse = index; 
				}
			}
		} 
		if (placed == false) {
			Entry e = new Entry(key, value);
			table[putItHereIfItsNotAnywhereElse]=e; 
			size++;
		}
	}
	
	/**
	 * Method expands the hashmap if load factor > 0.5
	 * @return new expanded hashmap
	 */
	public Entry[] reHash() {
		capacity = 2*capacity;
		Entry[] rehash = new Entry[capacity];
		for (int i=0; i<capacity/2; i++) {
			if (table[i]!=null) {
				for (int j=0; j<capacity; j++) {
					int index = this.hash(table[i].getKey(), j);
					if (rehash[index]==null||rehash[index].getValue()==-1) {
						rehash[index]=table[i]; 
						break;
					}
				}
			}
		}
		
		return rehash; 
	}
	
	/**
	 * Removes the given GraphNode from the hashmap
	 * @param g - the graphNode being removed
	 */
	public void remove(GraphNode g) { 
		for (int i=0; i<capacity; i++) {
			int index = this.hash(g, i);
			if (table[index]!=null) {
				if (table[index].getKey()==g&&table[index].getValue()!=-1) { /////
					table[index].setValue(-1);
					size--; 
				}
			}
		}
	}
	
	/**
	 * Method returns the value of a given graphNode
	 * @param g - given graphNode
	 * @return - int value of given graphNode 
	 */
	public int getValue(GraphNode g) { 
		for (int i=0; i<capacity; i++) {
			int index = this.hash(g, i);
			if (table[index]!=null) {
				if (table[index].getKey()==g) {
					return table[index].getValue();
				}
			}
		}
		return -1; 
	}
	
	/**
	 * Method returns true if the graphNode is currently in the queue
	 * @param g - graphNode
	 * @return boolean
	 */
	public boolean hasKey(GraphNode g) {
		for (int i=0; i<capacity; i++) {
			int index = this.hash(g, i);
			if (table[index]!=null) {
				if (table[index].getKey()==g) {
					return true;
				}
			}
		}
		return false; 
	}
	
	/**
	 * Returns the hash index for a given key and linear probe factor x
	 * @param key - graphNode
	 * @param x - the number of times the graphNode hash index was already taken 
	 * @return int hash index 
	 */
	public int hash(GraphNode key, int x) {
		String id = key.getId();
		int i = 0; 
		int k = 0; 
		while (id.charAt(i)!='-') { //hash function takes the first 8 characters, adds ascii values
			k += (int) id.charAt(i); 
			i++;
		}
		return (k+x)%capacity; //mod m
	}
	
	/**
	 * Prints the hash table for test purposes 
	 */
	public void print() {
		for (int i=0; i<capacity; i++) {
			if (table[i]!=null) {
				System.out.println(i+"  "+table[i].getValue()+"  "+table[i].getKey().getId());
			}
			else {
				System.out.println(i+"    ----null----    ");
			}
		}
		System.out.println();
	}
	
}
