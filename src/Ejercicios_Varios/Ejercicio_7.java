package Ejercicios_Varios;

// Maximización de programas: Sean n programas P1, ...,Pn que hay que almacenar
//en un disco. El programa Pi requiere Si GB de espacio y la capacidad del disco
//es D GB. Realizar un algoritmo que ingrese la mayor cantidad posible de
//programas en el disco.

// PROGRA DINAMICA - PROBLEMA MOCHILA

public class Ejercicio_7 {

    public static int maximizarProgramas(int[] programas, int D) {
        int n = programas.length;
        int[][] dp = new int[n + 1][D + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= D; j++) {
                // No incluir el i-ésimo programa
                dp[i][j] = dp[i - 1][j];

                // Incluir el i-ésimo programa si hay espacio
                if (j >= programas[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - programas[i - 1]] + 1);
                }
            }
        }

        return dp[n][D];
    }

    public static void main(String[] args) {
        int[] programas = {2, 3, 4, 5}; // Tamaño en GB de cada programa
        int capacidadDisco = 10; // Capacidad del disco en GB

        int maxProgramas = maximizarProgramas(programas, capacidadDisco);
        System.out.println("La máxima cantidad de programas que se pueden almacenar es: " + maxProgramas);
    }
}

