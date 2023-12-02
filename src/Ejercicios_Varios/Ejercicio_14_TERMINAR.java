package Ejercicios_Varios;

import java.util.*;
public class Ejercicio_14_TERMINAR {

    // Método para encontrar la ruta con menor probabilidad de errores usando Dijkstra
    public double encontrarRutaMenorProbabilidad(Graph grafo, int inicio, int destino) {
        PriorityQueue<Graph.Nodo> colaPrioridad = new PriorityQueue<>();
        Map<Integer, Double> probabilidadMenorRuta = new HashMap<>();

        for (Graph.Nodo nodo : grafo.obtenerNodos().values()) {
            probabilidadMenorRuta.put(nodo.id, Double.POSITIVE_INFINITY);
        }

        probabilidadMenorRuta.put(inicio, 1.0);  // Probabilidad inicial
        colaPrioridad.add(grafo.obtenerNodos().get(inicio));

        while (!colaPrioridad.isEmpty()) {
            Graph.Nodo actual = colaPrioridad.poll();

            for (Graph.Arista arista : grafo.obtenerAristas()) {
                if (arista.origen == actual) {
                    double nuevaProbabilidad = probabilidadMenorRuta.get(actual.id) * (1 - arista.costo);

                    if (nuevaProbabilidad < probabilidadMenorRuta.get(arista.destino.id)) {
                        probabilidadMenorRuta.put(arista.destino.id, nuevaProbabilidad);
                        colaPrioridad.add(arista.destino);
                    }
                }
            }
        }
        return 2;
    }

    public static void main(String[] args) {

        Graph grafo = new Graph();
        int A = Character.getNumericValue('A');
        int B = Character.getNumericValue('B');
        int C = Character.getNumericValue('C');
        int D = Character.getNumericValue('D');
        int E = Character.getNumericValue('E');
        int T = Character.getNumericValue('T');
        int R = Character.getNumericValue('R');

        grafo.insertarArista(A,C,95);
        grafo.insertarArista(A,B,99);
        grafo.insertarArista(B,A,99);
        grafo.insertarArista(B,C,98);
        grafo.insertarArista(B,D,96);
        grafo.insertarArista(C,E,98);
        grafo.insertarArista(C,D,99);
        grafo.insertarArista(C,R,94);
        grafo.insertarArista(D,C,99);
        grafo.insertarArista(D,E,97);
        grafo.insertarArista(E,R,97);
        grafo.insertarArista(T,A,99);
        grafo.insertarArista(T,B,97);

    }
}
