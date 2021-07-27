package Ejercicio1;

public class PasswordFuerte extends Password {

   /*
      Similar a la password intermedia, pero  ahora la expresion regular valida
      que la contraseña ingresada tenga minimo 8 caracteres, compuesto por almenos
      una minuscula, una mayuscula, un numero y caracter especial de este conjunto (@#$%^&+=)
   */

   public PasswordFuerte() {
      super("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
   }
}
