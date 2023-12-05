package Ejercicios_Varios;

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

public class teoria_progra_dinamica {

    public static int cambio(int[] vector, int valor){
        int[][] matriz = new int[vector.length][valor+1];
        for (int i=0 ; i<vector.length ; i++){
            matriz[i][0] = 0;
            for (int j=1 ; j<valor ; j++){
                if (i == 0){
                    if (vector[j] > j){
                        matriz[i][j] = Integer.MAX_VALUE;
                    }else{
                        matriz[i][j] = matriz[i][j-vector[j]];
                    }
                }else{
                    if (vector[j] > j){
                        matriz[i][j] = matriz[i-1][j];
                    }else{
                        matriz[i][j] = Math.min(matriz[i-1][j] , matriz[i][j-vector[j]]);
                    }
                }
            }
        }
        return matriz[vector.length-1][valor];
    }

    public static class Objeto{

        int peso;
        int valor;
        Objeto(int valor, int peso){
            this.valor = valor;
            this.peso = peso;
        }

        public double relacion(){
            return valor/peso;
        }

    }

    public static int mochila(ArrayList<Objeto> objetos, int valor){
        int[][] M = new int[objetos.size()][valor+1];
        for (int i=0 ; i<objetos.size() ; i++){
            for (int j=0 ; j<valor ; j++){
                if (i==0 && objetos.get(i).peso < j){
                    M[i][j] = 0;
                }else{
                    if (i==0){
                        M[i][j] = objetos.get(i).valor;
                    }else{
                        if (objetos.get(i).peso < j){
                            M[i][j] = M[i-1][j];
                        }else{
                            M[i][j] = Math.max(M[i-1][j],M[i-1][j-objetos.get(i).peso]+objetos.get(i).valor);
                        }
                    }
                }
            }
        }
        return M[objetos.size()-1][valor];
    }

    public static int subSecuencia(char[] X, char[] Y){
        int[][] M = new int[X.length+1][Y.length+1];
        for (int i=0 ; i<X.length ; i++){
            for (int j=0 ; j<Y.length ; j++){
                if (i==0 || j==0){
                    M[i][j] = 0;
                }else{
                    if (X[i] == Y[j]){
                        M[i][j] = M[i-1][j-1] +1;
                    }else{
                        M[i][j] = Math.max(M[i-1][j],M[i][j-1]);
                    }
                }
            }
        }
        return M[X.length][Y.length];
    }

    public static Graph Floyd(Graph grafo){
        Graph grafo_copia = new Graph();
        ArrayList<Graph.Nodo> vertices_k = new ArrayList<>();
        for (Graph.Nodo nodo: grafo.obtenerNodos().values()){
            grafo_copia.insertarNodo(nodo.id);
            vertices_k.add(nodo);
        }
        for(Graph.Arista arista: grafo.obtenerAristas()){
            grafo_copia.insertarArista(arista.origen.id,arista.destino.id,arista.costo);
        }
        for (Graph.Nodo nodo_k: vertices_k){
            ArrayList<Graph.Nodo> vertices_i = new ArrayList<>();
            for (Graph.Nodo nodo: grafo.obtenerNodos().values()){
                vertices_i.add(nodo);
            }
            for (Graph.Nodo nodo_i: vertices_i){
                ArrayList<Graph.Nodo> vertices_j = new ArrayList<>();
                for (Graph.Nodo nodo: grafo.obtenerNodos().values()){
                    vertices_j.add(nodo);
                }
                for (Graph.Nodo nodo_j: vertices_j){
                    if (nodo_i.id != nodo_j.id  && grafo_copia.existeArista(nodo_i.id,nodo_k.id) && grafo_copia.existeArista(nodo_k.id,nodo_j.id)){
                        if (grafo_copia.existeArista(nodo_i.id,nodo_j.id)){
                            if (grafo_copia.calcularCosto(nodo_i.id,nodo_k.id) + grafo_copia.calcularCosto(nodo_k.id,nodo_j.id) < grafo_copia.calcularCosto(nodo_i.id,nodo_j.id)){
                                grafo_copia.insertarArista(nodo_i.id,nodo_j.id,grafo_copia.calcularCosto(nodo_i.id,nodo_j.id) + grafo.calcularCosto(nodo_k.id,nodo_j.id));
                            }
                        }
                    }
                }
            }
        }
        return grafo_copia;
    }

    public static void main(String[] args) {

    }
}
