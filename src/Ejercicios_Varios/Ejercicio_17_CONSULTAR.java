package Ejercicios_Varios;

// Bolas más pesadas. Se tienen n bolas de igual tamaño, todas ellas de igual peso
// salvo dos más pesadas, que a su vez pesan lo mismo. Como único medio para
// dar con dichas bolas se dispone de una balanza de 2 platos. Determinar cuáles
// son dichas bolas, con el mínimo posible de pesadas en la balanza

// BUSQUEDA BINARIA - SIMILAR AL DE LA MONEDA

import java.util.Arrays;

public class Ejercicio_17_CONSULTAR {

    static class Bola {
        int peso;
        Bola(int peso) {
            this.peso = peso;
        }
    }

    public static Bola[] encontrarBolasMasPesadas(Bola[] bolas) {
        int n = bolas.length;

        // Caso base
        if (n == 2) {
            return bolas;
        }

        int tercio = n / 3;

        Bola[] izquierda = Arrays.copyOfRange(bolas, 0, tercio);
        Bola[] centro = Arrays.copyOfRange(bolas, tercio+1, n-tercio);
        Bola[] derecha = Arrays.copyOfRange(bolas, n-tercio+1, n);
        int pesoIzquierda = pesar(izquierda);
        int pesoCentro = pesar(centro);
        int pesoDerecha = pesar(derecha);

        // Comparar los pesos
        if (pesoIzquierda == pesoCentro && pesoCentro == pesoDerecha) {
            // Ambas bolas más pesadas están en la mitad restante
            return encontrarBolasMasPesadas(izquierda);
        } else if (pesoIzquierda == pesoCentro) {
            // Las bolas más pesadas están en la del la derecha
            return encontrarBolasMasPesadas(izquierda);
        } else {
            // Las bolas más pesadas están en la mitad derecha
            return encontrarBolasMasPesadas(derecha);
        }
    }

    public static int pesar(Bola[] bolas) {
        int pesoTotal = 0;
        for (Bola bola : bolas) {
            pesoTotal += bola.peso;
        }
        return pesoTotal;
    }

    public static void main(String[] args) {
        Bola[] bolas = {
                new Bola(3),
                new Bola(1),
                new Bola(5),
                new Bola(2)
        };

        Bola[] bolasMasPesadas = encontrarBolasMasPesadas(bolas);
        System.out.println("Las bolas más pesadas son: " +
                bolasMasPesadas[0].peso + " y " + bolasMasPesadas[1].peso);
    }
}

