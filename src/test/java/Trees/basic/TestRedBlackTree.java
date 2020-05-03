package Trees.basic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRedBlackTree {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRootNodeInsertion() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		
	}
	
	@Test
	public void test2ChildRedNodeInsertion() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(70);
		myTree.insertNode(25);
	}

	@Test
	public void testThirdChildRedNodeInsertionColorFlip() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(70);
		myTree.insertNode(25);
		myTree.insertNode(12);
	}
	
	@Test
	public void testFourthChildRedNodeInsertionColorFlipAndRotateLeftOutsideGrandParent() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(70);
		myTree.insertNode(25);
		myTree.insertNode(12);
		myTree.insertNode(6);
		myTree.inorderTraversal(myTree.root);
	}
	
	@Test
	public void testFourthChildRedNodeInsertionColorFlipAndRotateRightOutsideGrandParent() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(70);
		myTree.insertNode(25);
		myTree.insertNode(85);
		myTree.insertNode(93);
		myTree.inorderTraversal(myTree.root);
	}
	
	@Test
	public void testFourthChildRedNodeInsertionColorFlipAndRotateRightInsideGrandParent() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(70);
		myTree.insertNode(25);
		myTree.insertNode(85);
		myTree.insertNode(80);
		myTree.inorderTraversal(myTree.root);
	}
	
	@Test
	public void testFourthChildRedNodeInsertionColorFlipAndRotateLeftInsideGrandParent() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(70);
		myTree.insertNode(25);
		myTree.insertNode(12);
		myTree.insertNode(18);
		myTree.inorderTraversal(myTree.root);
	}
	
	/*
	 * Rotation On the Way down.
	 * OUTSIDE GRANDCHILD
	 * 
	 */
	@Test
	public void testFourthChildRedNodeInsertionColorFlipAndRotateLeftOutside() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(75);
		myTree.insertNode(25);
		myTree.insertNode(12);
		myTree.insertNode(37);
		myTree.insertNode(6);
		myTree.insertNode(18);
		myTree.insertNode(3);
		myTree.inorderTraversal(myTree.root);
	}
	
	/*
	 * Rotation On the Way down.
	 * INSIDE GRANDCHILD
	 * 
	 */
	@Test
	public void testFourthChildRedNodeInsertionColorFlipAndRotateLeftInside() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(75);
		myTree.insertNode(25);
		myTree.insertNode(12);
		myTree.insertNode(37);
		myTree.insertNode(31);
		myTree.insertNode(43);
		myTree.insertNode(28);
		myTree.inorderTraversal(myTree.root);
	}
	
	
	/*
	 * RIGHT SIDE
	 * Rotation On the Way down.
	 * OUTSIDE GRANDCHILD
	 * 
	 */
	@Test
	public void testFourthChildRedNodeInsertionColorFlipAndRotateRightOutside() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(75);
		myTree.insertNode(25);
		myTree.insertNode(85);
		myTree.insertNode(70);
		myTree.insertNode(90);
		myTree.insertNode(80);
		myTree.insertNode(99);
		myTree.inorderTraversal(myTree.root);
	}
	
	/*
	 * RIGHT SIDE
	 * Rotation On the Way down.
	 * INSIDE GRANDCHILD
	 * 
	 */
	@Test
	public void testFourthChildRedNodeInsertionColorFlipAndRotateRightInside() {
		RedBlackTree myTree = new RedBlackTree();
		myTree.insertNode(50);
		myTree.insertNode(75);
		myTree.insertNode(25);
		myTree.insertNode(90);
		myTree.insertNode(60);
		myTree.insertNode(65);
		myTree.insertNode(55);
		myTree.insertNode(51);
		myTree.inorderTraversal(myTree.root);
	}
}
