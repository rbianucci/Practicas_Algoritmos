package Ejercicios_Varios;

import java.util.*;

class Graph {
	private Map<Integer, Nodo> nodos;
	private List<Arista> aristas;

	// Constructor
	public Graph() {
		this.nodos = new HashMap<>();
		this.aristas = new ArrayList<>();
	}

	// Clase interna para representar un nodo
	static class Nodo {
		int id;

		Nodo(int id) {
			this.id = id;
		}
	}

	// Clase interna para representar una arista
	static class Arista {
		Nodo origen, destino;
		int costo;

		Arista(Nodo origen, Nodo destino, int costo) {
			this.origen = origen;
			this.destino = destino;
			this.costo = costo;
		}
	}

	// Método para insertar un nodo en el grafo
	public void insertarNodo(int id) {
		Nodo nuevoNodo = new Nodo(id);
		nodos.put(id, nuevoNodo);
	}

	// Método para insertar una arista en el grafo
	public void insertarArista(int idOrigen, int idDestino, int costo) {
		Nodo nodoOrigen = nodos.get(idOrigen);
		Nodo nodoDestino = nodos.get(idDestino);

		if (nodoOrigen != null && nodoDestino != null) {
			Arista nuevaArista = new Arista(nodoOrigen, nodoDestino, costo);
			aristas.add(nuevaArista);
		} else {
			System.out.println("Error: Uno o ambos nodos no existen.");
		}
	}

	// Método para calcular el costo de ir de un nodo a otro
	public int calcularCosto(int idOrigen, int idDestino) {
		Nodo nodoOrigen = nodos.get(idOrigen);
		Nodo nodoDestino = nodos.get(idDestino);

		if (nodoOrigen != null && nodoDestino != null) {
			for (Arista arista : aristas) {
				if (arista.origen == nodoOrigen && arista.destino == nodoDestino) {
					return arista.costo;
				}
			}
		} else {
			System.out.println("Error: Uno o ambos nodos no existen.");
		}
		return -1; // Retorna -1 en caso de error
	}

	public void cambiarArista(int idOrigen, int idDestino, int nuevoCosto){

		Nodo nodoOrigen = nodos.get(idOrigen);
		Nodo nodoDestino = nodos.get(idDestino);

		if (nodoOrigen != null && nodoDestino != null) {
			for (Arista arista : aristas) {
				if (arista.origen == nodoOrigen && arista.destino == nodoDestino) {
					arista.costo = nuevoCosto;
				}
			}
		} else {
			System.out.println("Error: Uno o ambos nodos no existen.");
		}
	}

	// Método para obtener un nodo por su identificador
	public Nodo obtenerNodoPorId(int id) {
		return nodos.get(id);
	}
	public Map<Integer, Nodo> obtenerNodos(){
		return nodos;
	}

	public List<Arista> obtenerAristas(){
		return this.aristas;
	}
	public boolean existeArista(int idOrigen, int idDestino){
		return calcularCosto(idOrigen,idDestino) != -1;
	}

}
