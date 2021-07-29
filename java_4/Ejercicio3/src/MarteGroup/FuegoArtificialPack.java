package MarteGroup;

import java.util.ArrayList;

public class FuegoArtificialPack implements FuegoArtificial{

   // Una lista de fuegos artificiales general pues este puede contener un individual o un pack
   private ArrayList<FuegoArtificial> fuegoArti;

   public FuegoArtificialPack(ArrayList<FuegoArtificial> fuegosArti) {
      this.fuegoArti = fuegosArti;
   }

   @Override
   public void explotar() {
      for (FuegoArtificial f : fuegoArti) {
         f.explotar();
      }
   }
}
