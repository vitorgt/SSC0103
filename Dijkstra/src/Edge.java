
public class Edge {
	
	private int weight;
	private Vertex destiny;
	
	public Edge(Vertex destiny, int weight) {
		this.destiny = destiny;
		this.weight = weight;
	}
	
	public Vertex getDestiny() {
		return destiny;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString(){
		return getDestiny()+" ("+getWeight()+")";
	}

}
