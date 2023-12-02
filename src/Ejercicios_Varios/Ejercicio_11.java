package Ejercicios_Varios;
import java.util.Arrays;

// Búsqueda de un carácter. Se tiene una cadena de texto de longitud conocida
// (puede considerarse que no hay una longitud máxima determinada, o usar un
// valor constante TamMax) que está compuesta por caracteres alfanuméricos ya
// ordenados de manera lexicográfica; por ejemplo, la cadena:
// aabeeeeffhkklmmmmmmpqqqrsszz. Diseñar un algoritmo eficiente que determine si un
// carácter determinado (por ejemplo “p”) se encuentra en la cadena; los datos del
// algoritmo serán la cadena y el carácter. No importa la posición del carácter dentro
// de la cadena, únicamente si está o no está presente.


public class Ejercicio_11 {

    public static boolean buscarCaracter(char[] cadena, char caracter){

        if (cadena.length == 1){
            return cadena[0] == caracter;
        }else{
            int valor = cadena[cadena.length / 2];
            if (valor == caracter){
                return true;
            }
            else{
                int mitad = cadena.length / 2;
                if (caracter < valor){
                    return buscarCaracter(Arrays.copyOfRange(cadena, 0, mitad - 1),caracter);
                }
                else{
                    return buscarCaracter(Arrays.copyOfRange(cadena, mitad, cadena.length - 1),caracter);
                }
            }
        }
    }

    public static void main(String[] args) {
        String cadena = "aaaaabbbbbccccddddeeeeffffggghhhhiii";
        System.out.println(buscarCaracter(cadena.toCharArray(),'e'));
    }
}
