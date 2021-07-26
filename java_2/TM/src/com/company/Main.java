package com.company;

import Ejercicios.CuentaCorriente;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      System.out.println("Digita el ejercicio a ejecutar: ");

      System.out.println("<1> Ejercicio Cuenta Corriente \n<2>Ejercicio n multiplos de m \n<3>Ejercicio es primo " +
              "\n<4>Ejercicio lista n primos \n<5>Ejercicio n numeros naturales ");

      Scanner s = new Scanner(System.in);
      int opc = s.nextInt();

      switch (opc) {
         case 1:
            CuentaCorriente cue1 = new CuentaCorriente();
            CuentaCorriente cue2 = new CuentaCorriente("abc123", 5000);
            CuentaCorriente cue3 = new CuentaCorriente(cue2);

            System.out.println("Cuenta 1\t"+cue1.toString());
            System.out.println("Cuenta 2\t"+cue2.toString());
            System.out.println("Cuenta 3\t"+cue3.toString());

            // Operaciones de las cuentas
            cue1.ingreso(10000);
            cue2.egreso(4000);

            CuentaCorriente.transferencia(2500, cue3, cue2);
            CuentaCorriente.reintegro(1000, cue1);

            // Se imprime el estado de las cuentas despues de las operaciones
            System.out.println("\nNueva info de las cuentas: ");
            System.out.println("Cuenta 1\t"+cue1.toString());
            System.out.println("Cuenta 2\t"+cue2.toString());
            System.out.println("Cuenta 3\t"+cue3.toString());

            break;
         case 2:
            System.out.println("Digita el limite: ");
            int num2 = s.nextInt();
            System.out.println("Digita el multiplo: ");
            int num3 = s.nextInt();

           // Ejercicio2 eje2 = new Ejercicio2(num2, num3);
            break;
         case 3:
            System.out.println("Digita el numero: ");
            int num4 = s.nextInt();

            //Ejercicio3 eje3;
            //String mensaje = Ejercicio3.esPrimo(num4) ? num4 + " es primo" : num4 + " no es primo";

            //System.out.println(mensaje);
            break;
         case 4:
            System.out.println("Digita el numero: ");
            int num5 = s.nextInt();

            //Ejercicio4 eje4 = new Ejercicio4(num5);
            break;
         case 5:
            System.out.println("Digita el limite: ");
            int n = s.nextInt();
            System.out.println("Digita el numero de repetidos: ");
            int m = s.nextInt();
            System.out.println("Digita el numero: ");
            int d = s.nextInt();

            //Ejercicio5 eje5 = new Ejercicio5(n, m, d);
            break;

         default:
            System.out.println("Opcion no valida");
      }
   }
}
