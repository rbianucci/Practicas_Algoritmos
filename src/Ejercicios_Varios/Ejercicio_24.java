package Ejercicios_Varios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejercicio_24 {

    static class Producto {
        String nombre;
        int puntos;
        int stock;

        public Producto(String nombre, int puntos, int stock) {
            this.nombre = nombre;
            this.puntos = puntos;
            this.stock = stock;
        }
    }

    public static List<Producto> obtenerProductosOptimos(List<Producto> catalogo, int puntosAcumulados) {
        catalogo.sort(Comparator.comparingInt(producto -> -producto.puntos));

        List<Producto> productosOptimos = new ArrayList<>();
        int puntosRestantes = puntosAcumulados;

        for (Producto producto : catalogo) {
            while (puntosRestantes >= producto.puntos && producto.stock > 0) {
                productosOptimos.add(producto);
                puntosRestantes -= producto.puntos;
                producto.stock--;
            }
        }
        return productosOptimos;
    }

    public static void main(String[] args) {
        List<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto("Producto A", 5, 10));
        catalogo.add(new Producto("Producto B", 8, 7));
        catalogo.add(new Producto("Producto C", 12, 5));
        catalogo.add(new Producto("Producto D", 3, 15));

        int puntosAcumulados = 30;

        List<Producto> productosOptimos = obtenerProductosOptimos(catalogo, puntosAcumulados);

        System.out.println("Productos retirados:");
        for (Producto producto : productosOptimos) {
            System.out.println(producto.nombre);
        }
    }
}

