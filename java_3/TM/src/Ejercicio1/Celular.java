package Ejercicio1;

public class Celular implements Precedable<Celular> {
   // Atributos
   private long numero;
   private Persona titular;

   public Celular(long numero, Persona titular) {
      this.numero = numero;
      this.titular = titular;
   }

   // Encapsulados
   public long getNumero() {
      return numero;
   }

   public void setNumero(long numero) {
      this.numero = numero;
   }

   public Persona getTitular() {
      return titular;
   }

   public void setTitular(Persona titular) {
      this.titular = titular;
   }

   @Override
   public int precedeA(Celular cel) {
      if (this.numero > cel.getNumero()) {
         return 1;
      } else return 0;
   }
}
