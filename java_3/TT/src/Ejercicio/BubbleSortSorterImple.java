package Ejercicio;

import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T> {

   @Override
   public void sort(T arr[], Comparator<T> c) {
      for (int i = 0; i < arr.length - 1; i++) {
         for (int j = 0; j < arr.length - 1; j++) {
            // Es más grande a la izquierda que a la derecha ?
            if (c.compare(arr[j], arr[j + 1]) > 0) {
               // Se intercambia j y j + 1
               T tmp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = tmp;
            }
         }
      }
   }

}
