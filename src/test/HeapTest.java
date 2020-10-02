/**
 * Maya Levisohn
 * COSI21 
 * PA3 due 7/5
 * mlevisohn@brandeis.edu
 */
package test;
import main.*; 

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {

	/**
	 * Tests heap class
	 */
	@Test
	public void test() {
		GraphNode a = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		GraphNode b = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		GraphNode c = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		GraphNode d = new GraphNode("a6725faf-3aac-414e-8d3a-58ab6adab2db", false);
		GraphNode e = new GraphNode("7e885935-2923-42f9-acdc-d6e65ea172e6", false);
		GraphNode f = new GraphNode("aebf38ed-55f4-493e-9e2a-2f78394beb69", false);
		Heap heap = new Heap(); 
		heap.print();
		heap.accessHashMap().print();
		a.priority = 10;
		b.priority = 14;
		c.priority = 25;
		d.priority = 17;
		e.priority = 8;
		f.priority = 22;
		heap.insert(a);
		heap.insert(b);
		heap.insert(c);
		heap.print();
		heap.accessHashMap().print();
		heap.deleteMin();
		heap.print();
		heap.accessHashMap().print();
		heap.insert(e);
		heap.print();
		heap.accessHashMap().print();
		assertEquals(heap.min(), e);
		heap.insert(d);
		heap.print();
		heap.accessHashMap().print();
		heap.insert(f);
		heap.print();
		heap.accessHashMap().print();
		heap.deleteMin();
		assertEquals(heap.min(), b);
	}

}
