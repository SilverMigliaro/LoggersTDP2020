package Grafo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph{
	
	private Map<Integer,Integer> nodes;
	private Map<String,Edge> edges;
	private static Logger logger;


	private static class Edge {

		private int nodo1,nodo2;

		public Edge(int nodo1,int nodo2){

			this.nodo1 = nodo1;
			this.nodo2 = nodo2;
		}

		public int getNode1(){return nodo1;}

		public int getNode2(){return nodo2;}

	}

	public Graph(){

		this.nodes = new HashMap<Integer,Integer>();
		this.edges = new HashMap<String,Edge>();

		if( logger == null){

			logger = logger.getLogger(Graph.class.getName());

			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
 
			logger.setLevel(Level.WARNING);

			Logger rootLogger = logger.getParent();
			for(Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
	}

	public void addEdge(int node1,int node2){

		boolean esta_n1 = this.nodes.containsKey(node1);
		boolean esta_n2 = this.nodes.containsKey(node2);
		boolean esta_arco = this.edges.containsKey(node1+","+node2);
		
		if(!esta_arco) {
			
			if(esta_n1 && esta_n2) {

				this.edges.put(node1+","+node2,new Edge(node1,node2));
				logger.info("El arco ("+node1+","+node2+") se inserto correctamente en el grafo.");
			}
			else {
				
				logger.warning("No se puede crear arco ("+node1+","+node2+"), uno o ambos nodos no estan presente en el grafo.");
				
				if(!esta_n1) {
					logger.info("El nodo "+node1+" no esta en el grafo.");
				}
				if(!esta_n2) {
					logger.info("El nodo "+node2+" no esta en el grafo.");
				}		
			}				
		}	
		else {
			
			logger.warning("El arco ("+node1+","+node2+") esta en el grafo.");	
		}
	}

	public void addNode(int node){

		boolean esta_nodo = this.nodes.containsKey(node);
		
		if(!esta_nodo) {
		
			this.nodes.put(node,node);
			logger.info("El nodo "+node+" se inserto correctamente en el grafo.");
		}
		else {
			
			logger.warning("El nodo "+node+" ya esta en el grafo.");
		}
	}

	public void removeEdge(int node1,int node2){

		boolean esta_arco = this.edges.containsKey(node1+","+node2);
		
		if(esta_arco) {
				
			this.edges.remove(node1+","+node2);
			logger.info("Se elimino correctamente el arco ("+node1+","+node2+").");

		}
		else {
			
			logger.warning("El arco ("+node1+","+node2+") no pertenece al grafo.");
		}
	}

	public void removeNode(int node){

		boolean esta_nodo = this.nodes.containsKey(node);
		
		if(esta_nodo) {
			
			this.nodes.remove(node);
			logger.info("Se elimino corectamente el nodo "+node+".");
			Iterator<Edge> it = this.edges.values().iterator();
			
			while(it.hasNext()) {
				
				Edge edge = it.next();
				
				if(edge.getNode1() == node) {

					it.remove();
					logger.info("Se elimino arco ("+edge.getNode1()+","+edge.getNode2()+").");
				}
				
				if(edge.getNode2() == node) {
					
					it.remove();
					logger.info("Se elimino arco ("+edge.getNode1()+","+edge.getNode2()+").");
				}
			}
		}
		else{
			logger.warning("El nodo "+node+" no esta presente en el grafo.");
		}
	}
	
	public void getNodos(){
		for (Map.Entry<Integer, Integer> entry : this.nodes.entrySet()) {
			
			System.out.println(entry.getValue());
		}
	}

	public void getArcos(){
		for (Map.Entry<String, Edge> entry : this.edges.entrySet()) {
			
			System.out.println(entry.getKey());
		}
	}
}