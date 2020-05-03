package Trees.basic;

/**
 * Diameter of Binary Tree
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.
 * 
 * Example:
 * Given a binary tree
 *
 *        1
 *       / \
 *      2   3
 *     / \     
 *    4   5    
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them. 
 * 
 * @author ezarrab
 *
 */


public class DiameterOfBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree myTree = new BinarySearchTree();
		myTree.insert(50);
		myTree.insert(75);
		myTree.insert(25);
		myTree.insert(40);
		//myTree.insert(30);
		myTree.insert(20);
		System.out.println(diameterOfBinaryTree(myTree.root));
		
	}

	public static int diameterOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}
		
		TreeDiameter diamObj = new TreeDiameter();
		int heightOfTree = height(root, diamObj);
		
		//System.out.println(heightOfTree);
		return diamObj.diameter;
    }
	
	public static int height (Node root, TreeDiameter diamObj) {
		if (root == null) {
			return 0;
		}
		
		int leftHeight = height(root.leftChild, diamObj);
		int rightHeight = height(root.rightChild, diamObj);
		
		diamObj.diameter = Math.max(diamObj.diameter, leftHeight+rightHeight);
		return 1+Math.max(leftHeight, rightHeight);
	}
	
	
}

class TreeDiameter {
	int diameter = Integer.MIN_VALUE;
}
