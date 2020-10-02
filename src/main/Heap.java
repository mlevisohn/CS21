/**
 * Maya Levisohn
 * COSI21 
 * PA3 due 7/5
 * mlevisohn@brandeis.edu
 */
package main;

public class Heap {
	private GraphNode[] heap;
	private int capacity;
	private int size;
	private HashMap hash = new HashMap(); ////
	
	public Heap() {
		heap = new GraphNode[1]; 
		capacity = 1; 
	}
	
	public Heap(int length) {
		heap = new GraphNode[length];
		capacity = length;
	}
	
	/**
	 * Method inserts a graphNode into the heap
	 * @param g - given GraphNode 
	 */
	public void insert(GraphNode g) {
		if (size==capacity) {
			capacity = 2*capacity;
			GraphNode[] temp = new GraphNode[capacity];
			for (int i=0; i<size; i++) {
				temp[i]=heap[i];	
			}
			heap = temp; 
		}
		size++;
		heap[size-1]=g;
		hash.set(g, size-1);
		this.heapifyUp(heap[size-1]);
	}
	
	/**
	 * Method returns the min value in the heap
	 * @return graphNode  min
	 */
	public GraphNode min() {
		return heap[0];
	}

	/**
	 * Method deletes and returns the min value from the heap 
	 * @return graphNode min
	 */
	public GraphNode deleteMin() {
		if (size>1) {
			GraphNode min = heap[0];
			heap[0]=heap[size-1];
			heap[size-1]=null;
			size--; 
			hash.set(heap[0], 0);
			this.heapifyDown(heap[0]);
			hash.remove(min);
			return min; 
		}
		else {
			GraphNode min = heap[0];
			heap[0]=null; 
			size--; 
			hash.remove(min);
			return min; 
		}
	}
	
	/**
	 * Returns the index of the left child in the heap 
	 * @param g - graphNode 
	 * @return int of child 
	 */
	public int left(GraphNode g) {
		return ((hash.getValue(g)+1)*2)-1;
	}
	
	/**
	 * Returns the index of the right child in the heap 
	 * @param g - graphNode 
	 * @return int of child 
	 */
	public int right(GraphNode g) {
		return ((hash.getValue(g)+1)*2);
	}
	
	/**
	 * Returns the index of the parent in the heap 
	 * @param g - graphNode 
	 * @return int of parent 
	 */
	public int parent(GraphNode g) {
		return ((hash.getValue(g)+1)/2)-1;
	}
	
	/**
	 * Method rebalances the min heap property 
	 * @param g - graphNode that is off balance
	 */
	public void heapify(GraphNode g) {
		if (hash.getValue(g)>0&&g.priority<heap[this.parent(g)].priority) {
			this.heapifyUp(g);
		}
		else if (this.right(g)<size&&g.priority>heap[this.right(g)].priority) {
			this.heapifyDown(g);
		}
		else if (this.left(g)<size&&g.priority>heap[this.left(g)].priority) {
			this.heapifyDown(g);
		}
	}
	
	/**
	 * Helper method for heapify - percolates down the heap 
	 * @param g - graphNode
	 */
	public void heapifyDown(GraphNode g) {
		int index = hash.getValue(g); 
		int left = this.left(g);
		int right = this.right(g);
		int swap = 0; 
		if (left<size && heap[this.left(g)].priority<g.priority) {
			swap = left;
		}
		else {
			swap = index;
		}
		if (right<size&&heap[this.right(g)].priority<heap[swap].priority) {
			swap = right;
		}
		if (swap!=index) {
			GraphNode temp = g;
			heap[index]=heap[swap];
			heap[swap]=temp;
			hash.set(heap[index], index);
			hash.set(g, swap);
			heapifyDown(g);
		}
	}
	
	/**
	 * Helper method for heapify - percolates up the heap 
	 * @param g - graphNode 
	 */
	public void heapifyUp(GraphNode g) {
		int index = hash.getValue(g);
		while (index>0&&heap[this.parent(g)].priority>g.priority) {
			int temp = this.parent(g);
			heap[index]=heap[this.parent(g)];
			heap[temp]=g;
			hash.set(heap[index], index);
			hash.set(g, temp);
			index = temp; 
		}
	}
	
	/**
	 * Returns true if the heap has a given graphNode
	 * @param g - graphNode
	 * @return boolean
	 */
	public boolean hasNode(GraphNode g) {
		return hash.hasKey(g);
	}
	
	/**
	 * Method accesses hashmap for testing purposes 
	 * @return hashmap array
	 */
	public HashMap accessHashMap() {
		return hash; 
	}
	
	/**
	 * Returns true if heap is empty
	 * @return boolean
	 */
	public boolean isEmpty() {
		return size==0; 
	}
	
	/**
	 * Prints the heap for testing purposes 
	 */
	public void print() {
		for (int i=0; i<capacity; i++) {
			System.out.println(i+" - "+heap[i]);
		}
	}
}
