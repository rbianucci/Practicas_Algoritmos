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

    public static int encontrarMonedaFalsa(ArrayList<Double> monedas) {
        int n = monedas.size();
        return buscarMonedaFalsa(0, n, monedas);
    }

    private static int compararPesos(ArrayList<Double> conjunto1, ArrayList<Double> conjunto2) {
        return Double.compare(sumarPeso(conjunto1), sumarPeso(conjunto2));
    }

    private static double sumarPeso(ArrayList<Double> conjunto){
        double total = 0;
        for (Double valor: conjunto){
            total+=valor;
        }
        return total;
    }

    private static int buscarMonedaFalsa(int inicio, int fin, ArrayList<Double> monedas) {
        if (inicio == fin) {
            return inicio; // Se encontró la moneda falsa
        }

        int medio = (inicio + fin) / 2;
        // Dividir las monedas en tres partes: izquierda, medio y derecha
        ArrayList<Double> conjuntoIzquierda = new ArrayList<>();
        ArrayList<Double> conjuntoDerecha = new ArrayList<>();

        for (int i = inicio; i < medio; i++) {
            conjuntoIzquierda.add(monedas.get(i));
        }
        for (int i = medio; i < fin; i++) {
            conjuntoDerecha.add(monedas.get(i));
        }

        mostrarLista(monedas);
        mostrarLista(conjuntoIzquierda);
        mostrarLista(conjuntoDerecha);

        // Comparar el peso de los conjuntos
        int resultado = compararPesos(conjuntoIzquierda, conjuntoDerecha);

        if (resultado == 0) {
            // Los conjuntos son equilibrados, la moneda falsa está en la parte no evaluada
            return buscarMonedaFalsa(medio, fin, monedas);
        } else if (resultado < 0) {
            // El conjunto izquierdo pesa menos, la moneda falsa está en ese conjunto
            return buscarMonedaFalsa(inicio, medio, monedas);
        } else {
            // El conjunto derecho pesa menos, la moneda falsa está en ese conjunto
            return buscarMonedaFalsa(medio, fin, monedas);
        }
    }

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

        int indiceFalsa = encontrarMonedaFalsa(monedas);
        System.out.println("La moneda falsa está en la posición: " + indiceFalsa);
        System.out.println("La moneda falsa pesa menos que las auténticas.");
    }
}




