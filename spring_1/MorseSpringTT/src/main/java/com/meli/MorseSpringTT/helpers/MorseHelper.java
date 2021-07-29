package com.meli.MorseSpringTT.helpers;

import java.util.HashMap;

public class MorseHelper {

   // Funcion para convertir de morse a texto
   public static String toText(String codigo) {
      String texto = "";
      String[] palabras = codigo.split("   "); // tres espacios

      HashMap<String, Character> equivalencias = equivalencias();

      try {
         for (String w : palabras) {
            String[] letras = w.split(" "); // Un espacio para separar por caracter

            for (String clave : letras) {
               texto += equivalencias.get(clave).toString();
            }
            texto += " ";
         }
      } catch (Exception e) {
         System.out.println("Error en la traducción = " + e);
         texto = "Se decodifico hasta este caracter: " + texto;
      }

      return texto;
   }

   // Se crea un diccionario que contiene la clave morse y su respectivo valor en el alfabeto español
   public static HashMap<String, Character> equivalencias() {
      HashMap<String, Character> alfabetoMorse = new HashMap();
      alfabetoMorse.put(".-", 'A');
      alfabetoMorse.put("-...", 'B');
      alfabetoMorse.put("-.-.", 'C');
      alfabetoMorse.put("-..", 'D');
      alfabetoMorse.put(".", 'E');
      alfabetoMorse.put("..-.", 'F');
      alfabetoMorse.put("--.", 'G');
      alfabetoMorse.put("....", 'H');
      alfabetoMorse.put("..", 'I');
      alfabetoMorse.put(".---", 'J');
      alfabetoMorse.put("-.-", 'K');
      alfabetoMorse.put(".-..", 'L');
      alfabetoMorse.put("--", 'M');
      alfabetoMorse.put("-.", 'N');
      alfabetoMorse.put("---", 'O');
      alfabetoMorse.put(".--.", 'P');
      alfabetoMorse.put("--.-", 'Q');
      alfabetoMorse.put(".-.", 'R');
      alfabetoMorse.put("...", 'S');
      alfabetoMorse.put("-", 'T');
      alfabetoMorse.put("..-", 'U');
      alfabetoMorse.put("...-", 'V');
      alfabetoMorse.put(".--", 'W');
      alfabetoMorse.put("-..-", 'X');
      alfabetoMorse.put("-.--", 'Y');
      alfabetoMorse.put("--..", 'Z');
      alfabetoMorse.put("-----", '0');
      alfabetoMorse.put(".----", '1');
      alfabetoMorse.put("..---", '2');
      alfabetoMorse.put("...--", '3');
      alfabetoMorse.put("....-", '4');
      alfabetoMorse.put(".....", '5');
      alfabetoMorse.put("-....", '6');
      alfabetoMorse.put("--...", '7');
      alfabetoMorse.put("---..", '8');
      alfabetoMorse.put("----.", '9');

      return alfabetoMorse;
   }

}
