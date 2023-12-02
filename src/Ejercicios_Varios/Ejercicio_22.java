package Ejercicios_Varios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio_22 {

    static class Proyecto implements Comparable<Proyecto> {
        int presupuesto;
        int regiones;

        public Proyecto(int presupuesto, int regiones) {
            this.presupuesto = presupuesto;
            this.regiones = regiones;
        }

        @Override
        public int compareTo(Proyecto otroProyecto) {
            // Ordenar proyectos por número de regiones de manera descendente
            return Integer.compare(otroProyecto.regiones, this.regiones);
        }
    }

    public static List<Proyecto> seleccionarProyectos(List<Proyecto> proyectos, int presupuestoTotal) {
        // Ordenar proyectos por número de regiones de manera descendente
        Collections.sort(proyectos);

        int n = proyectos.size();
        int[][] tabla = new int[n + 1][presupuestoTotal + 1];

        for (int i = 1; i <= n; i++) {
            Proyecto proyectoActual = proyectos.get(i - 1);

            for (int j = 1; j <= presupuestoTotal; j++) {
                if (proyectoActual.presupuesto <= j) {
                    tabla[i][j] = Math.max(tabla[i - 1][j], tabla[i - 1][j - proyectoActual.presupuesto] + proyectoActual.regiones);
                } else {
                    tabla[i][j] = tabla[i - 1][j];
                }
            }
        }

        // Reconstruir la lista de proyectos seleccionados
        List<Proyecto> proyectosSeleccionados = new ArrayList<>();
        int i = n;
        int j = presupuestoTotal;

        while (i > 0 && j > 0) {
            if (tabla[i][j] != tabla[i - 1][j]) {
                // El proyecto actual contribuye al resultado
                proyectosSeleccionados.add(proyectos.get(i - 1));
                j -= proyectos.get(i - 1).presupuesto;
            }
            i--;
        }

        Collections.reverse(proyectosSeleccionados);
        return proyectosSeleccionados;
    }

    public static void main(String[] args) {
        List<Proyecto> proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(100, 5));
        proyectos.add(new Proyecto(50, 3));
        proyectos.add(new Proyecto(80, 4));
        proyectos.add(new Proyecto(30, 2));

        int presupuestoTotal = 120;

        List<Proyecto> proyectosSeleccionados = seleccionarProyectos(proyectos, presupuestoTotal);

        System.out.println("Proyectos seleccionados:");
        for (Proyecto proyecto : proyectosSeleccionados) {
            System.out.println("Presupuesto: " + proyecto.presupuesto + ", Regiones: " + proyecto.regiones);
        }
    }
}
