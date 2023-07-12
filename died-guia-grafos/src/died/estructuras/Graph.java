package died.estructuras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Graph<T extends Comparable<T>> {
	private List<Edge<T>> edges;
	private List<Vertex<T>> vertexs;

	public Graph() {
		this.edges = new ArrayList<Edge<T>>();
		this.vertexs = new ArrayList<Vertex<T>>();
	}

	public Graph<T> addNodo(T nodo) {
		this.addNodo(new Vertex<T>(nodo));
		return this;
	}

	private void addNodo(Vertex<T> nodo) {
		this.vertexs.add(nodo);
	}

	public Graph<T> conectar(T n1, T n2) {
		this.conectar(getNodo(n1), getNodo(n2), 0.0);
		return this;
	}

	public Graph<T> conectar(T n1, T n2, Number valor) {
		this.conectar(getNodo(n1), getNodo(n2), valor);
		return this;
	}

	private void conectar(Vertex<T> nodo1, Vertex<T> nodo2, Number valor) {
		this.edges.add(new Edge<T>(nodo1, nodo2, valor));
	}

	public Vertex<T> getNodo(T valor) {
		return this.vertexs.get(this.vertexs.indexOf(new Vertex<T>(valor)));
	}

	public List<T> getNeighbourhood(T valor) { // Neighbourhood --> adyacente
		Vertex<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for (Edge<T> enlace : this.edges) {
			if (enlace.getOrigin().equals(unNodo)) {
				salida.add(enlace.getEnd().getValue());
			}
		}
		return salida;
	}

	private List<Vertex<T>> getNeighbourhood(Vertex<T> unNodo) { // Neighbourhood --> adyacente
		List<Vertex<T>> salida = new ArrayList<Vertex<T>>();
		for (Edge<T> enlace : this.edges) {
			if (enlace.getOrigin().equals(unNodo)) {
				salida.add(enlace.getEnd());
			}
		}
		return salida;
	}

	public void printEdges() {
		System.out.println(this.edges.toString());
	}

	public Integer gradoEntrada(Vertex<T> vertice) {
		Integer res = 0;
		for (Edge<T> arista : this.edges) {
			if (arista.getEnd().equals(vertice))
				++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertex<T> vertice) {
		Integer res = 0;
		for (Edge<T> arista : this.edges) {
			if (arista.getOrigin().equals(vertice))
				++res;
		}
		return res;
	}

	protected Edge<T> findEdge(T v1, T v2) {
		return this.findEdge(new Vertex<T>(v1), new Vertex<T>(v2));
	}

	private boolean isAdjacent(Vertex<T> v1, Vertex<T> v2) {
		List<Vertex<T>> ady = this.getNeighbourhood(v1);
		for (Vertex<T> unAdy : ady) {
			if (unAdy.equals(v2))
				return true;
		}
		return false;
	}

	protected Edge<T> findEdge(Vertex<T> v1, Vertex<T> v2) {
		for (Edge<T> unaArista : this.edges) {

			if (unaArista.getOrigin().equals(v1) && unaArista.getEnd().equals(v2))
				return unaArista;
		}
		return null;
	}

	public List<T> bfs(Vertex<T> inicio) { // implementa el algoritmo de búsqueda en amplitud en un grafo
		List<T> resultado = new ArrayList<T>();
		// estructuras auxiliares
		Queue<Vertex<T>> pendientes = new LinkedList<Vertex<T>>();
		HashSet<Vertex<T>> marcados = new HashSet<Vertex<T>>();
		marcados.add(inicio);
		pendientes.add(inicio);

		while (!pendientes.isEmpty()) {
			Vertex<T> actual = pendientes.poll();
			List<Vertex<T>> adyacentes = this.getNeighbourhood(actual);
			resultado.add(actual.getValue());
			for (Vertex<T> v : adyacentes) {
				if (!marcados.contains(v)) {
					pendientes.add(v);
					marcados.add(v);
				}
			}
		}
		// System.out.println(resultado);
		return resultado;
	}

	public List<T> dfs(Vertex<T> inicio) { // implementa el algoritmo de búsqueda en profundidad
		List<T> resultado = new ArrayList<T>();
		Stack<Vertex<T>> pendientes = new Stack<Vertex<T>>();
		HashSet<Vertex<T>> marcados = new HashSet<Vertex<T>>();
		marcados.add(inicio);
		pendientes.push(inicio);

		while (!pendientes.isEmpty()) {
			Vertex<T> actual = pendientes.pop();
			List<Vertex<T>> adyacentes = this.getNeighbourhood(actual);
			resultado.add(actual.getValue());
			for (Vertex<T> v : adyacentes) {
				if (!marcados.contains(v)) {
					pendientes.push(v);
					marcados.add(v);
				}
			}
		}
		// System.out.println(resultado);
		return resultado;
	}

	public List<T> topological() {
		List<T> resultado = new ArrayList<T>();
		Map<Vertex<T>, Integer> gradosVertex = new HashMap<Vertex<T>, Integer>();
		for (Vertex<T> vert : this.vertexs) {
			gradosVertex.put(vert, this.gradoEntrada(vert));
		}
		while (!gradosVertex.isEmpty()) {

			List<Vertex<T>> nodosSinEntradas = gradosVertex.entrySet().stream().filter(x -> x.getValue() == 0)
					.map(p -> p.getKey()).collect(Collectors.toList());

			if (nodosSinEntradas.isEmpty())
				System.out.println("TIENE CICLOS");

			for (Vertex<T> v : nodosSinEntradas) {
				resultado.add(v.getValue());
				gradosVertex.remove(v);
				for (Vertex<T> ady : this.getNeighbourhood(v)) {
					gradosVertex.put(ady, gradosVertex.get(ady) - 1);
				}
			}
		}

		System.out.println(resultado);
		return resultado;
	}

	private void findPathAux(Vertex<T> v1, Vertex<T> v2, List<Vertex<T>> marcados, List<List<Vertex<T>>> todos) {
		List<Vertex<T>> adyacentes = this.getNeighbourhood(v1);
		// Vector copiaMarcados;
		List<Vertex<T>> copiaMarcados = null;
		;

		for (Vertex<T> ady : adyacentes) {
			System.out.println(">> " + ady);
			copiaMarcados = marcados.stream().collect(Collectors.toList());
			if (ady.equals(v2)) {
				copiaMarcados.add(v2);
				todos.add(new ArrayList<Vertex<T>>(copiaMarcados));
				System.out.println("Path found " + todos.toString());
			} else {
				if (!copiaMarcados.contains(ady)) {
					copiaMarcados.add(ady);
					this.findPathAux(ady, v2, copiaMarcados, todos);
				}
			}
		}

	}

	public List<List<Vertex<T>>> paths(T v1, T v2) {
		return this.paths(new Vertex(v1), new Vertex(v2));
	}

	public List<List<Vertex<T>>> paths(Vertex<T> v1, Vertex<T> v2) {
		List<List<Vertex<T>>> salida = new ArrayList<List<Vertex<T>>>();
		List<Vertex<T>> marcados = new ArrayList<Vertex<T>>();
		marcados.add(v1);
		findPathAux(v1, v2, marcados, salida);
		return salida;
	}

	public Map<T, Integer> minimumPathDijkstra(T valorOrigen) {
		Vertex<T> vOrigen = new Vertex<T>(valorOrigen);
		Map<Vertex<T>, Integer> caminosResultado = this.minimumPathDijkstra(vOrigen);
		Map<T, Integer> resultado = new LinkedHashMap<T, Integer>();
		for (Entry<Vertex<T>, Integer> unNodo : caminosResultado.entrySet()) {
			resultado.put(unNodo.getKey().getValue(), unNodo.getValue());
		}
		return resultado;
	}

	private Map<Vertex<T>, Integer> minimumPathDijkstra(Vertex<T> origen) {

		// inicializo todas las distancias a INFINITO
		Map<Vertex<T>, Integer> distancias = new HashMap<Vertex<T>, Integer>();
		for (Vertex<T> unVertex : this.vertexs) {
			distancias.put(unVertex, Integer.MAX_VALUE);
		}
		distancias.put(origen, 0);

		// guardo visitados y pendientes de visitar
		Set<Vertex<T>> visitados = new HashSet<Vertex<T>>();
		TreeMap<Integer, Vertex<T>> aVisitar = new TreeMap<Integer, Vertex<T>>();

		aVisitar.put(0, origen);

		while (!aVisitar.isEmpty()) {
			Entry<Integer, Vertex<T>> nodo = aVisitar.pollFirstEntry();
			visitados.add(nodo.getValue());

			int nuevaDistancia = Integer.MIN_VALUE;
			List<Vertex<T>> adyacentes = this.getNeighbourhood(nodo.getValue());

			for (Vertex<T> unAdy : adyacentes) {
				if (!visitados.contains(unAdy)) {
					Edge<T> enlace = this.findEdge(nodo.getValue(), unAdy);
					if (enlace != null) {
						nuevaDistancia = enlace.getValue().intValue();
					}
					int distanciaHastaAdy = distancias.get(nodo.getValue()).intValue();
					int distanciaAnterior = distancias.get(unAdy).intValue();
					if (distanciaHastaAdy + nuevaDistancia < distanciaAnterior) {
						distancias.put(unAdy, distanciaHastaAdy + nuevaDistancia);
						aVisitar.put(distanciaHastaAdy + nuevaDistancia, unAdy);
					}
				}
			}
		}
		System.out.println("DISTANCIAS DESDE " + origen);
		System.out.println("Resultado: " + distancias);
		return distancias;
	}

	public void floydWarshall() {
		int cantVertexs = this.vertexs.size();
		int[][] matrizDistancias = new int[cantVertexs][cantVertexs];

		for (int i = 0; i < cantVertexs; i++) {
			for (int j = 0; j < cantVertexs; j++) {
				if (i == j) {
					matrizDistancias[i][j] = 0;
				} else {
					Edge<T> arista = this.findEdge(this.vertexs.get(i), this.vertexs.get(j));
					if (arista != null) {
						matrizDistancias[i][j] = arista.getValue().intValue();
					} else {
						matrizDistancias[i][j] = 9999;
					}
				}
			}
		}
		printMatrix(matrizDistancias);

		for (int k = 0; k < cantVertexs; k++) {
			// Pick all vertices as source one by one
			for (int i = 0; i < cantVertexs; i++) {
				// Pick all vertices as destination for the
				// above picked source
				for (int j = 0; j < cantVertexs; j++) {
					// If vertex k is on the shortest path from
					// i to j, then update the value of dist[i][j]
					if (matrizDistancias[i][k] + matrizDistancias[k][j] < matrizDistancias[i][j])
						matrizDistancias[i][j] = matrizDistancias[i][k] + matrizDistancias[k][j];
				}
			}
			System.out.println("MATRIZ " + k);
			printMatrix(matrizDistancias);
		}

	}

	public void printMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(i + ":" + j + " = " + m[i][j] + ",   ");
			}
			System.out.println(" ]");
		}

	}

	public Boolean pathExists(Vertex<T> v1, Vertex<T> v2, Integer n) {

		Queue<Vertex<T>> pendientes = new LinkedList<Vertex<T>>();
		HashSet<Vertex<T>> marcados = new HashSet<Vertex<T>>();
		Vertex<T> inicio = v1;
		marcados.add(inicio);
		pendientes.add(inicio);
		int saltos = 0;
		boolean encontrado = false;

		while (!pendientes.isEmpty() && saltos < n && !encontrado) {
			Vertex<T> actual = pendientes.poll();
			if (actual.equals(v2)) {
				encontrado = true;
			} else {
				saltos++;
				List<Vertex<T>> adyacentes = this.getNeighbourhood(actual);
				for (Vertex<T> v : adyacentes) {
					if (!marcados.contains(v)) {
						pendientes.add(v);
						marcados.add(v);
					}
				}
			}
		}

		return encontrado;
	}

	public Boolean pathExistsRecursive(Vertex<T> v1, Vertex<T> v2, Integer n) {
		HashSet<Vertex<T>> marcados = new HashSet<Vertex<T>>();
		marcados.add(v1);
		int saltos = 0;
		return pathExistsRecursive(v1, v2, n, marcados, saltos);
	}

	private Boolean pathExistsRecursive(Vertex<T> v1, Vertex<T> v2, Integer n, HashSet<Vertex<T>> visitados,
			int saltos) {

		if (v1.equals(v2)) {
			return true;
		} else {
			if (saltos >= n) {
				return false;
			} else {
				saltos++;
				List<Vertex<T>> adyacentes = this.getNeighbourhood(v1);
				for (Vertex<T> i : adyacentes) {
					if (!visitados.contains(i)) {
						visitados.add(i);
						if (pathExistsRecursive(i, v2, n, visitados, saltos)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public boolean cleanPathExists(Vertex<T> v1, Vertex<T> v2) {

		Stack<Vertex<T>> pendientes = new Stack<Vertex<T>>();
		HashSet<Vertex<T>> marcados = new HashSet<Vertex<T>>();
		marcados.add(v1);
		boolean encontrado = false;

		List<Vertex<T>> primerosVecinos = this.getNeighbourhood(v1);
		for (Vertex<T> vert : primerosVecinos) {
			pendientes.push(vert);
			marcados.add(vert);
		}

		while (!pendientes.isEmpty() && !encontrado) {
			Vertex<T> actual = pendientes.pop();
			if (actual.equals(v2)) {
				encontrado = true;
			} else {
				List<Vertex<T>> ady = this.getNeighbourhood(actual);
				if (ady.size() == 1) {
					Vertex<T> vecino = ady.get(0);
					if (!marcados.contains(vecino)) {
						pendientes.push(vecino);
						marcados.add(vecino);
					}
				}
			}
		}

		return false;

	}

	public boolean existeCamino(Vertex<T> v1, Vertex<T> v2) {

		boolean existe = false;
		Stack<Vertex<T>> pendientes = new Stack<Vertex<T>>();
		HashSet<Vertex<T>> marcados = new HashSet<Vertex<T>>();
		pendientes.push(v1);
		marcados.add(v1);

		while (!existe && !pendientes.isEmpty()) {
			Vertex<T> actual = pendientes.pop();
			if (!actual.equals(v2)) {
				List<Vertex<T>> adyacentes = this.getNeighbourhood(actual);
				for (Vertex<T> vert : adyacentes) {
					if (!marcados.contains(vert)) {
						pendientes.push(vert);
						marcados.add(vert);
					}
				}
			} else {
				existe = true;
			}
		}

		return existe;

	}

	public boolean esConexo() {

		boolean retorno = true;
		for (Vertex<T> i : vertexs) {
			for (Vertex<T> j : vertexs) {
				if (!existeCamino(i, j)) {
					retorno = false;
				}
			}
		}
		return retorno;

	}

	public boolean esPlano() {

		long gradosEntrada;
		long gradosSalida;

		gradosEntrada = this.vertexs.stream().map(v -> this.gradoEntrada(v)).filter(i -> i == 0).count();
		gradosSalida = this.vertexs.stream().map(v -> this.gradoSalida(v)).filter(i -> i == 0).count();

		if (gradosEntrada == 1 && gradosSalida == 1) {
			return true;
		} else {
			return false;
		}

	}

	public List<Vertex<T>> findPath(Vertex<T> inicio, Vertex<T> fin) {
		List<Vertex<T>> path = new ArrayList<>();
		path.add(inicio);

		// Realizar una búsqueda en profundidad desde el vértice inicial
		boolean encontrado = findPathDFS(inicio, fin, path);

		// Verificar si se encontró un camino válido
		if (encontrado) {
			path.add(fin);
			return path;
		} else {
			return null; // No se encontró ningún camino válido
		}
	}

	private boolean findPathDFS(Vertex<T> actual, Vertex<T> fin, List<Vertex<T>> path) {
		// Verificar si el vértice actual es el vértice final
		if (actual.equals(fin)) {
			return true;
		}

		// Obtener los vértices adyacentes del vértice actual
		List<Vertex<T>> adyacentes = getNeighbourhood(actual);

		// Filtrar los vértices adyacentes que cumplen la condición de tener al menos 2
		// aristas salientes
		List<Vertex<T>> adyacentesValidos = adyacentes.stream().filter(v -> gradoSalida(v) >= 2)
				.collect(Collectors.toList());

		// Realizar la recursión para cada vértice adyacente válido
		for (Vertex<T> ady : adyacentesValidos) {
			// Verificar si el vértice adyacente ya ha sido visitado para evitar ciclos
			if (!path.contains(ady)) {
				path.add(ady);
				boolean encontrado = findPathDFS(ady, fin, path);
				if (encontrado) {
					return true;
				} else {
					path.remove(ady);
				}
			}
		}

		return false; // No se encontró ningún camino válido desde el vértice actual
	}

	public void warshall() {
		int n = vertexs.size();
		int[][] closure = new int[n][n];

		// Inicializar la matriz de cierre transitivo con los valores de la matriz de
		// adyacencia original
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					closure[i][j] = 1; // Hay un camino directo de un vértice a sí mismo
				} else {
					Vertex<T> v1 = vertexs.get(i);
					Vertex<T> v2 = vertexs.get(j);
					Edge<T> edge = findEdge(v1, v2);
					if (edge != null) {
						closure[i][j] = 1; // Hay una arista directa entre los vértices i y j
					} else {
						closure[i][j] = 0; // No hay una arista directa entre los vértices i y j
					}
				}
			}
		}

		// Aplicar el algoritmo de Warshall
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					closure[i][j] = closure[i][j] | (closure[i][k] & closure[k][j]);
				}
			}
		}

		// Imprimir la matriz de cierre transitivo
		System.out.println("Matriz de cierre transitivo:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(closure[i][j] + " ");
			}
			System.out.println();
		}
	}

	public List<Vertex<T>> shortestPathWithoutWeights(Vertex<T> start, Vertex<T> end) { // Camino mínimo sin pesos
		Map<Vertex<T>, Vertex<T>> previous = new HashMap<>();
		Queue<Vertex<T>> queue = new LinkedList<>();
		Set<Vertex<T>> visited = new HashSet<>();

		queue.add(start);
		visited.add(start);

		while (!queue.isEmpty()) {
			Vertex<T> current = queue.poll();

			if (current.equals(end)) {
				break;
			}

			List<Vertex<T>> neighbors = getNeighbourhood(current);

			for (Vertex<T> neighbor : neighbors) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
					previous.put(neighbor, current);
				}
			}
		}

		if (!visited.contains(end)) {
			return new ArrayList<>(); // No se encontró un camino entre los vértices
		}

		List<Vertex<T>> path = new ArrayList<>();
		Vertex<T> current = end;

		while (current != null) {
			path.add(0, current);
			current = previous.get(current);
		}

		return path;
	}

	public Map<Vertex<T>, Integer> shortestPathWithWeights(Vertex<T> origen) { // Camino mínimo con pesos positivos
																				// Dijkstra
		// Inicializar distancias y cola de prioridad
		Map<Vertex<T>, Integer> distancias = new HashMap<>();
		PriorityQueue<Vertex<T>> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

		// Inicializar distancias de todos los vértices como infinito, excepto el origen
		for (Vertex<T> vertex : vertexs) {
			distancias.put(vertex, Integer.MAX_VALUE);
		}
		distancias.put(origen, 0);
		colaPrioridad.add(origen);

		while (!colaPrioridad.isEmpty()) {
			Vertex<T> actual = colaPrioridad.poll();
			List<Vertex<T>> adyacentes = this.getNeighbourhood(actual);

			for (Vertex<T> adyacente : adyacentes) {
				Edge<T> arista = this.findEdge(actual, adyacente);
				int pesoArista = arista.getValue().intValue();
				int distanciaHastaAdyacente = distancias.get(actual) + pesoArista;

				if (distanciaHastaAdyacente < distancias.get(adyacente)) {
					distancias.put(adyacente, distanciaHastaAdyacente);
					colaPrioridad.remove(adyacente); // Remover y volver a agregar para mantener la prioridad
					colaPrioridad.add(adyacente);
				}
			}
		}

		return distancias;
	}

	public Map<Vertex<T>, Integer> minimumPathBellmanFord(Vertex<T> origen) { // Camino mínimo con pesos negativos
		// Inicializar distancias
		Map<Vertex<T>, Integer> distancias = new HashMap<>();
		for (Vertex<T> vertex : vertexs) {
			distancias.put(vertex, Integer.MAX_VALUE);
		}
		distancias.put(origen, 0);

		// Realizar N-1 pasos de relajación de las aristas
		int numVertices = vertexs.size();
		for (int i = 1; i <= numVertices - 1; i++) {
			for (Edge<T> arista : edges) {
				Vertex<T> origenArista = arista.getOrigin();
				Vertex<T> destinoArista = arista.getEnd();
				int pesoArista = arista.getValue().intValue();

				int distanciaHastaOrigen = distancias.get(origenArista);
				int distanciaHastaDestino = distancias.get(destinoArista);

				if (distanciaHastaOrigen != Integer.MAX_VALUE
						&& distanciaHastaOrigen + pesoArista < distanciaHastaDestino) {
					distancias.put(destinoArista, distanciaHastaOrigen + pesoArista);
				}
			}
		}

		// Verificar la existencia de ciclos de peso negativo
		for (Edge<T> arista : edges) {
			Vertex<T> origenArista = arista.getOrigin();
			Vertex<T> destinoArista = arista.getEnd();
			int pesoArista = arista.getValue().intValue();

			int distanciaHastaOrigen = distancias.get(origenArista);
			int distanciaHastaDestino = distancias.get(destinoArista);

			if (distanciaHastaOrigen != Integer.MAX_VALUE
					&& distanciaHastaOrigen + pesoArista < distanciaHastaDestino) {
				System.out.println(
						"El grafo contiene un ciclo de peso negativo. No se puede encontrar un camino mínimo.");
				return null;
			}
		}

		return distancias;
	}

	public int maxFlow(Vertex<T> source, Vertex<T> sink) {
		// Crear una copia del grafo original
		Graph<T> residualGraph = new Graph<>();
		for (Vertex<T> vertex : vertexs) {
			residualGraph.addNodo(vertex.getValue());
		}
		for (Edge<T> edge : edges) {
			residualGraph.conectar(edge.getOrigin().getValue(), edge.getEnd().getValue(), edge.getValue());
		}

		int maxFlow = 0;

		// Buscar un camino aumentante en el grafo residual
		List<Vertex<T>> augmentingPath = findAugmentingPath(residualGraph, source, sink);
		while (augmentingPath != null) {
			// Determinar la capacidad residual mínima a lo largo del camino aumentante
			int minResidualCapacity = determineMinResidualCapacity(residualGraph, augmentingPath);

			// Aumentar el flujo a lo largo del camino aumentante
			increaseFlow(residualGraph, augmentingPath, minResidualCapacity);

			// Actualizar el flujo máximo
			maxFlow += minResidualCapacity;

			// Buscar un nuevo camino aumentante
			augmentingPath = findAugmentingPath(residualGraph, source, sink);
		}

		return maxFlow;
	}

	private List<Vertex<T>> findAugmentingPath(Graph<T> graph, Vertex<T> source, Vertex<T> sink) {
		// Implementa la búsqueda en profundidad (DFS) o la búsqueda en amplitud (BFS)
		// para encontrar un camino aumentante
		// Retorna el camino aumentante como una lista de vértices o null si no se
		// encuentra un camino
		// Implementación básica de BFS:
		Queue<Vertex<T>> queue = new LinkedList<>();
		Map<Vertex<T>, Vertex<T>> parentMap = new HashMap<>();
		Set<Vertex<T>> visited = new HashSet<>();

		queue.offer(source);
		visited.add(source);

		while (!queue.isEmpty()) {
			Vertex<T> current = queue.poll();

			if (current.equals(sink)) {
				// Se encontró un camino aumentante
				List<Vertex<T>> augmentingPath = new ArrayList<>();
				Vertex<T> node = sink;

				while (node != null) {
					augmentingPath.add(0, node);
					node = parentMap.get(node);
				}

				return augmentingPath;
			}

			List<Vertex<T>> neighbors = graph.getNeighbourhood(current);
			for (Vertex<T> neighbor : neighbors) {
				if (!visited.contains(neighbor)) {
					queue.offer(neighbor);
					visited.add(neighbor);
					parentMap.put(neighbor, current);
				}
			}
		}

		// No se encontró un camino aumentante
		return null;
	}

	private int determineMinResidualCapacity(Graph<T> graph, List<Vertex<T>> augmentingPath) {
		// Determina la capacidad residual mínima a lo largo del camino aumentante
		// Retorna la capacidad residual mínima
		int minResidualCapacity = Integer.MAX_VALUE;

		for (int i = 0; i < augmentingPath.size() - 1; i++) {
			Vertex<T> origin = augmentingPath.get(i);
			Vertex<T> end = augmentingPath.get(i + 1);

			Edge<T> edge = graph.findEdge(origin, end);
			if (edge != null) {
				int residualCapacity = edge.getValue().intValue();
				minResidualCapacity = Math.min(minResidualCapacity, residualCapacity);
			}
		}

		return minResidualCapacity;
	}

	private void increaseFlow(Graph<T> graph, List<Vertex<T>> augmentingPath, int minResidualCapacity) {
		// Aumenta el flujo a lo largo del camino aumentante utilizando la capacidad
		// residual mínima
		// Actualiza las capacidades residuales de las aristas en función del flujo
		// aumentado
		for (int i = 0; i < augmentingPath.size() - 1; i++) {
			Vertex<T> origin = augmentingPath.get(i);
			Vertex<T> end = augmentingPath.get(i + 1);

			Edge<T> forwardEdge = graph.findEdge(origin, end);
			Edge<T> backwardEdge = graph.findEdge(end, origin);

			if (forwardEdge != null) {
				forwardEdge.setValue(forwardEdge.getValue().intValue() - minResidualCapacity);
			}

			if (backwardEdge != null) {
				backwardEdge.setValue(backwardEdge.getValue().intValue() + minResidualCapacity);
			}
		}
	}

}
