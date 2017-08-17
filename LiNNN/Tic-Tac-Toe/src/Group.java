
public enum Group {
	NUMBER('-'),
	CIRCLE('¡³'),
	CROSS('x');

	private char graph;
	
	private Group(char graph) {
		this.graph = graph;
	}
	
	public String getGraph() {
		return String.valueOf(graph);
	}
	
}
