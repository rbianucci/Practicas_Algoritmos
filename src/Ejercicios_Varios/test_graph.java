package Ejercicios_Varios;
import java.util.*;

public class test_graph {


    public static Map<Graph.Nodo, Integer> dijkstra(Graph graph, Graph.Nodo origen) {

        Map<Graph.Nodo, Integer> distancias = new HashMap<>();
        PriorityQueue<NodoDistancia> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(nd -> nd.distancia));

        // Inicializar todas las distancias a infinito, excepto el nodo de origen
        for (Graph.Nodo nodo : graph.obtenerNodos().values()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        colaPrioridad.offer(new NodoDistancia(origen, 0));

        // Procesar nodos en orden de menor distancia
        while (!colaPrioridad.isEmpty()) {
            Graph.Nodo nodoActual = colaPrioridad.poll().nodo;

            for (Graph.Arista arista : graph.obtenerAristas()) {
                if (arista.origen == nodoActual) {
                    int nuevaDistancia = distancias.get(nodoActual) + arista.costo;

                    if (nuevaDistancia < distancias.get(arista.destino)) {
                        distancias.put(arista.destino, nuevaDistancia);
                        colaPrioridad.offer(new NodoDistancia(arista.destino, nuevaDistancia));
                    }
                }
            }
        }
        return distancias;
    }

    public static Map<Graph.Nodo, Integer> dijkstra_modificado(Graph graph, Graph.Nodo origen, Graph.Nodo destino) {

        Map<Graph.Nodo, Integer> distancias = new HashMap<>();
        PriorityQueue<NodoDistancia> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(nd -> nd.distancia));

        // Inicializar todas las distancias a infinito, excepto el nodo de origen
        for (Graph.Nodo nodo : graph.obtenerNodos().values()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        colaPrioridad.offer(new NodoDistancia(origen, 0));

        // Procesar nodos en orden de menor distancia
        while (!colaPrioridad.isEmpty()) {
            Graph.Nodo nodoActual = colaPrioridad.poll().nodo;

            for (Graph.Arista arista : graph.obtenerAristas()) {
                if (arista.origen == nodoActual) {
                    int nuevaDistancia = distancias.get(nodoActual) + arista.costo;
                    if (nuevaDistancia < distancias.get(arista.destino)) {
                        distancias.put(arista.destino, nuevaDistancia);
                        colaPrioridad.offer(new NodoDistancia(arista.destino, nuevaDistancia));
                    }
                }
            }
            if (nodoActual.id == destino.id){
                return distancias;
            }
        }
        return distancias;
    }

    public static List<Graph.Arista> prim(Graph grafo) {
        PriorityQueue<Graph.Arista> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Graph.Arista::getCosto));

        Set<Graph.Nodo> nodosIncluidos = new HashSet<>();
        List<Graph.Arista> arbolExpansion = new ArrayList<>();

        if (grafo.obtenerNodos().isEmpty()) {
            System.out.println("Error: El grafo está vacío.");
            return arbolExpansion;
        }

        // Iniciar con el primer nodo
        Graph.Nodo nodoInicial = grafo.obtenerNodos().values().iterator().next();
        nodosIncluidos.add(nodoInicial);

        // Agregar aristas del nodo inicial a la cola de prioridad
        for (Graph.Arista arista : grafo.obtenerAristas()) {
            if (arista.origen == nodoInicial || arista.destino == nodoInicial) {
                colaPrioridad.add(arista);
            }
        }

        while (!colaPrioridad.isEmpty() && nodosIncluidos.size() < grafo.obtenerNodos().size()) {
            Graph.Arista aristaActual = colaPrioridad.poll();

            Graph.Nodo nodoOrigen = aristaActual.origen;
            Graph.Nodo nodoDestino = aristaActual.destino;

            // Verificar si ambos nodos ya están incluidos en el árbol
            if (nodosIncluidos.contains(nodoOrigen) && !nodosIncluidos.contains(nodoDestino)) {
                nodosIncluidos.add(nodoDestino);
                arbolExpansion.add(aristaActual);

                // Agregar aristas del nodo destino a la cola de prioridad
                for (Graph.Arista arista : grafo.obtenerAristas()) {
                    if (arista.origen == nodoDestino || arista.destino == nodoDestino) {
                        colaPrioridad.add(arista);
                    }
                }
            } else if (!nodosIncluidos.contains(nodoOrigen) && nodosIncluidos.contains(nodoDestino)) {
                nodosIncluidos.add(nodoOrigen);
                arbolExpansion.add(aristaActual);

                // Agregar aristas del nodo origen a la cola de prioridad
                for (Graph.Arista arista : grafo.obtenerAristas()) {
                    if (arista.origen == nodoOrigen || arista.destino == nodoOrigen) {
                        colaPrioridad.add(arista);
                    }
                }
            }
        }
        return arbolExpansion;
    }

    static class NodoDistancia {
        Graph.Nodo nodo;
        int distancia;

        NodoDistancia(Graph.Nodo nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }

        public Graph.Nodo getNodo() {
            return nodo;
        }

        public int getDistancia() {
            return distancia;
        }
    }


    public static void main(String[] args) {
        Graph grafo = new Graph();
        grafo.insertarNodo(1);
        grafo.insertarNodo(2);
        grafo.insertarNodo(3);
        grafo.insertarNodo(4);
        grafo.insertarNodo(5);
        grafo.insertarNodo(6);
        grafo.insertarArista(1,2,10);
        grafo.insertarArista(1,3,3);
        grafo.insertarArista(2,5,12);
        grafo.insertarArista(3,2,5);
        grafo.insertarArista(3,4,6);
        grafo.insertarArista(4,6,9);
        grafo.insertarArista(5,6,6);

        Map<Graph.Nodo, Integer> dijkstra = dijkstra(grafo,grafo.obtenerNodoPorId(1));
        mostrar_Map(dijkstra);

        Map<Graph.Nodo, Integer> dijkstra_modificado = dijkstra_modificado(grafo,grafo.obtenerNodoPorId(1),grafo.obtenerNodoPorId(3));
        mostrar_Map(dijkstra_modificado);

        // PRIM FUNCIONA CON GRAFOS NO DIRIGIDOS, ESTO QUIERE DECIR, QUE SON BIDIRECCIONALES LAS ARISTAS, POR LO TANTO
        // AGREGAMOS LA VUELTA A CADA ARISTA QUE SOLO TIENE LA IDA
        grafo.insertarArista(2,1,10);
        grafo.insertarArista(3,1,3);
        grafo.insertarArista(5,2,12);
        grafo.insertarArista(2,3,5);
        grafo.insertarArista(4,3,6);
        grafo.insertarArista(6,4,9);
        grafo.insertarArista(6,5,6);
        List<Graph.Arista> prim = prim(grafo);
        for (Graph.Arista arista: prim){
            System.out.println("Origen: " + arista.origen.id + "  Destino: " + arista.destino.id + "  |  Costo: " + arista.costo );
        }

        mostrarGrafo(grafo);
    }

    public static void mostrarGrafo(Graph grafo) {

        System.out.println("NODOS");
        for (Graph.Nodo nodo : grafo.obtenerNodos().values()) {
            System.out.println("Nodo: " + nodo.id);
        }
        System.out.println();
        System.out.println("ARISTAS");
        for (Graph.Arista arista: grafo.obtenerAristas()){
            System.out.println("Origen: " + arista.origen.id + "  Destino: " + arista.destino.id + "  |  Costo: " + arista.costo );
        }
    }

    public static void mostrar_Map(Map<Graph.Nodo, Integer> mapa){
        for (Map.Entry<Graph.Nodo, Integer> entry : mapa.entrySet()) {
            System.out.println("Nodo: " + entry.getKey().id + ", Distancia: " + entry.getValue());
        }
        System.out.println();
    }
}
