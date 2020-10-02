/**
 * Maya Levisohn
 * COSI21 
 * PA3 due 7/5
 * mlevisohn@brandeis.edu
 */
package main;

public class Entry {

	private int value;
	private GraphNode key; 
	private boolean visited; 
	
	/**
	 * Constructor creates an Entry object
	 * @param newKey - the GraphNode for the Entry
	 * @param newValue - the value for the oject
	 */
	public Entry(GraphNode newKey, int newValue) {
		key = newKey;
		value = newValue; 
	}
	
	/**
	 * Method sets new value for Entry
	 * @param newValue - the new value integer
	 */
	public void setValue(int newValue) {
		value = newValue; 
	}
	
	/**
	 * Method returns value
	 * @return - int value
	 */
	public int getValue() {
		return value; 
	}
	
	/**
	 * Method returns key
	 * @return - GraphNode key
	 */
	public GraphNode getKey() {
		return key; 
	}
}
