package Ejercicios_Varios;


import java.util.ArrayList;
import java.util.Map;
import java.util.*;

// Epidemia de aftosa. Varios países están sufriendo una epidemia de fiebre aftosa.
//La enfermedad se transmite por contacto directo o indirecto con animales enfermos
//y es altamente contagiosa. Para controlar la infección, las autoridades sanitarias
//han recabado información de todas las granjas existentes, que llamaremos G =
//(g1, g2, ..., gn). También se conocen las compras de animales que han tenido
//lugar entre las distintas granjas, y la fecha en la que tuvo lugar cada una. Hasta
//el momento se ha detectado el virus en un conjunto reducido de granjas I.
//Las autoridades pretenden encontrar todas las granjas susceptibles de estar
//infectadas, para declararlas en cuarentena. Hay que tener en cuenta que una
//granja es susceptible de padecer la enfermedad si ha comprado animales de una
//granja infectada, o de una granja susceptible de tener la enfermedad (después de
//que haya podido ser infectada).
//Ejemplo:
//n = 6; G = {A, B, C, D, E, F}; I = {A}
//Granja que vende E D B C F E B F A C
//Granja que compra B A A D D C F E E B
//Nro. De animales 12 7 23 8 9 43 32 6 14 15
//Fecha (nro de
//semana)
//6 2 7 5 5 3 6 6 5 6
// Resolver el problema de determinar las granjas que deben ser declaradas en
//cuarentena.


// BASICAMENTE LO QUE HAY QUE HACER ES RECORRER EL GRAFO DESDE CADA INFECTADO Y VER SI LA ARISTA QUE LO CONECTA
// AL OTRO VERTICE TIENE UNA FECHA SUPERIOR A LA DEL INFECTADO,

public class Ejercicio_12_TERMINAR {

    static class NodoInfectado {
        Graph.Nodo nodo;
        int fecha;

        NodoInfectado(Graph.Nodo nodo, int fecha) {
            this.nodo = nodo;
            this.fecha = fecha;
        }

        public Graph.Nodo getNodo() {
            return nodo;
        }

        public int getFecha() {
            return fecha;
        }
    }

    // Método para propagar la infección
    public static List<Graph.Nodo> aftasa(Graph grafo, List<NodoInfectado> infectados) {
        List<Graph.Nodo> cuarentena = new ArrayList<>();
        while (!infectados.isEmpty()){
            NodoInfectado infectado = infectados.getFirst();
            infectados.removeFirst();
            for (Graph.Nodo nodo: grafo.obtenerNodos().values()){
                if (grafo.existeArista(infectado.getNodo().id,nodo.id)){
                    if (infectado.getFecha() <= grafo.calcularCosto(infectado.getNodo().id, nodo.id)){
                        cuarentena.add(nodo);
                    }
                }
            }
        }
        return cuarentena;
    }

    public static void main(String[] args) {
        Graph grafo = new Graph();
        int A = (int)'A';
        int B = (int)'B';
        int C = (int)'C';
        int D = (int)'D';
        int E = (int)'E';
        int F = (int)'F';
        grafo.insertarNodo(A);
        grafo.insertarNodo(B);
        grafo.insertarNodo(C);
        grafo.insertarNodo(D);
        grafo.insertarNodo(E);
        grafo.insertarNodo(F);

        System.out.println("CONVERTIDO: " + A);
        System.out.println("desconvertido: " + (char)A);

        grafo.insertarArista(E,B,6);
        grafo.insertarArista(D,A,2);
        grafo.insertarArista(B,A,7);
        grafo.insertarArista(C,D,5);
        grafo.insertarArista(F,D,5);
        grafo.insertarArista(E,C,3);
        grafo.insertarArista(B,F,6);
        grafo.insertarArista(F,E,6);
        grafo.insertarArista(A,E,5);
        grafo.insertarArista(C,B,6);

        List<NodoInfectado> infectados = new ArrayList<>();
        infectados.add(new NodoInfectado(grafo.obtenerNodoPorId((char)A), 5));

        for (Graph.Nodo nodo : aftasa(grafo, infectados)){
            System.out.println((char)nodo.id);
        }
    }
}
