package Ejercicio1;

public class SortUtil {

   public static <T> void ordenar(Precedable<T> arr[]) {
      for (int i = 0; i < arr.length - 1; i++) {
         for (int j = 1; j < arr.length; j++) {
            if (arr[j - 1].precedeA((T) arr[j]) > 0) {
               intercambio(arr, j - 1, j);
            }
         }
      }
   }

   public static <T> void intercambio(Precedable<T> arr[], int i, int j) {
      // Cambiando los elementos de pocision
      Precedable aux;

      aux = arr[i];
      arr[i] = arr[j];
      arr[j] = aux;
   }
}
