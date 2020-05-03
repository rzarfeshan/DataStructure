package Graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBreadthFirstSearch {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoBFS() {
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
		
		BreadthFirstSearch<Character> dfsObj = new BreadthFirstSearch<Character>(graphObj);
		System.out.print("Visits: ");
		dfsObj.doBFS(); // depth-first search
		System.out.println();
	}
		
	@Test
	public void testDoBFS1() {
		Graph<Character> graphObj = new Graph<>(5);
		
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
		
		BreadthFirstSearch<Character> dfsObj = new BreadthFirstSearch<Character>(graphObj);
		System.out.print("Visits: ");
		dfsObj.doBFS(); // depth-first search
		System.out.println();
	}

}
