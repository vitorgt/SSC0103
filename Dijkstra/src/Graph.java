import java.util.HashSet;

public class Graph {
	
    private HashSet<Vertex> vertexes;
    
    public Graph(){
    	vertexes = new HashSet<Vertex>();
    }
    
    public void addVertex(Vertex v){
    	vertexes.add(v);
    }

	public HashSet<Vertex> getVertexes() {
		return vertexes;
	}

	public void setVertexes(HashSet<Vertex> vertexes) {
		this.vertexes = vertexes;
	}
    
}
