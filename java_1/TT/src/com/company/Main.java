package com.company;

public class Main {

   public static void main(String[] args) {
      int [] arr = {1234, 666, 3425, 13, 5, 999, 1401, 456, 73, 56, 98, 2511, 8, 128, 7730};

      // Solo se instancia el objeto y dentro del cosntructor se arroja el resultadp
      radixSort rs = new radixSort(arr);
   }
}
