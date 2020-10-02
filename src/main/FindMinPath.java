/**
 * Maya Levisohn
 * COSI21 
 * PA3 due 7/5
 * mlevisohn@brandeis.edu
 */
package main;
import java.io.*; 

public class FindMinPath {

	/**
	 * Main method runs pathfinding algorithm
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		MinPriorityQueue q = new MinPriorityQueue(); 
		GraphWrapper gw = new GraphWrapper(true);
		GraphNode home = gw.getHome();
		q.insert(home);
		GraphNode goal = null; 
		HashMap visitedNodes = new HashMap(); //keeps track of which nodes have been visited 
		visitedNodes.set(home, 1);
		while (!q.isEmpty()&&goal==null) { //while goal has not been found and there are still neighbors in the queue
			GraphNode curr = q.pullHighestPriorityElement();
			if (curr.isGoalNode()) {
				goal = curr; 
			}
			else {
				if (curr.hasNorth()) {
					int x = curr.priority+curr.getNorthWeight();
					if (!visitedNodes.hasKey(curr.getNorth())){
						curr.getNorth().priority = x;
						curr.getNorth().previousNode = curr; 
						curr.getNorth().previousDirection = "North";
						q.insert(curr.getNorth());
						visitedNodes.set(curr.getNorth(), 1);
					}
					else if (visitedNodes.hasKey(curr.getNorth())&&curr.getNorth().priority>x) {
						curr.getNorth().priority = x;
						curr.getNorth().previousNode = curr; 
						curr.getNorth().previousDirection = "North";
						q.rebalance(curr.getNorth());
					}
				}
				if (curr.hasEast()) {
					int x = curr.priority+curr.getEastWeight();
					if (!visitedNodes.hasKey(curr.getEast())){
						curr.getEast().priority = x;
						curr.getEast().previousNode = curr; 
						curr.getEast().previousDirection = "East";
						q.insert(curr.getEast());
						visitedNodes.set(curr.getEast(), 1);
					}
					else if (visitedNodes.hasKey(curr.getEast())&&curr.getEast().priority>x) {
						curr.getEast().priority = x;
						curr.getEast().previousNode = curr; 
						curr.getEast().previousDirection = "East";
						q.rebalance(curr.getEast());
					}
				}
				if (curr.hasSouth()) {
					int x = curr.priority+curr.getSouthWeight();
					if (!visitedNodes.hasKey(curr.getSouth())){
						curr.getSouth().priority = x;
						curr.getSouth().previousNode = curr; 
						curr.getSouth().previousDirection = "South";
						q.insert(curr.getSouth());
						visitedNodes.set(curr.getSouth(), 1);
					}
					else if (visitedNodes.hasKey(curr.getSouth())&&curr.getSouth().priority>x) {
						curr.getSouth().priority = x;
						curr.getSouth().previousNode = curr; 
						curr.getSouth().previousDirection = "South";
						q.rebalance(curr.getSouth());
					}
				}
				if (curr.hasWest()) {
					int x = curr.priority+curr.getWestWeight();
					if (!visitedNodes.hasKey(curr.getWest())){
						curr.getWest().priority = x;
						curr.getWest().previousNode = curr; 
						curr.getWest().previousDirection = "West";
						q.insert(curr.getWest());
						visitedNodes.set(curr.getWest(), 1);
					}
					else if (visitedNodes.hasKey(curr.getWest())&&curr.getWest().priority>x) {
						curr.getWest().priority = x;
						curr.getWest().previousNode = curr; 
						curr.getWest().previousDirection = "West";
						q.rebalance(curr.getWest());
					}
	
				}
			}
		}
		if (goal!=null) { //prints directions if there was a path found to the goal node
			String output = "";
			GraphNode v = goal;
			while (v.previousDirection!=null) {
				output = v.previousDirection+"\n"+output; 
				v = v.previousNode;
			}
			System.out.println(output);
			PrintStream file = new PrintStream (new File ("answer.txt"));
			file.println(output);
			file.close();
		}
		else { //if all paths were checked and the goal node was not found 
			System.out.println("There is no path from the start to the goal.");
		}
	}

}
