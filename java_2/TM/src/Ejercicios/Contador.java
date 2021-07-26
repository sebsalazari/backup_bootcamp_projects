package Ejercicios;

public class Contador {

   private int valor;

   // Constructores
   public Contador() {
      valor = 0;
   }

   public Contador(int valor) {
      this.valor = valor;
   }

   public Contador(Contador con) {
      this.valor = con.valor;
   }

   // Metodos encapsulados
   public int getValor() {
      return valor;
   }

   public void setValor(int valor) {
      this.valor = valor;
   }

   // Metodos
   public void incrementar() {
      valor++;
   }

   public void incrementar(int valorIncremento) {
      valor += valorIncremento;
   }

   public void decrementar() {
      valor--;
   }

   public void decrementar(int valorDecrementado) {
      valor -= valorDecrementado;
   }


   @Override
   public String toString() {
      return "Valor Contador: " + valor ;
   }
}
