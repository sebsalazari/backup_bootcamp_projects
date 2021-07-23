package ejercicios;

public class Ejercicio3 {

    /*
     * Programa que muestra si un numero es primo
     */

    public static boolean esPrimo(int n) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != n)) {
            if (n % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }
}
