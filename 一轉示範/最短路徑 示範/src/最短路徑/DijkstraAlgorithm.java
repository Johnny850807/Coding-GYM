package ³Ìµu¸ô®|;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DijkstraAlgorithm implements ShortestPathAlgorithm{
	
	@Override
	public Output getShortestPath(Graph graph, int v1, int v2) {
		int size = graph.getVerticesSize();
		int[][] weightsTable = graph.getWeights();
		
		/**
		 * RemainingIds contains a set of the vertex's id which has not been computed the shortest path from v1.
		 * So we remove v1 instantly at the beginning.
		 */
		Set<Integer> remainingIds = new HashSet<>();
		for (int id = 0; id < size; id ++)
			if (id != v1)
				remainingIds.add(id);
		
		/**
		 * Each node in curWeights composed the weight of a vertex, call it 'a', and the another field 'id'
		 * is of another vertex 'b', which forms the shortest path to 'a'. 
		 * So that when the algorithms is done, we can backtrack the vertices on the path from the 'id' field.
		 */
		Node[] curWeights = new Node[size];
		for (int id = 0; id < size; id ++)
			curWeights[id] = new Node(v1,  weightsTable[v1][id]);
		
		Node curMin = null;
		while(!remainingIds.isEmpty())
		{
			curMin = getNextMinNode(remainingIds, curWeights);
			remainingIds.remove(curMin.id);
			for (int id : remainingIds)
			{
				int passingWeight = curWeights[curMin.id].weight + weightsTable[curMin.id][id];
				if (passingWeight < curWeights[id].weight)
				{
					curWeights[id].weight = passingWeight;
					curWeights[id].id = curMin.id;  //update to the trace to that vertex
				}
			}
		}
		
		return computeOutputFromWeights(v1, v2, curWeights);
	}
	
	private Node getNextMinNode(Set<Integer> remainingIds, Node[] traces){
		Node minNode = new Node(-1, 9999);
		for (int id : remainingIds)
		{
			if (traces[id].weight < minNode.weight)
				minNode.set(id, traces[id].weight);
		}
		return minNode;
	}
	
	private Output computeOutputFromWeights(int v1, int v2, Node[] weights){
		int backtracedId = v2;
		LinkedList<Integer> path = new LinkedList<>();
		while(backtracedId != v1)
		{
			path.addFirst(backtracedId);
			backtracedId = weights[backtracedId].id;
		}
		path.addFirst(v1);
		return new Output(path, weights[v2].weight);
	}
	
	private static class Node{
		int id;
		int weight;
		public Node(int id, int weight) {
			this.id = id;
			this.weight = weight;
		}
		
		public void set(int id, int weight){
			this.id = id;
			this.weight = weight;
		}
	}

	@Override
	public Graph getShortestPathGraph(Graph graph) {
		return null;
	}

}
