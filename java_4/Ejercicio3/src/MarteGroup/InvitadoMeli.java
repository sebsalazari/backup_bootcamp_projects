package MarteGroup;

public class InvitadoMeli extends Invitado{
   private String BU;

   // Constructor
   public InvitadoMeli(String nombre, int edad, String BU){
      this.setNombre(nombre);
      this.setEdad(edad);
      this.BU = BU;
   }

   public String getBU() {
      return BU;
   }

   public void setBU(String BU) {
      this.BU = BU;
   }


   @Override
   public void gritar() {
      System.out.println("Que viva la chiqui!!");
   }
}
