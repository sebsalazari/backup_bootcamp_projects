package Ejercicio2;

public class main {

   public static void main(String[] args) {
      FiguraGeometrica arr[] = new FiguraGeometrica[3];
      arr[0] = new Circulo(2);
      arr[1] = new Rectangulo(8, 6);
      arr[2] = new Triangulo(4, 7);

      for (FiguraGeometrica fg : arr) {
         System.out.println(fg.imprimirArea());
      }

      double ap = FiguraGeometrica.areaPromedio(arr);
      System.out.println("\nEl area promedio de las figuras es: "+ ap);
   }
}
