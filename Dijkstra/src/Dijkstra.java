import java.util.HashMap;
import java.util.LinkedList;

public class Dijkstra {
	
	public Dijkstra(){

		Graph graph = new Graph();
		
	    Vertex a = new Vertex("a");
	    Vertex b = new Vertex("b");
	    Vertex c = new Vertex("c");
	    Vertex d = new Vertex("d");

		a.addEdge(b, 20);// a --20--> b
		b.addEdge(c, 30);// b --30--> c
		b.addEdge(d, 10);// b --10--> d
		b.addEdge(a, 90);// b --10--> a
		c.addEdge(d, 40);// c --40--> d

		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		

		dijkstra(graph, a, d);
	}
	
	@SuppressWarnings("null")
	public void dijkstra(Graph graph, Vertex o, Vertex t){//receives origin and target
		
		HashMap<Vertex, Integer> c = new HashMap<Vertex, Integer>();//colors
		HashMap<Vertex, Vertex> p = new HashMap<Vertex, Vertex>();//parents
		HashMap<Vertex, Integer> d = new HashMap<Vertex, Integer>();//distance
		LinkedList<Vertex> dijk = new LinkedList<Vertex>();
		
		dijk.add(o);
		c.put(o, 1);
		d.put(o, 0);
		
		while(!dijk.isEmpty()){
			for(Edge e : dijk.peek().getEdges()){
					if(c.get(e.getDestiny()) == null){
						p.put(e.getDestiny(), dijk.peek());//coloca como pai o primeiro da fila
						c.put(e.getDestiny(), 1);//marca como visitado
						d.put(e.getDestiny(), d.get(p.get(e.getDestiny()))+e.getWeight());//distancia = d(pai)+peso da sua aresta
						dijk.add(e.getDestiny());
					}
					else{
						if(d.get(e.getDestiny()) > d.get(p.get(dijk.peek()))+e.getWeight()){
							p.put(e.getDestiny(), dijk.peek());
							d.put(e.getDestiny(), d.get(p.get(e.getDestiny()))+e.getWeight());
						}
					}
			}
			c.put(dijk.peek(), 2);
			dijk.remove();
		}
		
		if(d.containsKey(t) == true){
			Vertex veri = t;
			LinkedList<Vertex> path = null;
			while(p.get(veri) != null){
				path.add(p.get(veri));
				veri = p.get(veri);
			}
			while(!path.isEmpty()){
				System.out.println(path.remove());
			}
		}
		
		
	}

}
