package Ejercicios_Varios;
import java.util.Arrays;

public class teoria_divide_y_conquista {

    // el array debe estar ordenado de forma asecendete para poder hacer la busqueda
    public static boolean busqueda_binaria(int[] vector, int valor){
        System.out.println("Tamaño del vector: " + vector.length);
        for (int valor_vector: vector){
            System.out.println(valor_vector);
        }
        if (vector.length == 1){
            return vector[0] == valor;
        }else{

            int mitad = vector.length/2;
            System.out.println("Mitad " + mitad);
            System.out.println();
            if (vector[mitad] == valor){
                return true;
            }else if (vector[mitad] > valor){
                return busqueda_binaria(Arrays.copyOfRange(vector,0,mitad),valor);
            }else{
                return busqueda_binaria(Arrays.copyOfRange(vector,mitad+1,vector.length),valor);
            }
        }
    }

    // BUSQUEDA BINARIA PERO VOY GUARDANDO LA POSICION AL VOLVER
    public static int busqueda_binaria_2(int[] vector, int valor){
        if (vector.length == 1){
            return 0;
        }else{
            int mitad = vector.length/2;
            if (vector[mitad] == valor){
                System.out.println("Medio: " + 1);
                return 1;
            }else if (vector[mitad] > valor){
                int[] vector_aux = Arrays.copyOfRange(vector,0,mitad);
                int pos_aux = busqueda_binaria_2(vector_aux,valor);
                System.out.println("Lado izquierdo: " + pos_aux);
                return pos_aux;
            }else{
                int[] vector_aux = Arrays.copyOfRange(vector,mitad+1,vector.length);
                int pos_aux = vector.length - vector_aux.length +  busqueda_binaria_2(vector_aux,valor);
                System.out.println("Lado derecho " + pos_aux);
                return pos_aux;
            }
        }

    }


    public static void main(String[] args) {
        int[] vector = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println("El resultado es: " + busqueda_binaria(vector,5));
        System.out.println("El resultado es: " + busqueda_binaria_2(vector,5));
    }
}
