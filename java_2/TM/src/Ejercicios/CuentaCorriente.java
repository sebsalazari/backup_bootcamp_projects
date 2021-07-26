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
      idCuenta = "";
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
   }

   public void egreso(double egreso) {
      double nuevoSaldo = (egreso >= 0) ? egreso : 0;
      this.saldo -= nuevoSaldo;
   }

   public static void reintegro(double reintegro, CuentaCorriente cuenta) {
      cuenta.setSaldo(cuenta.getSaldo() + reintegro);
   }

   public static void transferencia(double valorTransferido, CuentaCorriente emisor, CuentaCorriente receptor) {
      emisor.setSaldo(emisor.getSaldo() - valorTransferido);
      receptor.setSaldo(receptor.getSaldo() + valorTransferido);
   }

   @Override
   public String toString() {
      return "ID: " + idCuenta + "\tSaldo: " + saldo ;
   }

}
