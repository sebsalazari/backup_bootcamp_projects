package Ejercicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Fecha {
   // Atributos
   private int dia;
   private int mes;
   private int anio;

   // Constructores
   public Fecha() {
      // Calendario Gregoriano
      Calendar fecha = new GregorianCalendar();
      this.dia = fecha.get(Calendar.DAY_OF_MONTH);
      this.mes = fecha.get(Calendar.MONTH);
      this.anio = fecha.get(Calendar.YEAR);
   }

   public Fecha(int dia, int mes, int anio) {
      this.dia = dia;
      this.mes = mes;
      this.anio = anio;
   }

   // Encapsulamiento
   public int getDia() {
      return dia;
   }

   public void setDia(int dia) {
      this.dia = dia;
   }

   public int getMes() {
      return mes;
   }

   public void setMes(int mes) {
      this.mes = mes;
   }

   public int getAnio() {
      return anio;
   }

   public void setAnio(int anio) {
      this.anio = anio;
   }

   // Metodos
   public boolean validarFecha(Fecha fe) {
      String fecha = fe.getDia() + "/" + fe.getMes() + "/" + fe.getAnio();
      try {
         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
         formatoFecha.setLenient(false);
         formatoFecha.parse(fecha);
      } catch (ParseException e) {
         return false;
      }
      return true;
   }

   public static Fecha agregarDia(Fecha fe) {
      GregorianCalendar calendario = new GregorianCalendar(fe.anio, fe.mes, fe.dia);
      calendario.add(Calendar.DAY_OF_MONTH, 1);

      Fecha fecha = new Fecha(calendario.get(Calendar.DAY_OF_MONTH),
              calendario.get(Calendar.MONTH),
              calendario.get(Calendar.YEAR));

      return fecha;
   }

   public String imprimirValidacion(Fecha fe) {
      String resp = (validarFecha(fe)) ? toString() : "La fecha es incorrecta";
      return resp;
   }

   // ToString
   @Override
   public String toString() {
      return "Fecha correcta: " + dia + "/" + mes + "/" + anio;
   }
}
