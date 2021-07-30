package com.meli.TMPracticaSpring2.model;

import com.meli.TMPracticaSpring2.repository.Habitacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropiedadDTO {
   private String nombre;
   private List<HabitacionDTO> habitaciones;
   private double areaTotalMetros, valorPropiedad;
   private Habitacion habMasGrande;
}
