package Ejercicio1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

   private String password;
   private String regex;

   public Password(String regex) {
      this.regex = regex;
   }

   // Metodo que evalua que la contraseña hubiera pasado la validacion, en caso contrario arroja la excepcion
   public void setValue(String password) throws Exception {
      if (testRegex(password)) {
         this.password = password;
      } else {
         throw new Exception("La contraseña no cumple con la seguridad");
      }
   }

   // Metodo para validar la contraseña, respecto al regex
   public boolean testRegex(String password) {
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(password);
      return matcher.find();
   }

}
