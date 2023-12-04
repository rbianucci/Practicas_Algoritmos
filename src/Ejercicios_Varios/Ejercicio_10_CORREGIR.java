package Ejercicios_Varios;

import java.util.ArrayList;


// Moneda Falsa. Mr. Scrooge ha cobrado una antigua deuda, recibiendo una bolsa
// con n monedas de oro. Su olfato de usurero le asegura que una de ellas es
// falsa, pero lo único que la distingue de las demás es su peso, aunque no sabe
// si este es mayor o menor que el de las otras. Para descubrir cuál es la falsa,
// Mr. Scrooge solo dispone de una balanza con dos platillos para comparar el peso
// de dos conjuntos de monedas. En cada pesada lo único que puede observar es si
// la balanza queda equilibrada, si pesan más los objetos del platillo de la derecha o
// si pesan más los de la izquierda. Diseñar un algoritmo para encontrar la moneda
// falsa, y decidir si pesa más o menos que las auténticas.

// BUSQUEDA BINARIA
// ERROR DA MAL LA POSICION

public class Ejercicio_10_CORREGIR {


    public static void mostrarLista(ArrayList<Double> lista){

        System.out.println("");
        for (Double valor: lista){
            System.out.print(valor + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Double> monedas = new ArrayList<>();
        monedas.add(1.0);
        monedas.add(1.0);
        monedas.add(1.0);
        monedas.add(1.0);
        monedas.add(0.9);
        monedas.add(1.0);
        monedas.add(1.0);
        monedas.add(1.0);
        monedas.add(1.0);
        monedas.add(1.0);

        //int indiceFalsa = encontrarMonedaFalsa(monedas);
        //System.out.println("La moneda falsa está en la posición: " + indiceFalsa);
        //System.out.println("La moneda falsa pesa menos que las auténticas.");
    }
}




