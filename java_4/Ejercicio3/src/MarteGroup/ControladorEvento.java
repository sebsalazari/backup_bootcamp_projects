package MarteGroup;

import java.util.ArrayList;

public class ControladorEvento {
   private ArrayList<FuegoArtificial> fuegosArt = new ArrayList<>();
   private ArrayList<Invitado> invitados = new ArrayList<>();

   // Constructores
   public ControladorEvento(ArrayList<Invitado> invitados, ArrayList<FuegoArtificial> fuegoArt) {
      this.invitados = invitados;
      this.fuegosArt = fuegoArt;
   }

   public ControladorEvento() {
      this.invitados = new ArrayList<>();
      this.fuegosArt = new ArrayList<>();
   }

   // Metodos -> Acciones durante el evento
   public void llegaInvitado(Invitado invitado) {
      this.invitados.add(invitado);
   }

   public void agregarFuegoArtificial(FuegoArtificial fuego) {
      this.fuegosArt.add(fuego);
   }

   public boolean apagaVelas(){
      return true;
   }

   public void explotarFuegos(){
      System.out.println("Inicia el Show - KBOOM");
      for (FuegoArtificial fuegos : this.fuegosArt) {
         fuegos.explotar();
      }
      System.out.println("Termina el Show - Aplausos :)\n");
   }

   public void repartirTorta(){
      System.out.println("Inicia la hora de comer torta !!!");

      for (Invitado invi : this.invitados) {
         System.out.println("Repartiendo torta a " + invi.getNombre());
      }

      for (Invitado invi : this.invitados) {
         invi.gritar();
      }
      System.out.println("Barriga llena corazon contento !!!");
   }
}
