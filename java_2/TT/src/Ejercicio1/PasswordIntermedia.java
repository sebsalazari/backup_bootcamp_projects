package Ejercicio1;

public class PasswordIntermedia extends Password {

   /*
       Para la password intermedia, la expresion regular valida que la
       contraseña ingresada tenga minimo 6 caracteres, compuesto por almenos
       una minuscula, una mayuscula y un numero
   */

   public PasswordIntermedia() {
      super("^.*(?=.{6,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$");
   }
}
