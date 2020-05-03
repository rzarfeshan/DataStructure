package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

	Vertex<T>[] vertex;
	int[][] adjacentVertex;
	int numVertex;
	boolean isGraphDirected;
	List<T> sortedArray;
	
	Graph(int size) {
		vertex = new Vertex[size];
		adjacentVertex = new int[size][size];
		//Arrays.fill(adjacentVertex, 0); // Not required as it default initialized to 0
		numVertex = 0;
		isGraphDirected = false;
	}
	
	Graph(int size, boolean isDirected) {
		this(size);
		this.isGraphDirected = isDirected; 
		sortedArray = new ArrayList<>();
	}
	
	public void addVertex(T element) {
		vertex[numVertex++] = new Vertex<T>(element);
	}
	
	public void addEdge(int start, int end) {
		adjacentVertex[start][end] = 1;
		if (!isGraphDirected) {
			adjacentVertex[end][start] = 1;
		}
	}
	
	public int getAdjacentUnvisitedVertex(Vertex<T> v) {
		int index = indexOf(v);
		for (int i = 0; i < numVertex; i++) {
			if (adjacentVertex[index][i] != 0 && !vertex[i].isVisited) {
				return i;
			}
		}
		return -1;
	}
	
	public void displayVertex(int index) {
		System.out.println(vertex[index].node);
	}
	
	public int indexOf(Vertex<T> v) {
		int i = 0;
		for (; i < numVertex && vertex[i].node != v.node; i++);
		return i;
	}
	
	public void topologicalSorting() {
		int origNumOfVertex = numVertex;
		Vertex currentVertex = vertexHavingNoSuccessor();
		if (currentVertex != null) {
	//		sortedArray.add(currentVertex.node);
		}
		//sortedArray
	}
	
	private Vertex<T> vertexHavingNoSuccessor() {
		for (int i = 0; i < numVertex-1; i++) {
			boolean havingEgde = false;
			int j = 0;
			for (; j < numVertex-1; j++) {
				if (adjacentVertex[i][j] > 0) {
					havingEgde = true;
					break;
				}
			}
			
			if (!havingEgde) {
				return vertex[j];
			}
		}
		return null;
	}
}
