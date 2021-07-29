package com.meli.demo1.helpers;

public class Romanos {

   /* Funcion principal, que va subdividiendo el numero para hallar sus miles, centenas, decenas, etc
    * esta limitado hasta el numero 4000, un numero mayor se respondera con un mensaje*/

   public static String convertToRomano(int number) {
      int miles = number / 1000;
      int centenas = (number - miles * 1000) / 100;
      int decenas = (number - miles * 1000 - centenas * 100) / 10;
      int unidades = number - decenas * 10 - centenas * 100 - miles * 1000;

      String roman = "";

      if (number >= 4000)
         return "Dificultades en Roma, ingresa un numero menor a 4000";

      // Se añade una M(1000) por cada milesima encontrada hasta 3000
      if (miles < 4)
         for (int i = 0; i < miles; i++)
            roman += "M";

      /* Para las otras unidades se llama al metodo que ira dividiendo el numero
         y se pasa las unidades romanas que corresponden a esa unidad decimal */
      roman += divisionRomano(centenas, "M", "D", "C");
      roman += divisionRomano(decenas, "C", "L", "X");
      roman += divisionRomano(unidades, "X", "V", "I");

      return roman;
   }

   public static String divisionRomano(int number, String big, String medium, String small) {

      String roman = "";
      if (number < 4)
         for (int i = 0; i < number; i++)
            roman += small;

      if (number == 4)
         roman += small + medium;

      if (number >= 5 && number < 9) {
         roman += medium;
         for (int i = 0; i < number - 5; i++)
            roman += small;
      }

      if (number == 9)
         roman += small + big;

      return roman;
   }

}
