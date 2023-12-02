package Ejercicios_Varios;

import java.util.Arrays;
import java.util.Comparator;

public class Ejercicio_23 {

    static class Cliente {
        int tiempoEspera;

        public Cliente(int tiempoEspera) {
            this.tiempoEspera = tiempoEspera;
        }
    }

    public static double maximizarGanancias(Cliente[] clientes) {
        Arrays.sort(clientes, Comparator.comparingDouble(c -> +c.tiempoEspera));

        double ganancias = 0.0;
        int tiempoTotal = 0;

        for (Cliente cliente : clientes) {
            tiempoTotal += cliente.tiempoEspera;
            ganancias += 1.0 / tiempoTotal;
        }

        return ganancias * 100;
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(5),
                new Cliente(3),
                new Cliente(8),
                new Cliente(2)
        };

        double ganancias = maximizarGanancias(clientes);

        System.out.println("Ganancias maximizadas: " + ganancias);
    }
}
