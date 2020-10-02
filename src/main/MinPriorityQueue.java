package main;

public class MinPriorityQueue {
	private Heap heap = new Heap(); 
	
	/**
	 * Inserts a graphNode into the queue using the heap method 
	 * @param g - graphNode to be inserted
	 */
	public void insert(GraphNode g) {
		heap.insert(g);
	}
	
	/**
	 * Deletes and returns the graphNode with the highest priority 
	 * @return graphNode min 
	 */
	public GraphNode pullHighestPriorityElement() {
		return heap.deleteMin(); 
	}
	
	/**
	 * Returns the graphNode with the highest priority 
	 * @return graphNode min
	 */
	public GraphNode getHighestPriorityElement() {
		return heap.min();
	}
	
	/**
	 * Method rebalances the heap representing the priority queue
	 * @param g - graphNode out of place
	 */
	public void rebalance(GraphNode g) {
		heap.heapify(g);
	}
	
	/**
	 * Returns true if the queue contains a given node 
	 * @param g - graphNode
	 * @return boolean
	 */
	public boolean queueHasNode(GraphNode g) {
		return heap.hasNode(g);
	}
	
	/**
	 * Returns true if the queue is empty 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}
}
