package Trees.basic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test234Tree {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertRootWith1Element() {
		Tree234 myTree = new Tree234();
		myTree.insert(50);
		myTree.inorderTraversal(myTree.root);
	}

	@Test
	public void testInsertRootWith2Element() {
		Tree234 myTree = new Tree234();
		myTree.insert(50);
		myTree.insert(18);
		myTree.inorderTraversal(myTree.root);
	}
	
	@Test
	public void testInsertRootWith3Element() {
		Tree234 myTree = new Tree234();
		myTree.insert(50);
		myTree.insert(120);
		myTree.insert(110);
		myTree.inorderTraversal(myTree.root);
	}

	@Test
	public void testInsertRootWith4Element() {
		Tree234 myTree = new Tree234();
		myTree.insert(50);
		myTree.insert(120);
		myTree.insert(110);
		myTree.insert(34);
		myTree.inorderTraversal(myTree.root);
	}
	
	@Test
	public void testFind() {
	}

	@Test
	public void testDelete() {
	}

}
