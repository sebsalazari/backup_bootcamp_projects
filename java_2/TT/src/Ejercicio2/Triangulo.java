package Ejercicio2;

public class Triangulo extends FiguraGeometrica {

   // Atributos
   private double base;
   private double altura;

   // Constructor
   public Triangulo(double base, double altura) {
      this.base = base;
      this.altura = altura;
   }

   @Override
   public double area() {
      return (base * altura) / 2;
   }

   @Override
   public String imprimirArea() {
      return "El area del triangulo es: " + area();
   }
}
