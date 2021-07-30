package com.meli.TMPracticaSpring2.service;

import com.meli.TMPracticaSpring2.model.EdadDTO;

import java.time.LocalDate;
import java.time.Period;

public class EdadService {

   private static Integer edad;

   public static String calculoEdad(Integer dia, Integer mes, Integer anio) {
      Period p = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
      edad = p.getYears();
      return String.format("%d años, %d meses y %d días",
              p.getYears(),
              p.getMonths(),
              p.getDays());
   }

   public static EdadDTO edadDTO(Integer dia, Integer mes, Integer anio) {
      EdadDTO edadDTO = new EdadDTO(
              calculoEdad(dia, mes, anio),
              edad
      );
      return edadDTO;
   }
}
