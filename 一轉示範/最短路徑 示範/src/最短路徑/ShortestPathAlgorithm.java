package ³Ìµu¸ô®|;

import java.util.List;

public interface ShortestPathAlgorithm {
	/**
	 * @param graph The computed graph.
	 * @param v1 The origin, or namely a start point.
	 * @param v2 The end of the shortest path.
	 * @return output composed of the shortest path and the sum weights.
	 */
	Output getShortestPath(Graph graph, int v1, int v2);
	Graph getShortestPathGraph(Graph graph);
	
	public class Output{
		private List<Integer> path;
		private int sumWeights;
		public Output(List<Integer> path, int sumWeights) {
			this.path = path;
			this.sumWeights = sumWeights;
		}

		public List<Integer> getPath() {
			return path;
		}
		public void setPath(List<Integer> path) {
			this.path = path;
		}
		public int getSumWeights() {
			return sumWeights;
		}
		public void setSumWeights(int sumWeights) {
			this.sumWeights = sumWeights;
		}
	}
}
