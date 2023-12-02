package Ejercicios_Varios;

//Maximizar número de actividades compatibles. Se tienen n actividades que
//necesitan utilizar un recurso, tal como una sala de conferencias, en exclusión
//mutua. Cada actividad i tiene asociado un tiempo de comienzo ci y un tiempo de
//finalización fi de utilización del recurso, con ci < fi. Si la actividad i es
//seleccionada se llevará a cabo durante el intervalo [ci, fi). Las actividades i y j
//son compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir,
//ci  fj o cj  fi). El problema consiste en encontrar la cantidad máxima de
//actividades compatibles entre sí.


import java.util.ArrayList;

public class Ejercicio_3 {

    static class Actividad {
        int inicio, fin;

        Actividad(int inicio, int fin) {
            this.inicio = inicio;
            this.fin = fin;
        }
    }

    public static void max_actividades(ArrayList<Actividad> actividades) {
        ArrayList<Actividad> resultado = new ArrayList<>();

        // Asegurarse de que haya al menos una actividad
        if (actividades.isEmpty()) {
            System.out.println("No hay actividades para procesar.");
            return;
        }

        // Ordenar las actividades por tiempo de finalización
        actividades.sort((a1, a2) -> Integer.compare(a1.fin, a2.fin));

        // La primera actividad siempre será seleccionada
        resultado.add(actividades.get(0));

        int tiempo_act = actividades.get(0).fin;

        // Iterar sobre las actividades restantes
        for (int i = 1; i < actividades.size(); i++) {
            Actividad act_act = actividades.get(i);

            // Si la actividad actual no se superpone con la última actividad seleccionada, seleccionarla
            if (act_act.inicio >= tiempo_act) {
                resultado.add(act_act);
                tiempo_act = act_act.fin;
            }
        }

        // Imprimir las actividades seleccionadas
        System.out.println("Actividades seleccionadas:");
        for (Actividad actividad : resultado) {
            System.out.println("Inicio: " + actividad.inicio + ", Fin: " + actividad.fin);
        }
    }

    public static void main(String[] args) {
        // Crear un conjunto de actividades para probar el algoritmo
        ArrayList<Actividad> actividades = new ArrayList<>();
        actividades.add(new Actividad(1, 3));
        actividades.add(new Actividad(2, 5));
        actividades.add(new Actividad(3, 8));
        actividades.add(new Actividad(5, 7));
        actividades.add(new Actividad(8, 10));
        actividades.add(new Actividad(9, 12));

        // Llamar al método para encontrar las actividades compatibles
        max_actividades(actividades);
    }
}
