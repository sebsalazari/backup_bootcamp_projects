package com.company;

import Ejercicios.Contador;
import Ejercicios.CuentaCorriente;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      System.out.println("Digita el ejercicio a ejecutar: ");

      System.out.println("<1> Ejercicio Cuenta Corriente \n<2> Ejercicio Contador \n<3>Ejercicio es primo " +
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
            Contador con1 = new Contador();
            Contador con2 = new Contador(50);
            Contador con3 = new Contador(con2);

            System.out.println("Contador 1: "+ con1.toString());
            System.out.println("Contador 2: "+ con2.toString());
            System.out.println("Contador 3: "+ con3.toString());

            // Operaciones de los contadores
            con1.incrementar();
            con2.decrementar();
            con3.incrementar(50);

            con2.decrementar(10);
            con1.incrementar(15);

            // Info de los contadores despues de las operaciones
            System.out.println("\nNuevo valor de los contadores: ");
            System.out.println("Contador 1: "+ con1.toString());
            System.out.println("Contador 2: "+ con2.toString());
            System.out.println("Contador 3: "+ con3.toString());

            break;
         case 3:

            break;
         case 4:

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
