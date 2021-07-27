package Ejercicio1;

public class Persona implements Precedable<Persona> {

   // Atributos
   private String nombre;
   private int dni;

   // Constructores
   public Persona() {
      this.nombre = "Sin nombre";
      this.dni = 0;
   }

   public Persona(String nombre, int dni) {
      this.nombre = nombre;
      this.dni = dni;
   }

   // Encapsulamiento
   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public int getDni() {
      return dni;
   }

   public void setDni(int dni) {
      this.dni = dni;
   }

   @Override
   public int precedeA(Persona per) {
      if (this.dni > per.getDni()) {
         return 1;
      } else return 0;
   }
}
