package Trees.basic;

class DataItem {
	int item;
	
	public DataItem(int item) {
		this.item = item;
	}
}

class Tree234Node {
	public static final int ORDER = 4;
	
	DataItem[] dataItem;
	Tree234Node[] childReferences;
	int numOfItem = 0;
	
	Tree234Node() {
		dataItem = new DataItem[ORDER-1];
		childReferences = new Tree234Node[ORDER];
	}
	
	Tree234Node(int item) {
		
	}
	
	public int getNumItem() {
		return numOfItem;
	}
	
	public boolean isFull() {
		return numOfItem == ORDER-1?true:false;
	}
	
	public boolean isLeafNode() {
		return childReferences[0] == null ? true : false;
	}
	
	public void insertAndSort(DataItem item) {
		dataItem[getNumItem()]  = item;
		numOfItem++;
		sortNode();
	}
	
	public void sortNode() {
		for (int i = 0; i < getNumItem()-1; i++) {
			if (dataItem[i].item > dataItem[i+1].item) {
				int tmp = dataItem[i].item;
				dataItem[i].item = dataItem[i+1].item;
				dataItem[i+1].item = tmp;
				
				Tree234Node child = childReferences[i];
				childReferences[i] = childReferences[i+1];
				childReferences[i+1] = child;
			}
		}
	}
	
	public Tree234Node getChildNode(int data) {
		int index = 0;
		for (; index < getNumItem()-1; index++) {
			if (data < dataItem[index].item) {
				break;
			}
		}
		return childReferences[index];
		
	}
	
}

public class Tree234 {
	
	Tree234Node root;
	
	public void insert(int element) {
		Tree234Node current = root; 
		Tree234Node parent = null;
		DataItem item = new DataItem(element);
	//	int childReference = 0;
		int i = 0;
		if (root == null) {
			current = new Tree234Node();
			current.dataItem[0] = item;
			current.numOfItem++;
			root = current;
		}
		else {
			while (true) {
				if (!current.isFull()) {
					if (!current.isLeafNode()) {
						parent = current;
						current = current.getChildNode(element);
					}
				} else {
					split(current, parent);
					parent = current;
					current = current.getChildNode(element);
				}
				current.insertAndSort(item);
				return;
			}
			
		}
	}

	private void split(Tree234Node current, Tree234Node parent) {
		Tree234Node leftNode = new Tree234Node();
		Tree234Node rightNode = new Tree234Node();
		if (parent == null) {
			current.childReferences[0] = leftNode;
			current.childReferences[1] = rightNode;
			current.numOfItem = 1;

			leftNode.dataItem[0] = current.dataItem[0];
			leftNode.numOfItem = 1;

			current.dataItem[0] = current.dataItem[1];
			current.dataItem[1] = null;

			rightNode.dataItem[0] = current.dataItem[2];
			rightNode.numOfItem = 1;

			current.dataItem[2] = null;
		}
		else {
			//int item = current.dataItem[1].item;
			parent.insertAndSort(current.dataItem[1]);
			for (int i = parent.getNumItem()-1; i>=0;i++) {
				parent.childReferences[i+1] = parent.childReferences[i];
			}
			
			//parent.childReferences[0] = current;
			parent.childReferences[0] = leftNode;
			leftNode.dataItem[0] = current.dataItem[0];
			leftNode.numOfItem = 1;
			
			parent.childReferences[1] = rightNode;
			current.dataItem[1] = null;
			rightNode.numOfItem = 1;
			
			
			//leftNode.dataItem[0] = current.dataItem[0];
			//leftNode.numOfItem = 1;

			//current.dataItem[0] = current.dataItem[1];
			//current.dataItem[1] = null;

			//rightNode.dataItem[0] = current.dataItem[2];
			//rightNode.numOfItem = 1;

			//current.dataItem[2] = null;
		}
	}
	

	

	public Tree234Node find(int element) {
		return new Tree234Node();
	}
	
	public boolean delete() {
		return false;
	}
	
	public void inorderTraversal(Tree234Node node) {
		if (node != null) {
		//	inorderTraversal(node.leftChild);
		//	System.out.print(node.data + "[" + (node.isRed ? "Red" : "Black") + "]");
			for (DataItem i:node.dataItem)
				System.out.print(i);
			System.out.print("-");
		//	inorderTraversal(node.rightChild);
		}
	}

}
