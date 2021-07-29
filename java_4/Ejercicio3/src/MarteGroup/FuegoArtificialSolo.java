package MarteGroup;

public class FuegoArtificialSolo implements FuegoArtificial{
   private String ruido;

   public FuegoArtificialSolo(String ruido) {
      this.ruido = ruido;
   }

   @Override
   public void explotar() {
      System.out.println("Explotando en 3,2,1... " + ruido);
   }
}
