package com.company;

import Ejercicios.*;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      System.out.println("Digita el ejercicio a ejecutar: ");

      System.out.println("<1> Ejercicio Cuenta Corriente \n<2> Ejercicio Contador \n<3> Ejercicio libros " +
              "\n<4> Ejercicio fracciones \n<5> Ejercicio Fechas \n<6> Ejercicio StringUtil");

      Scanner s = new Scanner(System.in);
      int opc = s.nextInt();

      switch (opc) {
         case 1:
            CuentaCorriente cue1 = new CuentaCorriente();
            CuentaCorriente cue2 = new CuentaCorriente("abc123", 5000);
            CuentaCorriente cue3 = new CuentaCorriente(cue2);

            System.out.println("Cuenta 1\t" + cue1.toString());
            System.out.println("Cuenta 2\t" + cue2.toString());
            System.out.println("Cuenta 3\t" + cue3.toString());

            // Operaciones de las cuentas
            System.out.println("\nOPERACIONES DE LAS CUENTAS");
            cue1.ingreso(10000);
            cue2.egreso(4000);

            CuentaCorriente.transferencia(2500, cue3, cue2);
            CuentaCorriente.reintegro(1000, cue1);

            cue2.egreso(20000);

            // Se imprime el estado de las cuentas despues de las operaciones
            System.out.println("\nNueva info de las cuentas: ");
            System.out.println("Cuenta 1\t" + cue1.toString());
            System.out.println("Cuenta 2\t" + cue2.toString());
            System.out.println("Cuenta 3\t" + cue3.toString());

            break;
         case 2:
            Contador con1 = new Contador();
            Contador con2 = new Contador(50);
            Contador con3 = new Contador(con2);

            System.out.println("Contador 1: " + con1.toString());
            System.out.println("Contador 2: " + con2.toString());
            System.out.println("Contador 3: " + con3.toString());

            // Operaciones de los contadores
            con1.incrementar();
            con2.decrementar();
            con3.incrementar(50);

            con2.decrementar(10);
            con1.incrementar(15);

            // Info de los contadores despues de las operaciones
            System.out.println("\nNuevo valor de los contadores: ");
            System.out.println("Contador 1: " + con1.toString());
            System.out.println("Contador 2: " + con2.toString());
            System.out.println("Contador 3: " + con3.toString());

            break;
         case 3:
            Libro lib1 = new Libro();
            Libro lib2 = new Libro("Cien años de soledad", "Gabriel Garcia Marquez",
                    "123-abc-789", true);
            Libro lib3 = new Libro("Satanas", "Mario Mendoza", "456-xzc-098", false);
            Libro lib4 = new Libro("El principito", "Antoine de Saint-Exupéry", "031-yjk-997", true);

            // Listar el inventario de libros
            System.out.println("INVENTARIO");
            System.out.println(lib1.toString());
            System.out.println(lib2.toString());
            System.out.println(lib3.toString());
            System.out.println(lib4.toString());

            // Prestamos y devoluciones
            System.out.println();
            Libro.prestamo(lib2);
            Libro.devolucion(lib3);
            Libro.devolucion(lib4);
            Libro.prestamo(lib2);

            // Listar los libros despues de efectuar prestamos y devoluciones
            System.out.println("\nINVENTARIO FIN DE MES");
            System.out.println(lib1.toString());
            System.out.println(lib2.toString());
            System.out.println(lib3.toString());
            System.out.println(lib4.toString());

            break;
         case 4:
            Fraccion f1 = new Fraccion(7, 3);
            Fraccion f2 = new Fraccion(2.45, 9);

            Fraccion resultado = new Fraccion();

            // Suma
            resultado = resultado.sumar(f1, f2);
            System.out.println(resultado.toString("Suma",
                    resultado.getNumerador(), resultado.getDenominador()));

            //Resta
            resultado = resultado.restar(f1, f2);
            System.out.println(resultado.toString("Resta",
                    resultado.getNumerador(), resultado.getDenominador()));

            //Producto
            resultado = resultado.multiplicar(f1, f2);
            System.out.println(resultado.toString("Multiplicacion",
                    resultado.getNumerador(), resultado.getDenominador()));

            //Division
            resultado = resultado.dividir(f1, f2);
            System.out.println(resultado.toString("Division",
                    resultado.getNumerador(), resultado.getDenominador()));

            break;
         case 5:
            // Constructor fecha actual
            Fecha fecha1 = new Fecha();
            // COnstructor se le pasa la fecha en parametros
            Fecha fecha2 = new Fecha(20, 9, 2020);
            Fecha fecha3 = new Fecha(45, 9, 2021);

            // Validando la fecha
            System.out.println(fecha2.imprimirValidacion(fecha2));

            // Agregando un dia a la fecha
            fecha2 = Fecha.agregarDia(fecha2);

            // Volviendo a validar la fecha
            System.out.println("Nueva fecha -> "+fecha2.imprimirValidacion(fecha2));

            // Otra fecha
            System.out.println(fecha3.imprimirValidacion(fecha3));

            break;

         case 6:
            System.out.println(StringUtil.rpad("45", '0', 6));
            System.out.println(StringUtil.ltrim("      IT Bootcamp"));
            System.out.println(StringUtil.rtrim("Mercado Libre     "));
            System.out.println(StringUtil.trim("     Sebastian Sal      "));
            System.out.println(StringUtil.indexOfN("John|Paul|George|Ringo", '|', 2));

            break;
         default:
            System.out.println("Opcion no valida");
      }
   }
}
