package Ejercicio2;

public class Rectangulo extends FiguraGeometrica {

   // Atributos
   private double base;
   private double altura;

   // Constructor
   public Rectangulo(double base, double altura) {
      this.base = base;
      this.altura = altura;
   }

   @Override
   public double area() {
      return base * altura;
   }

   @Override
   public String imprimirArea() {
      return "El area del rectangulo es: " + area();
   }
}
