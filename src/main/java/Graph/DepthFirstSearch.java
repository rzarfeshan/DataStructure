package Graph;

import java.util.Stack;



/**
 * Depth-First Search
 * The depth-first search uses a stack to remember where it should go when it reaches a dead end.
 * 
 * RULE:
 *    -  If possible, visit an adjacent unvisited vertex, mark it, and push it on the stack.
 *    -  If you can’t follow Rule 1, then, if possible, pop a vertex off the stack.
 *    -  If you can’t follow Rule 1 or Rule 2, you’re done.
 * @author ezarrab
 *
 * @param <T>
 */
public class DepthFirstSearch<T> {
	Graph<T> myGraphObj;
	Stack<Vertex<T>> myStack;
	
	DepthFirstSearch(Graph<T> graphObj) {
		myGraphObj = graphObj;
		myStack = new Stack<>();
	}

	public void doDFS() {
		myGraphObj.vertex[0].isVisited = true;
		myGraphObj.displayVertex(0);
		
		myStack.push(myGraphObj.vertex[0]);
		
		while (!myStack.isEmpty()) {
			int index = myGraphObj.getAdjacentUnvisitedVertex(myStack.peek());
			
			if (index != -1) {
				myGraphObj.vertex[index].isVisited = true;
				myStack.push(myGraphObj.vertex[index]);
				myGraphObj.displayVertex(index);
			}
			else {
				myStack.pop();
			}
		}
		
	}
}
