package Grafo;

public class Principal {

	public static void main(String[] args) {
		
		Graph grafo = new Graph();
		System.out.println();
		
		grafo.addNode(1);
		grafo.addNode(3);
		grafo.addNode(2);
		grafo.addNode(4);
		grafo.addNode(1);
		
		//grafo.getNodos();
	
		grafo.addEdge(1,3);
		grafo.addEdge(2,3);
		grafo.addEdge(4,2);
		grafo.addEdge(5,1);
		grafo.addEdge(1,3);
		
		//grafo.getArcos();
	
		grafo.addEdge(2,1);
		grafo.removeEdge(2,4);
		grafo.removeEdge(4,2);
		
		//grafo.getArcos();
		
		grafo.removeNode(2);
		
		grafo.getNodos();
		grafo.getArcos();
		
	}

}
