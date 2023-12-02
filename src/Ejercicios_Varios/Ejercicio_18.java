package Ejercicios_Varios;

//Posición de componente diferente. Se tienen dos vectores A y B de n enteros que
//cumplen la propiedad de que son iguales componente a componente hasta una
//posición dada, y a partir de ella, son distintos componentes a componente. Es
//decir, si A y B son iguales hasta la componente 7, eso significa que A[i]=B[i]
//para i=1,2,...,7, y que A[i]ǂB[i] para i=8,9,...,n. Por ejemplo:
//A=[2,3,8,4,5,6,9,1,4,7,4,9] y B=[2,3,8,4,5,6,9,6,3,5,1,8]. Escribir un algoritmo
//que calcule cual es la primera posición en la que A y B son distintos (en el
//caso del ejemplo, la 8) y estudiar su complejidad. El algoritmo debe poseer una
//complejidad menor que la lineal (que, por ejemplo, obtendríamos recorriendo
//ambos vectores en paralelo

// BUSQUEDA BINARIA

public class Ejercicio_18 {

    public static int encontrarPosicion(int[] A, int [] B){
        return encontrar(A,B,0,A.length);
    }

    public static int encontrar(int[] A, int[] B, int inicio, int fin){

        if (inicio == fin){
            return inicio;
        }else if (inicio > fin){
            return -1;
        }else{
            int mitad = (inicio+fin) / 2;
            if (A[mitad] == B[mitad]){
                return encontrar(A,B,mitad+1,fin);
            }else{
                return encontrar(A,B,inicio,mitad);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 8, 4, 5, 6, 9, 1, 4, 7, 4, 9};
        int[] B = {2, 3, 8, 4, 5, 6, 9, 6, 3, 5, 1, 8};

        int posicionDiferente = encontrarPosicion(A, B);

        System.out.println("La primera posición en la que A y B son distintos es: " + posicionDiferente);
    }
}
