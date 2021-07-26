package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class radixSort {

   static ArrayList<String> sArr = new ArrayList<>();
   static int longitud = 0;

   // Constructor de la clase
   public radixSort(int[] intArr) {

      // Se convierte a String el array y se halla la longitud maxima
      Arrays.stream(intArr).forEach(item -> {
         String newS = item + "";
         if (longitud <= newS.length())
            longitud = newS.length();
         sArr.add(newS);
      });

      // Se va pasando el array por los diferentes metodos para lograr su ordenamiento
      sArr = igualarLongitud(sArr);
      sArr = recorrerLista(sArr, longitud);

      System.out.println("\nResultado: " + sArr);
   }

   // Metodo para igualar la longitud de cada valor de la lista
   public static ArrayList<String> igualarLongitud(ArrayList<String> sArr) {
      AtomicInteger cont = new AtomicInteger();
      sArr.forEach(item -> {
         while (item.length() != longitud) {
            item = "0" + item;
            sArr.set(cont.get(), item);
         }
         cont.getAndIncrement();
      });

      return sArr;
   }

   // Metodo recursivo para recorrer la lista e ir agregando a las diferentes listas
   public static ArrayList<String> recorrerLista(ArrayList<String> sArr, int tam) {
      // Segun el algoritmo planteado, creamos las 10 listas vacias para cada digito
      ArrayList<String> L0 = new ArrayList<>();
      ArrayList<String> L1 = new ArrayList<>();
      ArrayList<String> L2 = new ArrayList<>();
      ArrayList<String> L3 = new ArrayList<>();
      ArrayList<String> L4 = new ArrayList<>();
      ArrayList<String> L5 = new ArrayList<>();
      ArrayList<String> L6 = new ArrayList<>();
      ArrayList<String> L7 = new ArrayList<>();
      ArrayList<String> L8 = new ArrayList<>();
      ArrayList<String> L9 = new ArrayList<>();

      // Array auxiliar para ir guardando las nuevas listas ordenadas
      ArrayList<String> arrAux = new ArrayList<>();
      int tamano = tam - 1;

      sArr.forEach(item -> {
         if (tamano >= 0) {
            char digito = item.charAt(tamano);
            switch (digito) {
               case '0':
                  L0.add(item);
                  break;
               case '1':
                  L1.add(item);
                  break;
               case '2':
                  L2.add(item);
                  break;
               case '3':
                  L3.add(item);
                  break;
               case '4':
                  L4.add(item);
                  break;
               case '5':
                  L5.add(item);
                  break;
               case '6':
                  L6.add(item);
                  break;
               case '7':
                  L7.add(item);
                  break;
               case '8':
                  L8.add(item);
                  break;
               case '9':
                  L9.add(item);
                  break;
               default:
                  System.out.println("No es valida");
            }
         }
      });

      arrAux.addAll(L0);
      arrAux.addAll(L1);
      arrAux.addAll(L2);
      arrAux.addAll(L3);
      arrAux.addAll(L4);
      arrAux.addAll(L5);
      arrAux.addAll(L6);
      arrAux.addAll(L7);
      arrAux.addAll(L8);
      arrAux.addAll(L9);

      if (tamano >= 0 ) {
         System.out.println("Digito " + tamano + ": " + arrAux);
         return recorrerLista(arrAux, tamano);
      }

      return sArr;
   }

}
