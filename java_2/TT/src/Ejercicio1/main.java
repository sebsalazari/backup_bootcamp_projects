package Ejercicio1;

public class main {

   public static void main(String[] args) {
      String password = "SebasMeli87";

      try {
         PasswordSimple passSimple = new PasswordSimple();
         passSimple.setValue(password);
         System.out.println("Password Simple Valida");

      } catch (Exception e) {
         System.out.println(e.getMessage());
      }

      try {
         PasswordIntermedia passIntermedia = new PasswordIntermedia();
         passIntermedia.setValue(password);
         System.out.println("Password Intermedia Valida");

      } catch (Exception e) {
         System.out.println(e.getMessage());
      }

      try {
         PasswordFuerte passFuerte = new PasswordFuerte();
         passFuerte.setValue(password);
         System.out.println("Password Fuerte Valida");

      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
}
