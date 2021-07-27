package Ejercicio2;

public abstract class FiguraGeometrica {

   public abstract double area();
   public abstract String imprimirArea();

   public static double areaPromedio(FiguraGeometrica arr[]) {
      double sum = 0;

      for (FiguraGeometrica f : arr) {
         sum += f.area();
      }
      return sum / arr.length;
   }

   @Override
   public String toString() {
      return super.toString();
   }
}
