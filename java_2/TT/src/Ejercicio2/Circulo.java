package Ejercicio2;

public class Circulo extends FiguraGeometrica {

   // Atributos
   private double radio;

   public Circulo(int r) {
      this.radio = r;
   }

   @Override
   public double area() {
      return Math.PI * Math.pow(radio, 2);
   }

   @Override
   public String imprimirArea() {
      return "El area del circulo es: " + area();
   }
}

