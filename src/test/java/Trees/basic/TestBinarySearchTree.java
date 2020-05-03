package Trees.basic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBinarySearchTree {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind() {
		
		
	}

	@Test
	public void testSingleInsert() {
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(60);
	}

	@Test
	public void testMultiInsert() {
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(60);
		tree.insert(40);
		tree.insert(50);
		tree.insert(80);
	}
	
	@Test
	public void testDeleteHavingBothChild() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(8);
		tree.insert(6);
		tree.insert(10);

		tree.inorderTraversal(tree.root);
		tree.delete(8);
		System.out.println();
		tree.inorderTraversal(tree.root);
		
	}
	
	@Test
	public void testDeleteHavingBothChild1() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(8);
		tree.insert(6);
		tree.insert(20);
		tree.insert(18);
		tree.insert(19);

		tree.inorderTraversal(tree.root);
		tree.delete(8);
		System.out.println();
		tree.inorderTraversal(tree.root);
		
	}

	@Test
	public void testDeleteHavingBothChild2() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(8);
		tree.insert(6);
		tree.insert(20);
		tree.insert(18);

		tree.inorderTraversal(tree.root);
		tree.delete(8);
		System.out.println();
		tree.inorderTraversal(tree.root);
		
	}
	
	@Test
	public void testDeleteHavingBothChild3() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(8);
		tree.insert(6);
		tree.insert(20);
		tree.insert(18);
		tree.insert(30);
		tree.insert(25);
		tree.insert(35);
		tree.insert(28);

		
		tree.inorderTraversal(tree.root);
		tree.delete(20);
		System.out.println();
		tree.inorderTraversal(tree.root);
	}
}
