package Ejercicio1;

public class PasswordSimple extends Password {

   /*
     Para la password simple, la expresion regular valida es que la
     contraseña ingresada tenga almenos 4 caracteres, compuesto por letras
     y minimo un digito, opcional se puede incluir mayusculas
   */

   public PasswordSimple() {
      super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$");
   }

}

