package Graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGraph {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Graph<Character> graphObj = new Graph<>(3);
		int[][] expectedAdjacent = {{0,0,0},{0,0,0},{0,0,0}};
		Assert.assertArrayEquals(expectedAdjacent, graphObj.adjacentVertex);
		Assert.assertEquals(0, graphObj.numVertex);
		Assert.assertEquals(3, graphObj.vertex.length);
	}

	@Test
	public void testAddVertex() {
		Graph<Character> graphObj = new Graph<>(3);
		
		graphObj.addVertex('A');
		graphObj.addVertex('B');
		graphObj.addVertex('C');
		graphObj.addEdge(0, 1);
		graphObj.addEdge(1, 2);
		int[][] expectedAdjacent = {{0,1,0},{1,0,1},{0,1,0}};
		Assert.assertArrayEquals(expectedAdjacent, graphObj.adjacentVertex);
		Assert.assertEquals(3, graphObj.numVertex);
		Assert.assertEquals(3, graphObj.vertex.length);
	}
}
