package Ejercicios;

/*
   Sebastian Salazar
   Ejercicio 1: Cuenta corriente
 */

public class CuentaCorriente {

   // Atributos de la clase
   private String idCuenta;
   private double saldo;

   // Constructores de la clase
   public CuentaCorriente() {
      idCuenta = "xxx-xxxx-xxx";
      saldo = 0;
   }

   public CuentaCorriente(String idCuenta, int saldo) {
      this.idCuenta = idCuenta;
      this.saldo = saldo;
   }

   public CuentaCorriente(CuentaCorriente cuenta) {
      this.idCuenta = cuenta.idCuenta;
      this.saldo = cuenta.saldo;
   }

   // Encapsulamiento
   public String getIdCuenta() {
      return idCuenta;
   }

   public void setIdCuenta(String idCuenta) {
      this.idCuenta = idCuenta;
   }

   public double getSaldo() {
      return saldo;
   }

   public void setSaldo(double saldo) {
      this.saldo = saldo;
   }

   // Metodos de la clase
   public void ingreso(double ingreso) {
      double nuevoSaldo = (ingreso >= 0) ? ingreso : 0;
      this.saldo += nuevoSaldo;
      System.out.println("Ingreso exitoso!, nuevo saldo en la cuenta: "+this.saldo);
   }

   public void egreso(double egreso) {
      double nuevoSaldo = (egreso >= 0) ? egreso : 0;
      if (this.saldo >= nuevoSaldo) {
         this.saldo -= nuevoSaldo;
         System.out.println("Egreso exitoso!, nuevo saldo en la cuenta: "+this.saldo);
      }
      else
         System.out.println("No se pudo realizar la transaccion, NO hay suficientes fondos en la cuenta");
   }

   public static void reintegro(double reintegro, CuentaCorriente cuenta) {
      cuenta.setSaldo(cuenta.getSaldo() + reintegro);
      System.out.println("Reintegro con exito!, nuevo saldo en la cuenta: "+cuenta.getSaldo());
   }

   public static void transferencia(double valorTransferido, CuentaCorriente emisor, CuentaCorriente receptor) {
      if (emisor.getSaldo() >= valorTransferido) {
         emisor.setSaldo(emisor.getSaldo() - valorTransferido);
         receptor.setSaldo(receptor.getSaldo() + valorTransferido);
         System.out.println("Transferencia con exito!, nuevo saldo en la cuenta: "+emisor.getSaldo());
      } else
         System.out.println("No se pudo realizar la transferencia, NO hay suficientes fondos en la cuenta");
   }

   @Override
   public String toString() {
      return "ID: " + idCuenta +
              "\tSaldo: " + saldo;
   }

}
