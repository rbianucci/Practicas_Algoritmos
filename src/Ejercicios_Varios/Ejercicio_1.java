package Ejercicios_Varios;

//Trasponer un vector: Dados un vector V[0..n] y un número natural k entre 1 y n,
//diseñar un algoritmo eficiente que trasponga los k primeros elementos de V en los
//elementos en las n-k últimas posiciones, sin hacer uso de un vector auxiliar.


public class Ejercicio_1 {


    public static int [] trasponerVector(int [] vector, int k){

        if (k==0 || k>= vector.length ){
            return vector;
        }
        else {
            invertirVector(vector,0,k-1);
            mostrarVector(vector);
            invertirVector(vector,k,vector.length-1);
            mostrarVector(vector);
            invertirVector(vector,0,vector.length-1);
            mostrarVector(vector);
        }
        return  vector;
    }

    public static int [] invertirVector(int [] vector, int inicio, int fin){
        while (inicio < fin){
            int aux = vector[inicio];
            vector[inicio] = vector[fin];
            vector[fin] = aux;
            inicio+=1;
            fin-=1;
        }
        return vector;
    }

    public static void mostrarVector(int[] vector){

        System.out.println("VECTOR");
        for (int i = 0 ; i<vector.length ; i++){
            System.out.println(vector[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[] vector = {3,5,12,8,9,12,4,7,13,21};
        vector = trasponerVector(vector,3);
    }
}
