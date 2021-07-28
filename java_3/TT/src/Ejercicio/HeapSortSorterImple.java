package Ejercicio;

import java.util.Comparator;

public class HeapSortSorterImple<T> implements Sorter<T> {
   /* El heap sort es un algoritmo en el se encuentra siempre el mayor elemento que es la raiz
   * luego se va intercambiando por el ultimo elemento del array y se vuelve a reacomodar el heap */

   @Override
   public void sort(T arr[], Comparator<T> c) {
      int n = arr.length;

      // Construye el montón máximo
      for (int i = n / 2 - 1; i >= 0; i--) {
         heapify(arr, n, i, c);
      }

      // Heap sort
      for (int i = n - 1; i >= 0; i--) {
         T temp = arr[0];
         arr[0] = arr[i];
         arr[i] = temp;

         // Amontona el elemento raiz
         heapify(arr, i, 0, c);
      }
   }

   public void heapify(T arr[], int n, int i, Comparator<T> c) {
      // Encuentra el valor más grande entre raíz, hijo izquierdo y hijo derecho
      int largest = i;
      int l = 2 * i + 1;
      int r = 2 * i + 2;

      if (l < n && c.compare(arr[l], arr[largest]) > 0)
         largest = l;

      if (r < n && c.compare(arr[r], arr[largest]) > 0)
         largest = r;

      // Intercambia y continúa apilando si la raíz no es la más grande
      if (largest != i) {
         T swap = arr[i];
         arr[i] = arr[largest];
         arr[largest] = swap;

         heapify(arr, n, largest, c);
      }
   }

   /* Funcion para imprimir el array ya ordenado */
   public void printArray(T[] arr) {
      int n = arr.length;
      for (T j : arr) System.out.print(j + " ");
      System.out.println();
   }

}
