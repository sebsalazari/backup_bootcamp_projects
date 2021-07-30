package com.meli.TMPracticaSpring2.service;

import com.meli.TMPracticaSpring2.model.HabitacionDTO;
import com.meli.TMPracticaSpring2.model.PropiedadDTO;
import com.meli.TMPracticaSpring2.repository.Habitacion;
import com.meli.TMPracticaSpring2.repository.Propiedad;

import java.util.ArrayList;
import java.util.List;

public class PropiedadService {

   public static double areaTotalPropiedad(Propiedad prop) {
      return prop.getHabitaciones().stream().mapToDouble(Habitacion::areaHabitacion).sum();
   }

   public static double valorTotalPropiedad(Propiedad prop) {
      return 800 * areaTotalPropiedad(prop);
   }

   public static List<HabitacionDTO> listHabitaciones(Propiedad prop) {
      List<HabitacionDTO> listHabDTO = new ArrayList<>();
      prop.getHabitaciones().forEach(item -> {
         HabitacionDTO hab = new HabitacionDTO();
         hab.setNombre(item.getNombre());
         hab.setAreaMetros(item.areaHabitacion());
         listHabDTO.add(hab);
      });

      return listHabDTO;
   }

   public static Habitacion habitacionMasGrande(Propiedad prop) {
      Habitacion hab = null;
      double aux = 0;
      for (Habitacion item : prop.getHabitaciones()) {
         if (item.areaHabitacion() > aux) {
            aux = item.areaHabitacion();
            hab = item;
         }
      }
      return hab;
   }

   public static PropiedadDTO propDTO(Propiedad pro) {
      PropiedadDTO respPropiedad = new PropiedadDTO(
              pro.getNombre(),
              listHabitaciones(pro),
              areaTotalPropiedad(pro),
              valorTotalPropiedad(pro),
              habitacionMasGrande(pro)
      );
      return respPropiedad;
   }
}
