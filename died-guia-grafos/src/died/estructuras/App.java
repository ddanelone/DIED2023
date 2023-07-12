package died.estructuras;

import java.util.List;

public class App {

	public static void main(String[] args) {
		// Crear el grafo
		Graph<String> grafo = new Graph<>();

		// Agregar vértices al grafo
		grafo.addNodo("A").addNodo("B").addNodo("C").addNodo("D").addNodo("E").addNodo("F").addNodo("G");

		// Conectar los vértices según la descripción del grafo
		grafo.conectar("A", "B").conectar("A", "C");
		grafo.conectar("B", "C").conectar("B", "D");
		grafo.conectar("C", "E");
		grafo.conectar("D", "F").conectar("D", "E");
		grafo.conectar("E", "F").conectar("E", "G");
		grafo.conectar("G", "F");

		// Imprimir las aristas del grafo
		System.out.println("Aristas del grafo:");
		grafo.printEdges();
		System.out.println();

		// Realizar pruebas con los métodos
		Vertex<String> inicio = grafo.getNodo("A");
		Vertex<String> fin = grafo.getNodo("F");
		Vertex<String> otro = grafo.getNodo("G");

		System.out.println("Camino válido de " + inicio.getValue() + " a " + fin.getValue() + ":");
		List<Vertex<String>> camino = grafo.findPath(inicio, fin);
		if (camino != null) {
			for (Vertex<String> v : camino) {
				System.out.print(v.getValue() + " ");
			}
		} else {
			System.out.println("No se encontró ningún camino válido");
		}
		System.out.println();
		grafo.warshall();
		System.out.println("Caminos mínimos sin pesos (desde A a F): " +grafo.shortestPathWithoutWeights(inicio,fin));
		System.out.println("Caminos mínimos con pesos positivos (desde A): " + grafo.shortestPathWithWeights(inicio));
		System.out.println("Caminos mínimos con pesos negativos (desde A): " + grafo.minimumPathBellmanFord(inicio));
		System.out.println("Flujo máximo del grafo: ");
		// System.out.println(grafo.maxFlow(inicio, otro));  //No funciona...
		System.out.println("Aristas del grafo: ");
		grafo.printEdges();
		System.out.println("**** Fin de las pruebas ****");
	}

}
