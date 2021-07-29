package MarteGroup;

import java.util.ArrayList;

public class Main {

   public static void main(String[] args) {
      // Se definen las listas de invitados y fuegos artificiales
      ArrayList<Invitado> invitados = new ArrayList<>();
      ArrayList<FuegoArtificial> fuegos = new ArrayList<>();


      // Empiezan a llegar los invitados
      Invitado invi1 = new InvitadoMeli("Sebas Salazar", 21, "Analyst IT");
      Invitado invi2 = new InvitadoStandard("Jose Gomez", 52);
      Invitado invi3 = new InvitadoMeli("Carlos Perez", 35, "People");
      Invitado invi4 = new InvitadoMeli("Maria Ortiz", 25, "Custom CX");
      Invitado invi5 = new InvitadoStandard("Juana Ruiz", 43);

      invitados.add(invi1);
      invitados.add(invi2);
      invitados.add(invi3);
      invitados.add(invi4);
      invitados.add(invi5);

      // Se preparan los fuegos artificiales
      FuegoArtificial f1 = new FuegoArtificialSolo("Boooooomm");
      FuegoArtificial f2 = new FuegoArtificialSolo("Pummmmm");
      FuegoArtificial f3 = new FuegoArtificialSolo("Kasssssss");

      fuegos.add(f1);
      fuegos.add(f2);
      fuegos.add(f3);

      // Se añade la lista a un nuevo pack
      FuegoArtificial f1p = new FuegoArtificialPack(fuegos);


      // Se instancia el evento
      ControladorEvento even = new ControladorEvento(invitados, fuegos);

      // Ya esta todoo preparado que inicie la funcion
      if(even.apagaVelas()){
         even.explotarFuegos();
         even.repartirTorta();
      }

      System.out.println("\nFin del evento");
   }
}
