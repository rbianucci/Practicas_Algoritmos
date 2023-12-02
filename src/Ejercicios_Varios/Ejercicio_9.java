package Ejercicios_Varios;

public class Ejercicio_9 {

    public static int contarCombinaciones(int puntos) {
        // Creamos un arreglo para almacenar el número de combinaciones para cada cantidad de puntos
        int[] dp = new int[puntos + 1];

        // Inicializamos el caso base: hay una combinación para 0 puntos (ninguna jugada)
        dp[0] = 1;

        // Iteramos sobre todas las jugadas posibles (safety, field goal, touchdown)
        int[] jugadas = {2, 3, 7};
        for (int jugada : jugadas) {
            // Actualizamos la tabla para cada cantidad de puntos posible
            for (int i = jugada; i <= puntos; i++) {
                dp[i] += dp[i - jugada];
            }
        }

        // La cantidad de combinaciones para la cantidad total de puntos está en dp[puntos]
        return dp[puntos];
    }

    public static void main(String[] args) {
        int puntos = 12; // Puntos marcados por el equipo en un partido

        int combinaciones = contarCombinaciones(puntos);
        System.out.println("Cantidad de combinaciones posibles: " + combinaciones);
    }
}
