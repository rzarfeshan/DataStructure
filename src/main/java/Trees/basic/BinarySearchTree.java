package Trees.basic;

class Node {
	int data;
	Node leftChild;
	Node rightChild;

	public void display() {
		// TODO Auto-generated method stub

	}
}

public class BinarySearchTree {
	Node root;

	public Node find(int key) {
		Node current = root;

		if (current == null) {
			return null;
		}

		while (current.data != key) {
			if (current.data < key) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}

			if (current == null) {
				return null;
			}
		}
		return current;
	}

	public void insert(int element) {
		Node current = null;
		Node newNode = new Node();
		newNode.data = element;

		if (root == null) {
			root = newNode;
			return;
		}
		current = root;
		while (true) {
			if (element < current.data) {
				if (current.leftChild == null) {
					current.leftChild = newNode;
					return;
				} else {
					current = current.leftChild;
				}
			} else {
				if (current.rightChild == null) {
					current.rightChild = newNode;
					return;
				} else {
					current = current.rightChild;
				}
			}
		}
	}

	public void delete(int key) {
		Node current = root;
		Node parent = null;
		boolean isLeftChild = false;

		if (current == null) {
			return;
		}

		while (key != current.data) {
			parent = current;
			if (key < current.data) {
				current = current.leftChild;
				isLeftChild = true;
			} else {
				current = current.rightChild;
				isLeftChild = false;
			}
		}

		if (current.leftChild == null && current.rightChild == null) {
			if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (current.leftChild != null && current.rightChild != null) {
			deleteHavingBothChild(current, parent, isLeftChild);
		} else {
			deleteHavingSingleChild(current, parent, isLeftChild);
		}

	}

	/*
	 * This function deletes current node which is having a single child node. It
	 * disconnects current node from the tree and connects the current's child node
	 * to the parent node.
	 * 
	 * @param current - node to be deleted
	 * @param parent - parent of the current node which is to be deleted
	 * @param isLeftChild - denoting if current is the leftChild of the parent or
	 * not.
	 */
	public void deleteHavingSingleChild(Node current, Node parent, boolean isLeftChild) {
		if (current.leftChild != null) {
			if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		} else {
			if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		}
	}

	private void deleteHavingBothChild(Node current, Node parent, boolean isLeftChild) {
		Node successor = getSuccessor(current);

		if (current == root) {
			root = successor;
		} else if (!isLeftChild) {
			parent.rightChild = successor;
		} else {
			parent.leftChild = successor;

		}
		successor.leftChild = current.leftChild;
	}

	private Node getSuccessor(Node current) {
		Node successorParent = current;
		Node successor = current.rightChild;

		while (successor.leftChild != null) {
			successorParent = successor;
			successor = successor.leftChild;
		}

		if (successor != current.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = current.rightChild;
		}
		return successor;
	}

	public void inorderTraversal(Node node) {
		if (node != null) {
			inorderTraversal(node.leftChild);
			System.out.print(node.data);
			System.out.print("-");
			inorderTraversal(node.rightChild);
		}
	}

	public void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.data);
			System.out.print("-");
			preOrderTraversal(node.leftChild);
			preOrderTraversal(node.rightChild);
		}
	}
	
	public void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.leftChild);
			postOrderTraversal(node.rightChild);
			System.out.print(node.data);
			System.out.print("-");
		}
	}
}


