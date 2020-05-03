package Graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDepthFirstSearch {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testdoDFS() {
		Graph<Character> graphObj = new Graph<>(5);
		
		graphObj.addVertex('A');
		graphObj.addVertex('B');
		graphObj.addVertex('C');
		graphObj.addVertex('D');
		graphObj.addVertex('E');
		graphObj.addEdge(0, 1);
		graphObj.addEdge(1, 2);
		graphObj.addEdge(0, 3);
		graphObj.addEdge(3, 4);
		
		DepthFirstSearch<Character> dfsObj = new DepthFirstSearch<Character>(graphObj);
		System.out.print("Visits: ");
		dfsObj.doDFS(); // depth-first search
		System.out.println();
		
	}

	
	/**
	 * ABFHCDGIE
	 */
	@Test
	public void testdoDFS1() {
		Graph<Character> graphObj = new Graph<>(9);
		
		graphObj.addVertex('A');
		graphObj.addVertex('B');
		graphObj.addVertex('C');
		graphObj.addVertex('D');
		graphObj.addVertex('E');
		graphObj.addVertex('F');
		graphObj.addVertex('G');
		graphObj.addVertex('H');
		graphObj.addVertex('I');
		
		
		graphObj.addEdge(0, 1);
		graphObj.addEdge(1, 2);
		graphObj.addEdge(0, 3);
		graphObj.addEdge(3, 4);
		graphObj.addEdge(3, 6);
		graphObj.addEdge(6, 8);
		graphObj.addEdge(5, 7);
		graphObj.addEdge(1, 5);
		
		DepthFirstSearch<Character> dfsObj = new DepthFirstSearch<Character>(graphObj);
		System.out.print("Visits: ");
		dfsObj.doDFS(); // depth-first search
		System.out.println();
		
	}
	
}
