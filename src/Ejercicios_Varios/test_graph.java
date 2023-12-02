package Ejercicios_Varios;

public class test_graph {



    public static void main(String[] args) {
        Graph grafo = new Graph();

        grafo.insertarNodo(1);
        grafo.insertarNodo(2);
        grafo.insertarNodo(3);
        grafo.insertarArista(1,2,10);
        grafo.insertarArista(2,3,10);
        System.out.println(grafo.calcularCosto(1,2));
    }
}
