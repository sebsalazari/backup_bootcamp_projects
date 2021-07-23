package ejercicios;

public class Ejercicio5 {

    /*
     * Programa que muestra los n naturales donde se repite m veces el numero d
     */

    public Ejercicio5(int n, int m, int d) {
        listarNaturales(n, m, d);
    }

    public static void listarNaturales(int n, int m, int d) {
        int totalNum = 0, countm = 0, i = 1, num = 1;
        while (totalNum != n) {
            num = i;
            while (num != 0) {
                if (num % 10 == d) countm++;
                num = num / 10;
            }
            if (countm >= m) {
                System.out.println(i);
                totalNum++;
            }
            countm = 0;
            i++;
        }
    }
}
