package SaveTheRopa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
   private Map<Integer, List<Prenda>> mapRopa = new HashMap<>();
   private int contador = 0;

   // Encapsulamiento
   public Map<Integer, List<Prenda>> getMapRopa() {
      return mapRopa;
   }

   public void setMapRopa(Map<Integer, List<Prenda>> mapRopa) {
      this.mapRopa = mapRopa;
   }

   public int getContador() {
      return contador;
   }

   public void setContador(int contador) {
      this.contador = contador;
   }

   // Metodos
   public Integer guardarPrendas(List<Prenda> listaDePrenda) {
      contador++;
      mapRopa.put(contador, listaDePrenda);
      return contador;
   }

   public void mostrarPrendas() {
      mapRopa.forEach((id, prenda) -> {
         System.out.print(id + " - ");
         prenda.forEach(item -> System.out.print("(" + item.getMarca() + "," + item.getModelo() + ")\t"));
         System.out.println();
      });
   }

   public List<Prenda> devolverPrendas(Integer numero) {
      return mapRopa.remove(numero);
   }
}
