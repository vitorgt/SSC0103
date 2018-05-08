import java.util.HashSet;

public class Vertex {
	
	private String name;
    private HashSet<Edge> edges;
	
	public Vertex(String name){
		this.name = name;
		this.edges = new HashSet<Edge>();
	}
	
	public void addEdge(Vertex destiny, int weight){
		edges.add(new Edge(destiny, weight));
	}
	
	public String getName(){
		return name;
	}

	public HashSet<Edge> getEdges() {
		return edges;
	}
	
	@Override
	public String toString(){
		return getName();
	}
}
