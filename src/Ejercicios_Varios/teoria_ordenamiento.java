package Ejercicios_Varios;

import java.util.ArrayList;

public class teoria_ordenamiento {

    public static int[] seleccion(int[] vector){
        for (int i=0 ; i<vector.length-1 ; i++){
            int m = i;
            for (int j=i+1 ; j< vector.length; j++){
                if (vector[j] < vector[m]){
                    m = j;
                }
            }
            int aux = vector[i];
            vector[i] = vector[m];
            vector[m] = aux;
        }
        return vector;
    }

    public static int[] insercion(int[] vector){
        for (int i=1; i<vector.length ; i++){
            for (int j=i ; j<1 ; j--){
                if (vector[j] < vector[j-1]){
                    int aux = vector[j-1];
                    vector[j-1] = vector[j];
                    vector[j] = aux;
                }
            }
        }
        return vector;
    }

    public static void MergeSort(int[] vector, int inicio, int fin){
        if (inicio < fin){
            int medio = (inicio+fin)/2;
            MergeSort(vector, inicio, medio);
            MergeSort(vector, medio+1, fin);
            Merge(vector,inicio,fin);
        }
    }

    public static void Merge(int[] vector, int inicio, int fin){
        ArrayList<Integer> resultado = new ArrayList<>();

        int medio = (inicio+fin)/2;
        int i = inicio;
        int j = medio;
        for (int k=0 ; k<=(fin-inicio) ; k++){
            if (j>fin || (i<=medio && vector[i] <= vector[j])){
                resultado.add(i);
                i++;
            }else{
                resultado.add(j);
                j++;
            }
        }
        System.out.println();
        for (Integer valor: resultado){
            System.out.println(valor);
        }
    }

    public static void QuickSort(int[] vector, int inicio, int fin){
        if (inicio < fin){
            int p = pivot(vector, inicio, fin);
            QuickSort(vector, inicio,p-1);
            QuickSort(vector,p+1,fin);
        }
    }

    public static int pivot(int[] vector, int inicio, int fin){
        int p = vector[inicio];
        int k = inicio+1;
        int l = fin;
        while (vector[k] <= p && k<fin){
            k = k+1;
        }
        while (vector[l] > p){
            l = l+1;
        }
        while (k<l){
            int aux = vector[k];
            vector[k] = vector[l];
            vector[l] = aux;
            while (vector[k] <= p){
                k = k+1;
            }
            while (vector[l] > p){
                l = l+1;
            }
        }
        int aux = vector[inicio];
        vector[inicio] = vector[l];
        vector[l] = aux;
        return p;
    }

    public static void main(String[] args) {
        int[] vector = {1,7,2,3,9,5,4,8};
        for (int valor: seleccion(vector)){
            System.out.println(valor);
        }
        System.out.println();
        for (int valor: insercion(vector)){
            System.out.println(valor);
        }
        System.out.println();
        MergeSort(vector, 0, vector.length);


    }
}
