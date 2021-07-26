package Ejercicios;

public class StringUtil {

   // Agregar caracteres a la derecha
   public static String rpad(String s, char c, int n) {
      StringBuilder salida = new StringBuilder(s);
      while (salida.length() != n) {
         salida.append(c);
      }
      return salida.toString();
   }

   // Retorna la cadena sin espacios a la izquierda
   public static String ltrim(String s) {
      int cont = 0;
      String salida = s;
      while (salida.charAt(0) == ' ') {
         if (salida.charAt(cont) == ' ') {
            salida = salida.substring(cont + 1);
         }
      }
      return salida;
   }

   // Retorna la cadena sin espacios a la derecha
   public static String rtrim(String s) {
      String salida = s;
      int lon = salida.length() - 1;
      while (salida.charAt(lon) == ' ') {
         salida = salida.substring(0, lon--);
      }
      return salida;
   }

   // Retorna la cadena sin espacios a la izquierda y derecha
   public static String trim(String s) {
      String izq = ltrim(s);
      String der = rtrim(izq);

      return der;
   }

   // Retorna la posición de la n-ésima ocurrencia del carácter c dentro de s, o -1 si s no contiene a c
   public static int indexOfN(String s, char c, int n) {
      int lon = 0, cont = 0, resul = 0;
      if (s.contains(c + "")) {
         while (s.charAt(lon) != c || cont != n) {
            s = s.substring(lon + 1);
            if (s.charAt(lon) == c) cont++;
            resul++;
         }
      } else
         System.out.println("El caracter no existe en la cadena");

      return resul;
   }
}
