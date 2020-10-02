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

public class HashMapTest {

	/**
	 * Tests hashmap class
	 */
	@Test
	public void test() {
		GraphNode a = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		GraphNode b = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9", false);
		GraphNode c = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		GraphNode d = new GraphNode("a6725faf-3aac-414e-8d3a-58ab6adab2db", false);
		GraphNode e = new GraphNode("7e885935-2923-42f9-acdc-d6e65ea172e6", false);
		GraphNode f = new GraphNode("aebf38ed-55f4-493e-9e2a-2f78394beb69", false);
		GraphNode g = new GraphNode("0a8b7dc8-fa38-49d2-bba4-3184651da8cc", false);
		HashMap hash = new HashMap();
		hash.set(a, 1);
		hash.set(b, 2);
		hash.set(c, 3);
		hash.set(d, 4);
		hash.print();
		hash.remove(a);
		hash.print();
		hash.set(e, 5);
		hash.set(f, 6);
		hash.set(g, 7);
		hash.print();
		System.out.println(hash.hasKey(g));
		System.out.println(hash.getValue(b));
	}

}
