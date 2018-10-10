package ³Ìµu¸ô®|;

import java.util.Collections;
import java.util.List;

public class FloydAlgorithm implements ShortestPathAlgorithm{

	@Override
	public Output getShortestPath(Graph graph, int v1, int v2) {
		int size = graph.getVerticesSize();
		int[][] weightsTable = graph.getWeights();
		int[][] D = new int[size][size];
		
		for (int i = 0; i < size; i ++)
			for (int j = 0; j < size; j ++)
				D[i][j] = weightsTable[i][j];

		for (int k = 0; k < size; k ++)
			for (int i = 0; i < size; i ++)
				for (int j = 0; j < size; j ++)
					if (D[i][k] + D[k][j] < D[i][j])
						D[i][j] = D[i][k] + D[k][j];
		
		return new Output(null, D[v1][v2]){
			@Override
			public List<Integer> getPath() {
				throw new RuntimeException("Floyd's Shortest Path Algorithm does not support backtracing path's vertices.");
			}
		};
	}

	@Override
	public Graph getShortestPathGraph(Graph graph) {
		//TODO
		return null;
	}

}
