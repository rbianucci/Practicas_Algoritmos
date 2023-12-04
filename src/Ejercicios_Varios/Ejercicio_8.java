package Ejercicios_Varios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio_8 {

    public static List<Integer> calcularParadasCarga(int[] estaciones, int capacidadTanque) {
        List<Integer> paradas = new ArrayList<>();
        int distanciaRecorrida = 0;
        int capacidadActual = capacidadTanque;

        for (int i=0; i<estaciones.length-1 ; i++) {
            if (capacidadActual - estaciones[i] < estaciones[i+1]){
                paradas.add(i);

            }
            capacidadActual = capacidadTanque - estaciones[i+1];
        }

        return paradas;
    }

    public static void main(String[] args) {
        int[] distanciasEntreEstaciones = {50, 10, 90, 30, 20, 20, 99};
        int capacidadTanque = 100;

        List<Integer> paradas = calcularParadasCarga(distanciasEntreEstaciones, capacidadTanque);

        System.out.println("Paradas recomendadas para cargar combustible: " + paradas);
    }
}

