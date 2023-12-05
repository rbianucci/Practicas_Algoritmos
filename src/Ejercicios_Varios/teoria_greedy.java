package Ejercicios_Varios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class teoria_greedy {


    public static class Objeto{

        int peso;
        int valor;
        Objeto(int valor, int peso){
            this.valor = valor;
            this.peso = peso;
        }

        public double relacion(){
            return valor/peso;
        }

    }
    public static int cambio(int[] monedas, int valor){

        int cantidad_monedas = 0;
        int montoRestante = valor;

        for (int i = 0 ; i< monedas.length ; i++){
            if (montoRestante >= monedas[i]){
                cantidad_monedas+=1;
                montoRestante = montoRestante - monedas[i];
            }
        }
        return cantidad_monedas;
    }

    public static ArrayList<Objeto> mochila(ArrayList<Objeto> objetos, int pesoMaximo){
        ArrayList<Objeto> objetos_mochila = new ArrayList<>();
        int pesoActual = 0;
        objetos.sort(Comparator.comparingDouble(Objeto::relacion).reversed());
        while (!objetos.isEmpty() && pesoActual < pesoMaximo){
            Objeto objeto_actual = objetos.getFirst();
            if (objeto_actual.peso + pesoActual <= pesoMaximo){
                objetos_mochila.add(objetos.getFirst());
                pesoActual += objeto_actual.peso;
            }
            objetos.removeFirst();
        }
        return objetos_mochila;
    }

    public static void main(String[] args) {
        int[] monedas = {100,50,25,10,5,1};
        System.out.println("Monedas a usar " + cambio(monedas,175));

        ArrayList<Objeto> objetos = new ArrayList<>();
        objetos.add(new Objeto(10,8));  //      10/8 = 1,25
        objetos.add(new Objeto(7,6));   //      7/6 = 1,167
        objetos.add(new Objeto(5,20));  //      2/20 = 0,25
        objetos.add(new Objeto(5,1));   //      5/1 = 5

        for (Objeto objeto: mochila(objetos,20)){
            System.out.println("Objeto: " + objeto.valor + "  Peso: " + objeto.peso);
        }
    }
}
