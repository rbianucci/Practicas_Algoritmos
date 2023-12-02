package Ejercicios_Varios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio_19 {

    static class Escalera {
        int metros;

        Escalera(int metros) {
            this.metros = metros;
        }
    }

    public static int tiempoMinimo(List<Escalera> escaleras, int alturaMuralla) {
        escaleras.sort(Comparator.comparingInt((Escalera e) -> e.metros).reversed());

        int tiempoTotal = 0;

        for (Escalera escalera : escaleras) {
            tiempoTotal += escalera.metros;
            if (tiempoTotal > alturaMuralla) {
                return tiempoTotal;
            }
        }
        return tiempoTotal;
    }

    public static void main(String[] args) {
        List<Escalera> escaleras = new ArrayList<>();
        escaleras.add(new Escalera(6));
        escaleras.add(new Escalera(8));
        escaleras.add(new Escalera(7));
        escaleras.add(new Escalera(9));
        int altura = 23; // altura de la torre

        int maxProgramas = tiempoMinimo(escaleras, altura);
        System.out.println("El tiempo máximo va a ser: " + maxProgramas);
    }
}
