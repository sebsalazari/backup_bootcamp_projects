package com.meli.TMPracticaSpring2.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Propiedad {
   private String nombre;
   private String direccion;
   private List<Habitacion> habitaciones;
}
