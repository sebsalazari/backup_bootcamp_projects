package ejercicios;

public class Ejercicio4 {
    /*
     * Programa que muestra la lista de los n numeros primos
     */

    public Ejercicio4(int n) {
        listaPrimos(n);
    }

    public static void listaPrimos(int n) {
        for (int i = 1; i <= n; i++) {
            if (esPrimo(i)){
                System.out.println(i);
            }
        }
    }

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
