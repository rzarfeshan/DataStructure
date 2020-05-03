package Graph;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Breadth-First Search
 * In the breadth-first search, the algorithm likes to stay as close as possible to the starting point.
 * It visits all the vertices adjacent to the starting vertex, and only then goes further afield. 
 * This kind of search is implemented using a queue.
 * 
 * RULE:
 * 	- 	Visit the next unvisited vertex (if there is one) that’s adjacent to the current vertex, mark it, 
 *      and insert it into the queue.
 *  - 	If you can’t carry out Rule 1 because there are no more unvisited vertices, remove a vertex from 
 *  	the queue (if possible) and make it the current vertex.
 *  -	If you can’t carry out Rule 2 because the queue is empty, you’re done.
 * 
 * @author ezarrab
 *
 * @param <T>
 */
public class BreadthFirstSearch<T> {
	Graph<T> myGraphObj;
	Queue<Vertex<T>> myQueue;
	
	BreadthFirstSearch(Graph<T> graphObj) {
		myGraphObj = graphObj;
		myQueue = new ConcurrentLinkedQueue<>();
	}

	public void doBFS() {
		myGraphObj.vertex[0].isVisited = true;
		myGraphObj.displayVertex(0);
		
		myQueue.offer(myGraphObj.vertex[0]);
		
		while (!myQueue.isEmpty()) {
			int index = myGraphObj.getAdjacentUnvisitedVertex(myQueue.peek());
			
			if (index != -1) {
				myGraphObj.vertex[index].isVisited = true;
				myQueue.offer(myGraphObj.vertex[index]);
				myGraphObj.displayVertex(index);
			}
			else {
				myQueue.remove();
			}
		}
		
	}
	
	
}
