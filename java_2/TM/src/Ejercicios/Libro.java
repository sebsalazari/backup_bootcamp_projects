package Ejercicios;

public class Libro {

   // Atributos
   private String titulo;
   private String autor;
   private String isbn;
   private boolean disponible;

   // Constructores
   public Libro() {
      titulo = "Sin titulo";
      autor = "Sin autor";
      isbn = "--- ---";
      disponible = false;
   }

   public Libro(String titulo, String autor, String isbn, boolean disponible) {
      this.titulo = titulo;
      this.autor = autor;
      this.isbn = isbn;
      this.disponible = disponible;
   }

   // Encapsulamiento
   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getAutor() {
      return autor;
   }

   public void setAutor(String autor) {
      this.autor = autor;
   }

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public boolean isDisponible() {
      return disponible;
   }

   public void setDisponible(boolean disponible) {
      this.disponible = disponible;
   }

   // Metodos
   public static void prestamo(Libro libro) {
      if (libro.disponible) {
         System.out.println("El libro: " + libro.titulo + " fue asignado correctamente!");
         libro.disponible = false;
      } else
         System.out.println("El libro: " + libro.titulo + " no esta disponible para prestamo");
   }

   public static void devolucion(Libro libro) {
      if (!libro.disponible) {
         System.out.println("El libro: " + libro.titulo + " fue devuelto correctamente!");
         libro.disponible = true;
      } else
         System.out.println("El libro: " + libro.titulo + " ya se encuentra disponible, error en la devolución");
   }

   // ToString
   @Override
   public String toString() {
      return "(Libro)\tTitulo: " + titulo
              + "\tAutor: " + autor
              + "\tISBN: " + isbn
              + "\tDisponibilidad: " + ((disponible) ? "Disponible" : "No disponible");
   }
}
