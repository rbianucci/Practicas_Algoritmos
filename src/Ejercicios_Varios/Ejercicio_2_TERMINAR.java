package Ejercicios_Varios;

//N embarcaderos: A lo largo de un río hay n embarcaderos. En cada embarcadero
//se puede tomar una lancha que va hasta cualquier otro embarcadero río abajo
//(no es posible ir río arriba). Existe una tabla de tarifas de cada viaje entre un
//embarcadero i y un embarcadero j (i<j). El objetivo del problema es llegar
//desde un embarcadero i hasta un embarcadero j utilizando la menor cantidad de
//dinero posible, aunque haya que cambiar de lancha todas las veces que sea
//necesario, ya que este cambio no tiene costo adicional.

// GREEDY

import java.util.ArrayList;

public class Ejercicio_2_TERMINAR {

    private class Node {
        int destino;
        int peso;

        Node(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    public static void costoEmbarcacion(Graph G, Node inicio, Node destino){
        Graph resultado = new Graph();

    }

    public static void main(String[] args) {

    }
}
