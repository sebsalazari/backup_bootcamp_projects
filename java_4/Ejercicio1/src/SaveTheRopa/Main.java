package SaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {

   public static void main(String[] args) {
      ArrayList<Prenda> arrPrenda = new ArrayList<>();
      ArrayList<Prenda> arrPrenda2 = new ArrayList<>();
      Prenda pre1 = new Prenda("Adidas", "Sport");
      Prenda pre2 = new Prenda("Zara", "Wolbery");
      Prenda pre3 = new Prenda("Nike", "Magista");
      Prenda pre4 = new Prenda("Arturo Calle", "Limits");

      arrPrenda.add(pre1);
      arrPrenda.add(pre2);
      arrPrenda2.add(pre3);
      arrPrenda2.add(pre4);

      // Guardando el listado de prendas en el guardaropa
      GuardaRopa gr = new GuardaRopa();
      System.out.println("Prendas guardadas en el casillero: " + gr.guardarPrendas(arrPrenda));
      System.out.println("Prendas guardadas en el casillero: " + gr.guardarPrendas(arrPrenda2));

      // Mostrando todas las prendas guardadas
      System.out.println("\nLISTADO DE PRENDAS EN EL GUARDAROPAS");
      gr.mostrarPrendas();

      // Extrayendo una prenda especifica y eliminandola del guarda ropa
      List<Prenda> prenda = gr.devolverPrendas(1);

      System.out.println("\nPrendas removidas del guarda ropa");
      prenda.forEach((id) -> {
         System.out.println("(" + id.getMarca() + "," + id.getModelo() + ")\t");
      });
   }
}
