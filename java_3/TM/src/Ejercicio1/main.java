package Ejercicio1;

public class main {

   public static void main(String[] args) {
      System.out.println("PERSONAS");
      Persona p1 = new Persona("Sebas Salazar", 10074);
      Persona p2 = new Persona("Jose Perez", 12345);
      Persona p3 = new Persona("Edgar Ibañez", 20781);
      Persona p4 = new Persona("Ana Acosta", 11389);
      Persona p5 = new Persona("Mariana Velez", 17903);

      Persona[] arr = {p1, p2, p3, p4, p5};

      SortUtil.ordenar(arr);
      for (Persona per : arr) {
         System.out.println("Nombre: " + per.getNombre());
         System.out.println("DNI: " + per.getDni());
      }

      System.out.println("\nCELULAR");

      Celular c1 = new Celular(322884280, p2);
      Celular c2 = new Celular(300601980, p1);
      Celular c3 = new Celular(301980076, p5);
      Celular c4 = new Celular(314404895, p4);
      Celular c5 = new Celular(311285590, p3);

      Celular[] arrC = {c1, c2, c3, c4, c5};

      SortUtil.ordenar(arrC);
      for (Celular cel : arrC) {
         System.out.println("Titular: " + cel.getTitular().getNombre());
         System.out.println("Numero: " + cel.getNumero());
      }

   }
}
