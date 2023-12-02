package Ejercicios_Varios;


import java.util.ArrayList;
import java.util.Map;

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
public class Ejercicio_12_TERMINAR {

    class Granja_infectada{

        char nombre;

        int fecha_infeccion;

        Granja_infectada(char nombre, int fecha_infeccion){
            this.nombre = nombre;
            this.fecha_infeccion = fecha_infeccion;
        }

        public char get_nombre(){
            return this.nombre;
        }

        public int get_fecha(){
            return this.fecha_infeccion;
        }
    }
    public ArrayList<Integer> aftosa(Graph G, ArrayList<Granja_infectada> conjunto){
        ArrayList<Integer> susceptible = new ArrayList<Integer>();
        while (conjunto.size() != 0){
            Granja_infectada actual = conjunto.getFirst();
            conjunto.remove(actual);
            Map<Integer, Graph.Nodo> granjas = G.obtenerNodos();
            for (Graph.Nodo granja : granjas.values()){
                if (G.existeArista(Character.getNumericValue(actual.get_nombre()),granja.id)){
                    if (actual.get_fecha() < G.calcularCosto(Character.getNumericValue(actual.get_nombre()),granja.id)){
                        G.cambiarArista(Character.getNumericValue(actual.get_nombre()),granja.id,actual.get_fecha());
                        susceptible.add(granja.id);
                    }
                }
            }
        }
        return susceptible;
    }

    public static void main(String[] args) {
        Graph grafo = new Graph();
        grafo.insertarNodo(Character.getNumericValue('A'));
        grafo.insertarNodo(Character.getNumericValue('B'));
        grafo.insertarNodo(Character.getNumericValue('C'));
        grafo.insertarNodo(Character.getNumericValue('D'));
        grafo.insertarNodo(Character.getNumericValue('E'));
        grafo.insertarNodo(Character.getNumericValue('F'));

        grafo.insertarArista(Character.getNumericValue('A'),Character.getNumericValue('E'),5);
        grafo.insertarArista(Character.getNumericValue('B'),Character.getNumericValue('A'),7);
        grafo.insertarArista(Character.getNumericValue('C'),Character.getNumericValue('E'),5);


    }
}
