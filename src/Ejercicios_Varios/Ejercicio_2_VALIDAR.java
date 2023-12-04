package Ejercicios_Varios;

//N embarcaderos: A lo largo de un río hay n embarcaderos. En cada embarcadero
//se puede tomar una lancha que va hasta cualquier otro embarcadero río abajo
//(no es posible ir río arriba). Existe una tabla de tarifas de cada viaje entre un
//embarcadero i y un embarcadero j (i<j). El objetivo del problema es llegar
//desde un embarcadero i hasta un embarcadero j utilizando la menor cantidad de
//dinero posible, aunque haya que cambiar de lancha todas las veces que sea
//necesario, ya que este cambio no tiene costo adicional.

// GREEDY

import java.util.*;

public class Ejercicio_2_VALIDAR {

    public static Map<Graph.Nodo, Integer> dijkstra_modificado(Graph graph, Graph.Nodo origen, Graph.Nodo destino) {

        Map<Graph.Nodo, Integer> distancias = new HashMap<>();
        PriorityQueue<test_graph.NodoDistancia> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(nd -> nd.distancia));

        // Inicializar todas las distancias a infinito, excepto el nodo de origen
        for (Graph.Nodo nodo : graph.obtenerNodos().values()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        colaPrioridad.offer(new test_graph.NodoDistancia(origen, 0));

        // Procesar nodos en orden de menor distancia
        while (!colaPrioridad.isEmpty()) {
            Graph.Nodo nodoActual = colaPrioridad.poll().nodo;

            for (Graph.Arista arista : graph.obtenerAristas()) {
                if (arista.origen == nodoActual) {
                    int nuevaDistancia = distancias.get(nodoActual) + arista.costo;
                    if (nuevaDistancia < distancias.get(arista.destino)) {
                        distancias.put(arista.destino, nuevaDistancia);
                        colaPrioridad.offer(new test_graph.NodoDistancia(arista.destino, nuevaDistancia));
                    }
                }
            }
            if (nodoActual.id == destino.id){
                return distancias;
            }
        }
        return distancias;
    }

    public static void main(String[] args) {

        Graph grafo = new Graph();
        grafo.insertarNodo(1);
        grafo.insertarNodo(2);
        grafo.insertarNodo(3);
        grafo.insertarNodo(4);
        grafo.insertarNodo(5);
        grafo.insertarNodo(6);
        grafo.insertarNodo(7);
        grafo.insertarNodo(8);
        grafo.insertarArista(1,2,8);
        grafo.insertarArista(1,3,5);
        grafo.insertarArista(1,4,20);
        grafo.insertarArista(1,5,4);
        grafo.insertarArista(1,6,70);
        grafo.insertarArista(1,7,30);
        grafo.insertarArista(1,8,50);
        grafo.insertarArista(2,4,3);
        grafo.insertarArista(2,7,6);
        grafo.insertarArista(2,8,3);
        grafo.insertarArista(3,5,2);
        grafo.insertarArista(3,6,9);
        grafo.insertarArista(3,7,5);
        grafo.insertarArista(3,8,40);
        grafo.insertarArista(4,7,10);
        grafo.insertarArista(4,8,2);
        grafo.insertarArista(5,6,2);
        grafo.insertarArista(5,8,2);
        grafo.insertarArista(6,8,7);
        grafo.insertarArista(7,8,2);

        Map<Graph.Nodo, Integer> dijkstra = dijkstra_modificado(grafo,grafo.obtenerNodoPorId(1),grafo.obtenerNodoPorId(8));

        mostrar_Map(dijkstra);
    }

    public static void mostrar_Map(Map<Graph.Nodo, Integer> mapa){
        for (Map.Entry<Graph.Nodo, Integer> entry : mapa.entrySet()) {
            System.out.println("Nodo: " + entry.getKey().id + ", Distancia: " + entry.getValue());
        }
        System.out.println();
    }

}
