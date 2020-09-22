package Grafo;

public class Principal {

	public static void main(String[] args) {
		
		Graph grafo = new Graph();
		System.out.println();
		
		//Casos para el metodo addNode
		//Inserciones normales
		grafo.addNode(1);
		grafo.addNode(3);
		grafo.addNode(2);
		grafo.addNode(4);
		//Insercion de un nodo repetido
		grafo.addNode(1);
		//Muestro grafo
		grafo.getNodos();
		grafo.getArcos();
		
		
		//Casos para el metodo addEdge
		//Inserciones normales 
		grafo.addEdge(1,3);
		grafo.addEdge(2,3);
		grafo.addEdge(4,2);
		grafo.addEdge(2,1);
		//Insercion de un arco donde un o ambos nodos no pertenece al grafo
		grafo.addEdge(5,1);
		grafo.addEdge(1,5);
		grafo.addEdge(10,7);
		//Insercion de un arco ya existente
		grafo.addEdge(1,3);
		//Muestro grafo
		grafo.getNodos();
		grafo.getArcos();
	
		
		//Casos para el metodo removeEdge
		//Eliminacion normal
		grafo.removeEdge(4,2);
		//Eliminar arco que no estan presente en el grafo
		grafo.removeEdge(2,4);
		grafo.removeEdge(10,7);
		//Muestro grafo
		grafo.getNodos();
		grafo.getArcos();
	
		//Casos para el metodo removeNode
		//Eliminacion normal
		grafo.removeNode(2);
		//Eliminar nodo inexistente
		grafo.removeNode(10);
		//Muestro grafo
		grafo.getNodos();
		grafo.getArcos();
		
		
	
		
	}

}
