package ejercicios;

public class Ejercicio2 {

    /*
     * Programa que muestra los primeros n multiplos de m
     */

    public Ejercicio2(int n, int multiplo) {
        multiplos(n, multiplo);
    }

    public static void multiplos(int n, int multiplo) {
        for (int i = 0; i <= n; i++) {
            System.out.println(i*multiplo);
        }
    }
}
