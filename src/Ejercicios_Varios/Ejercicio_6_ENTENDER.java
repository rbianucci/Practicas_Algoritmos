package Ejercicios_Varios;

// Traducciones: Una empresa de traducciones desea realizar la traducción de textos
//de un idioma a otro. Para ello cuenta con algunos diccionarios bilingües. Cada
//diccionario sirve para hacer la traducción entre dos idiomas en cualquiera de los
//dos sentidos. Si se tienen N idiomas y M diccionarios, determinar la menor
//cantidad de traducciones que se deberán realizar para traducir un texto entre
//cualquier par de idiomas, siempre que sea posible realizarlo con los diccionarios
//disponibles.

import java.util.Map;

public class Ejercicio_6_ENTENDER {

    public static Graph traducciones(Graph G){
        Graph resultado = G;
        Map<Integer, Graph.Nodo> vertices_k = G.obtenerNodos();
        for(int k = 0 ; k < vertices_k.size() ; k++){
            Map<Integer, Graph.Nodo> vertices_i = G.obtenerNodos();
            for(int i = 0 ; i < vertices_i.size() ; i++){
                Map<Integer, Graph.Nodo> vertices_j = G.obtenerNodos();
                for(int j = 0 ; j < vertices_j.size() ; j++){
                    if(i != j && G.existeArista(i,k) && G.existeArista(k,j)){
                        if(G.existeArista(i,j)){
                            if (G.calcularCosto(i,k)+G.calcularCosto(k,j) < G.calcularCosto(i,j)){
                              G.insertarArista(i,j, G.calcularCosto(i,k)+G.calcularCosto(k,j));
                            }
                        }
                    }
                }
            }
        }
        return G;
    }

    public static void main(String[] args) {
        Graph grafo = new Graph();
        grafo.insertarNodo(0);
        grafo.insertarNodo(1);
        grafo.insertarNodo(2);
        grafo.insertarNodo(3);
        grafo.insertarNodo(4);
        grafo.insertarNodo(5);
        grafo.insertarArista(0,1,4);
        grafo.insertarArista(0,5,8);
        grafo.insertarArista(1,0,4);
        grafo.insertarArista(1,4,6);
        grafo.insertarArista(1,2,7);
        grafo.insertarArista(2,1,7);
        grafo.insertarArista(2,3,8);
        grafo.insertarArista(3,2,8);
        grafo.insertarArista(3,4,3);
        grafo.insertarArista(3,5,1);
        grafo.insertarArista(4,1,6);
        grafo.insertarArista(4,3,3);
        grafo.insertarArista(4,5,2);
        grafo.insertarArista(5,0,8);
        grafo.insertarArista(5,4,2);
        grafo.insertarArista(5,3,1);

        grafo = traducciones(grafo);

        for (Graph.Nodo nodo : grafo.obtenerNodos().values()){
            System.out.println("Nodo: " + nodo.id);
        }

        for (Graph.Arista arista : grafo.obtenerAristas()){
            System.out.println("Arista | Origen: " + arista.origen.id + "  Destino: " + arista.destino.id + "  Costo: " + arista.costo);
        }
    }
}
