package Trees.basic;

/*
 * Red-Black Rules must be follow for insertion and deletion:
 * 		1. Every node is either red or black.
 * 		2. The root is always black.
 * 		3. If a node is red, its children must be black.
 * 		4. Every path from root to a leaf, or to a null child must contain the same number of black nodes.
 * 
 * Rule violation can be fixed by:
 *    - flipping the color of the node
 *    - Or by rotation.
 * 
 */

class RedBlackNode {

	int data;
	RedBlackNode leftChild;
	RedBlackNode rightChild;
	boolean isRed;
	boolean isDeleted;

	public RedBlackNode(int data) {
		isRed = true;
		isDeleted = false;
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
}

public class RedBlackTree {
	RedBlackNode root;

	public void insertNode(int data) {
		RedBlackNode newNode = new RedBlackNode(data);
		RedBlackNode current = root;
		RedBlackNode parent = null;
		RedBlackNode grandParent = null;
		RedBlackNode gGrandParent = null;

		if (root == null) {
			newNode.isRed = false;
			root = newNode;
			return;
		}

		while (true) {
			if (data < current.data) {
				if (current.leftChild == null) {
					current.leftChild = newNode;
					gGrandParent = grandParent;
					grandParent = parent;
					parent = current;
					current = current.leftChild;
					rotate(current, parent, grandParent, gGrandParent);
					return;
				} else {
					flipColor(current, parent, grandParent, gGrandParent);
					gGrandParent = grandParent;
					grandParent = parent;
					parent = current;
					current = current.leftChild;

				}
			} else {
				if (current.rightChild == null) {
					current.rightChild = newNode;
					gGrandParent = grandParent;
					grandParent = parent;
					parent = current;
					current = current.rightChild;
					rotate(current, parent, grandParent, gGrandParent);
					return;
				} else {
					flipColor(current, parent, grandParent, gGrandParent);
					gGrandParent = grandParent;
					grandParent = parent;
					parent = current;
					current = current.rightChild;

				}
			}
		}

	}

	/*
	 * Color flips on the way down
	 * 
	 * 1. Every time the insertion routine encounters a BLACK NODE that has TWO RED
	 * CHILDREN, it must change the children to black and the parent to red (unless
	 * the parent is the root, which always remains black).
	 * 
	 */
	private void flipColor(RedBlackNode current, RedBlackNode parent, RedBlackNode grandParent, RedBlackNode gGrandParent) {
		if (current.leftChild != null && current.rightChild != null) {
			if (current.isRed == false && current.leftChild.isRed == true && current.rightChild.isRed == true) {
				current.leftChild.isRed = false;
				current.rightChild.isRed = false;
				if (current != root) {
					current.isRed = true;
					// rotate
					rotate(current, parent, grandParent, gGrandParent);
				}
			}
		}
	}

	/*
	 * Node X is an outside grandchild if it’s on the same side of its parent P that
	 * P is of its parent G. - X is an outside grandchild if either it’s a left
	 * child of P and P is a left child of G, or it’s a right child of P and P is a
	 * right child of G
	 * 
	 * 				G								 G 
	 * 				 \ 								/ 
	 * 				  \ 						   / 
	 * 				   P 						  P 
	 * 					\ 					     / 
	 * 					 \ 						/ 
	 * 					  X 				   X
	 * 
	 * - X is an Inside grand child if either X is a left child of P and P is a right
	 * child of G, or X is a right child of P and P is a left child of G
	 * 
	 * 					G 						G 
	 * 					 \ 						/ 	
	 * 					  \ 				   / 
	 * 					   P 				   P 
	 * 					  / 				   \ 
	 * 					 / 						\ 
	 * 					X 						 X
	 * 
	 */
	void rotate(RedBlackNode current, RedBlackNode parent, RedBlackNode grandParent, RedBlackNode gGrandParent) {
		if (parent != null && grandParent != null) {
			if (parent.isRed) {
				// Step 1: Switch the color of X’s grandparent G
				// It is true if X is INSIDE GrandParent OR
				//               X is outside grandParent G
				if (grandParent.isRed) {
					grandParent.isRed = false;
				} else {
					grandParent.isRed = true;
				}

				// Case 1: P is red and X is an outside grand child of G.
				if ((grandParent.leftChild == parent && parent.leftChild == current) || 
					(grandParent.rightChild == parent && parent.rightChild == current)) {

					// Step 2: Switch the color of X’s parent, no check on color needed.
					// since we are here because parent is red.
					parent.isRed = false;

					// Rotate with X’s grandparent G at the top, in the direction that raises X
					rotateOnGrandParentG(current, parent, grandParent, gGrandParent);
				}
				// Case 2: P is red and X is an INSIDE grand child of G.
				else {
					// Switch the color of X, we know, new node would always be REd,
					// so make it black
					current.isRed = false;

					// Rotate with X’s parent P at the top in the direction that raises X
					if (grandParent.leftChild == parent) {
						parent.rightChild = current.leftChild;
						grandParent.leftChild = current;
						current.leftChild = parent;
					} else {
						parent.leftChild = current.rightChild;
						grandParent.rightChild = current;
						current.rightChild = parent;
					}
					// Rotate again with X’s grandparent at the top, in the direction that raises X
					rotateOnGrandParentG(null, current, grandParent, gGrandParent);
				}
			}
		}
	}

	/**
	 * Rotate with X’s grandparent G at the top, in the direction that raises X
	 * 
	 */
	private void rotateOnGrandParentG(RedBlackNode current, RedBlackNode parent, RedBlackNode grandParent, RedBlackNode gGrandParent) {
		if (gGrandParent != null) {
			if (gGrandParent.leftChild == grandParent) {
				gGrandParent.leftChild = parent;
				parent.rightChild = grandParent;
			} else {
				gGrandParent.rightChild = parent;
				parent.leftChild = grandParent;
			}
			grandParent.leftChild = null;
			grandParent.rightChild = null;
		}
		else { // root check
			// Outside grand child on the way down - left side.
			if (grandParent.leftChild == parent) {
				grandParent.leftChild = parent.rightChild;
				parent.rightChild = grandParent;
				//grandParent.rightChild = parent.rightChild;
				root = parent;
			}
			// Outside grand child on the way down - right side.
			else if (grandParent.rightChild == parent) { 
				grandParent.rightChild = parent.leftChild;
				parent.leftChild = grandParent;
				root = parent;
			}
			flipColor(parent, null, null, null);
		}
	}

	public void inorderTraversal(RedBlackNode node) {
		if (node != null) {
			inorderTraversal(node.leftChild);
			System.out.print(node.data + "[" + (node.isRed ? "Red" : "Black") + "]");
			System.out.print("-");
			inorderTraversal(node.rightChild);
		}
	}
}
