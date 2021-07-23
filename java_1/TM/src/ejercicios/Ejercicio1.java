package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

    /*
     * Programa que muestra los primeros n numeros pares
     */

    public Ejercicio1(int numero) {
        numerosPares(numero);
    }

    public static void numerosPares(int n) {
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println("Par: " + i);
            }
        }
    }
}
