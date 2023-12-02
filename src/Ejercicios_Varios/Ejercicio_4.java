package Ejercicios_Varios;

import java.util.ArrayList;

public class Ejercicio_4 {

    public static int combinarVectores(int[] vector1, int[] vector2){

        ArrayList<Integer> vectorResultado = new ArrayList<>();
        boolean combinar = true;
        int i= 0;
        int j= 0;
        while (combinar){
            if (vector1[i] < vector2[j]){
                vectorResultado.add(vector1[i]);
                if (i < vector1.length-1){
                    i+=1;
                }else{
                    vectorResultado.add(vector2[j]);
                    j+=1;
                }
            }
            else{
                vectorResultado.add(vector2[j]);
                if (j < vector2.length-1){
                    j+=1;
                }else{
                    vectorResultado.add(vector1[i]);
                    i+=1;
                }
            }
            if (j == vector2.length-1 && i == vector1.length-1){
                combinar = false;
            }
        }
        mostrarArray(vectorResultado);
        return vectorResultado.get(vectorResultado.size()/2);
    }


    public static void mostrarArray(ArrayList<Integer> array){
        for (int valor: array){
            System.out.println(valor);
        }
    }

    public static void main(String[] args) {

        int[] vector1 = {1,2,4};
        int[] vector2 = {3,5,6};
        System.out.println("Mediana: " + combinarVectores(vector1,vector2));
    }
}
