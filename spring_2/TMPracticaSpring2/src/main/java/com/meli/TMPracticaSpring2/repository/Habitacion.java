package com.meli.TMPracticaSpring2.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
   private String nombre;
   private double ancho;
   private double largo;

   public double areaHabitacion() {
      return ancho * largo;
   }
}
