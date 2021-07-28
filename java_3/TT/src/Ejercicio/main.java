package Ejercicio;

import java.io.IOException;
import java.util.Comparator;

public class main {

   public static void main(String[] args) throws IOException {
      testSorter();
      testFactory();
      testTimer();
   }

   public static void testSorter() {
      // Test para cada Clase de Sort implementada
      System.out.println("Test Sort");

      Integer[] arr = {1, 634, 12, 3, 8876, 4100, 45, 56, 789, 23};
      Comparator<Integer> comp = (n1, n2) -> n1 - n2;

      QuickSortSorterImple<Integer> sorter = new QuickSortSorterImple<>();
      // HeapSortSorterImple<Integer> sorter = new HeapSortSorterImple<>();
      // BubbleSortSorterImple<Integer> sorter = new BubbleSortSorterImple<>();

      sorter.sort(arr, comp);
      for (Integer x : arr) {
         System.out.print(x + " ");
      }
   }

   public static void testFactory() throws IOException {
      // Test para cada clase de sort mediante MiFactory
      System.out.println("\nTest Sort Factory");

      Integer[] arr = {1, 634, 12, 3, 8876, 4100, 45, 56, 789, 23};
      Comparator<Integer> comp = (n1, n2) -> n1 - n2;

      // QuickSortSorterImple<Integer> sorterFac = (QuickSortSorterImple<Integer>) MiFactory.getInstance("sorter");
      HeapSortSorterImple<Integer> sorterFac = (HeapSortSorterImple<Integer>) MiFactory.getInstance("sorter1");
      // BubbleSortSorterImple<Integer> sorterFac = (BubbleSortSorterImple<Integer>) MiFactory.getInstance("sorter2");
      sorterFac.sort(arr, comp);

      for (int i : arr) {
         System.out.print(i + " ");
      }
   }

   public static void testTimer() throws IOException {
      // Test para cada clase de sort mediante el Timer y evaluando los tiempos para saber cual es el algoritmo mas optimo
      System.out.println("\nTest Sort con Timer");

      Timer timer = new Timer();
      Comparator<Integer> comp = (n1, n2) -> n1 - n2;

      Integer[] arr = new Integer[100000];
      int limit = 100000;
      for (int i = 0; i < limit; i++) {
         arr[i] = limit - i;
      }

      BubbleSortSorterImple<Integer> sorterB = (BubbleSortSorterImple<Integer>) MiFactory.getInstance("sorter2");
      QuickSortSorterImple<Integer> sorterQ = (QuickSortSorterImple<Integer>) MiFactory.getInstance("sorter");
      HeapSortSorterImple<Integer> sorterH = (HeapSortSorterImple<Integer>) MiFactory.getInstance("sorter1");

      timer.start();
      sorterQ.sort(arr, comp);
      timer.stop();

      System.out.println("El tiempo transcurrido para QuickSort en milisegundos es: " + timer.elapsedTime());

      timer.start();
      sorterH.sort(arr, comp);
      timer.stop();

      System.out.println("El tiempo transcurrido para HeapSort en milisegundos es: " + timer.elapsedTime());

      timer.start();
      sorterB.sort(arr, comp);
      timer.stop();

      System.out.println("El tiempo transcurrido para Burbuja en milisegundos es: " + timer.elapsedTime());
   }

}
