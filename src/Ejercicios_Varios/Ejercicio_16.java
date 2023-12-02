package Ejercicios_Varios;

// Selección de menú. En una carta de comidas de un restaurante cada menú tiene
// asociado el precio y las calorías del plato. Se considera que la satisfacción de un
// comensal está asociada directamente a las calorías del plato, es decir, que un
// plato con mayores calorías le da mayor satisfacción. Diseñe un algoritmo que
// maximice la satisfacción del comensal, seleccionando una combinación de platos
// que no supere el presupuesto P que tiene el comensal.

// PROGRAMACIÓN DINAMICA

public class Ejercicio_16 {

    static class Plato {
        int precio;
        int calorias;

        public Plato(int precio, int calorias) {
            this.precio = precio;
            this.calorias = calorias;
        }
    }

    public static int maximizarSatisfaccion(Plato[] platos, int presupuesto) {
        int n = platos.length;
        int[][] tabla = new int[n + 1][presupuesto + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (i == 0 || j == 0) {
                    tabla[i][j] = 0;
                } else if (platos[i - 1].precio <= j) {
                    tabla[i][j] = Math.max(tabla[i - 1][j], tabla[i - 1][j - platos[i - 1].precio] + platos[i - 1].calorias);
                } else {
                    tabla[i][j] = tabla[i - 1][j];
                }
            }
        }

        return tabla[n][presupuesto];
    }

    public static void main(String[] args) {
        Plato[] platos = {
                new Plato(10, 100),
                new Plato(5, 50),
                new Plato(8, 80),
                new Plato(3, 30)
        };

        int presupuesto = 21;

        int maxSatisfaccion = maximizarSatisfaccion(platos, presupuesto);
        System.out.println("Máxima satisfacción obtenida: " + maxSatisfaccion);
    }
}
