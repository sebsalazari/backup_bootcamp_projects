package MarteGroup;

public abstract class Invitado {
   private String nombre;
   private int edad;

   // Encapsulamiento
   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public int getEdad() {
      return edad;
   }

   public void setEdad(int edad) {
      this.edad = edad;
   }

   // Metodos
   public abstract void gritar();
}
