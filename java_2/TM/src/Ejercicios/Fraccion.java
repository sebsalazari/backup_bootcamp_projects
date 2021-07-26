package Ejercicios;

public class Fraccion {
   // Atributos
   private int numerador;
   private int denominador;

   // Constructores
   public Fraccion(){
      this.numerador = 1;
      this.denominador = 1;
   }

   public Fraccion(int num, int den){
      this.numerador = num;
      this.denominador = den;
   }

   public Fraccion(double num, double den){
      this.numerador = (int) num;
      this.denominador = (int) den;
   }

   // Encapsulamiento
   public int getNumerador() {
      return numerador;
   }

   public void setNumerador(int numerador) {
      this.numerador = numerador;
   }

   public int getDenominador() {
      return denominador;
   }

   public void setDenominador(int denominador) {
      this.denominador = denominador;
   }

   // Metodos
   public Fraccion sumar(Fraccion f1, Fraccion f2){
      Fraccion resultado = new Fraccion();
      resultado.numerador = (f1.numerador* f2.denominador)+(f1.denominador*f2.numerador);
      resultado.denominador = (f1.denominador*f2.denominador);

      return resultado;
   }

   public Fraccion restar(Fraccion f1, Fraccion f2){
      Fraccion resultado = new Fraccion();
      resultado.numerador = (f1.numerador* f2.denominador)-(f1.denominador*f2.numerador);
      resultado.denominador = (f1.denominador*f2.denominador);

      return resultado;
   }

   public Fraccion multiplicar(Fraccion f1, Fraccion f2){
      Fraccion resultado = new Fraccion();
      resultado.numerador = (f1.numerador* f2.numerador);
      resultado.denominador = (f1.denominador*f2.denominador);

      return resultado;
   }

   public Fraccion dividir(Fraccion f1, Fraccion f2){
      Fraccion resultado = new Fraccion();
      resultado.numerador = (f1.numerador* f2.denominador);
      resultado.denominador = (f1.denominador*f2.numerador);

      return resultado;
   }

   // ToString
   public String toString(String tipo, int numerador, int denominador) {
      return "Resultado operación "+tipo+ " es: " + numerador + "/" + denominador
              + " = "+ (Double.parseDouble(String.valueOf(numerador))/ Double.parseDouble(String.valueOf(denominador)));
   }


}
