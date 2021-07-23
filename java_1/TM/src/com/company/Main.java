package com.company;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Digita el ejercicio a ejecutar: ");

        System.out.println("<1> Ejercicio pares \n<2>Ejercicio n multiplos de m \n<3>Ejercicio es primo " +
                "\n<4>Ejercicio lista n primos \n<5>Ejercicio 5 ");

        Scanner s = new Scanner(System.in);
        int opc = s.nextInt();

        switch (opc) {
            case 1:
                System.out.println("Digita el limite de n pares: ");
                int num1 = s.nextInt();

                Ejercicio1 eje1 = new Ejercicio1(num1);
                break;
            case 2:
                System.out.println("Digita el limite: ");
                int num2 = s.nextInt();
                System.out.println("Digita el multiplo: ");
                int num3 = s.nextInt();

                Ejercicio2 eje2 = new Ejercicio2(num2, num3);
                break;
            case 3:
                System.out.println("Digita el numero: ");
                int num4 = s.nextInt();

                Ejercicio3 eje3;
                String mensaje = Ejercicio3.esPrimo(num4) ? num4 + " es primo" : num4 + " no es primo";

                System.out.println(mensaje);
                break;
            case 4:
                System.out.println("Digita el numero: ");
                int num5 = s.nextInt();

                Ejercicio4 eje4 = new Ejercicio4(num5);
                break;
            case 5:
                System.out.println("Digita el limite: ");
                int n = s.nextInt();
                System.out.println("Digita el numero de repetidos: ");
                int m = s.nextInt();
                System.out.println("Digita el numero: ");
                int d = s.nextInt();

                break;

            default:
                System.out.println("Opcion no valida");
        }
    }
}
