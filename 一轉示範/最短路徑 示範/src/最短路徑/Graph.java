package ³Ìµu¸ô®|;

public class Graph {
	public static final int UNREACHABLE = 99999;
	private int nVertices;
	private int[][] weights;
	
	public Graph(int nVertices){
		this.nVertices = nVertices;
		this.weights = new int[nVertices][nVertices];
		
		for(int i = 0; i < nVertices; i ++)
			for (int j = 0; j < nVertices; j ++)
			{
				if (i == j)  // the distance between the vertex to itself is zero
					this.weights[i][j] = 0;
				else
					this.weights[i][j] = UNREACHABLE;
			}
	}
	
	public int[][] getWeights() {
		return weights;
	}
	
	public int getVerticesSize(){
		return nVertices;
	}
	
	public void addWeight(int v1, int v2, int weight){
		//undirected map
		this.weights[v1][v2] = this.weights[v2][v1] = weight;
	}
	
	public int getWeight(int v1, int v2){
		return weights[v1][v2];
	}
	
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		for (int i = 0; i < nVertices; i ++)
		{
			for (int j = 0; j < nVertices; j ++)
				strb.append(weights[i][j] + " ");
			strb.append("\n");
		}
		return strb.toString();
	}
	
}
