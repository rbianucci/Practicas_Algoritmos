package Ejercicios_Varios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//.Financiamiento de proyectos. El gobierno nacional dispone de un fondo para la
//financiación de proyectos de ayuda, y se quiere financiar la realización de los
//proyectos beneficiando la máxima cantidad de regiones posibles. La información que
//se dispone es de una serie de tipos de proyecto diferentes, con la siguiente
//información disponible:
//• Presupuesto del tipo de proyecto, pi
//• Número de regiones en las que se puede realizar, ri
// Determinar cuáles proyectos deben ser financiados, sin superar el importe total del
//fondo, y beneficiando la mayor cantidad de regiones.


// En este ejercicio aplicamos Greedy con la relación de presupuesto/regiones

public class Ejercicio_22 {

    static class Proyecto {
        int presupuesto;
        int regiones;

        public Proyecto(int presupuesto, int regiones) {
            this.presupuesto = presupuesto;
            this.regiones = regiones;
        }

        double getValor(){
            return (double) (presupuesto/regiones);
        }
    }

    public static List<Proyecto> seleccionarProyectos(List<Proyecto> proyectos, int presupuestoTotal) {
        List<Proyecto> proyectosSeleccionados = new ArrayList<>();

        // Ordenar los proyectos por el número de regiones en orden descendente
        // para seleccionar primero los que beneficien a más regiones
        Collections.sort(proyectos, Comparator.comparingDouble((Proyecto p) -> p.getValor()));

        int presupuestoAcumulado = 0;

        // Seleccionar proyectos mientras no se exceda el presupuesto total
        for (Proyecto proyecto : proyectos) {
            if (presupuestoAcumulado + proyecto.presupuesto <= presupuestoTotal) {
                proyectosSeleccionados.add(proyecto);
                presupuestoAcumulado += proyecto.presupuesto;
            }
        }

        return proyectosSeleccionados;
    }

    public static void main(String[] args) {
        List<Proyecto> proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(10, 3));
        proyectos.add(new Proyecto(5, 2));
        proyectos.add(new Proyecto(8, 4));
        proyectos.add(new Proyecto(3, 1));

        int presupuestoTotal = 15;

        List<Proyecto> proyectosSeleccionados = seleccionarProyectos(proyectos, presupuestoTotal);

        // Mostrar los proyectos seleccionados
        System.out.println("Proyectos seleccionados:");
        for (Proyecto proyecto : proyectosSeleccionados) {
            System.out.println("Presupuesto: " + proyecto.presupuesto + ", Regiones: " + proyecto.regiones);
        }
    }
}
