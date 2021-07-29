package MarteGroup;

public class InvitadoStandard extends Invitado {

   // Constructor
   public InvitadoStandard(String nombre, int edad){
      this.setNombre(nombre);
      this.setEdad(edad);
   }

   @Override
   public void gritar() {
      System.out.println("Que buen evento y torta deliciosa!");
   }
}
