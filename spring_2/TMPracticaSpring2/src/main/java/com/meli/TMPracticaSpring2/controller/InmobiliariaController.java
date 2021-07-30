package com.meli.TMPracticaSpring2.controller;

import com.meli.TMPracticaSpring2.model.HabitacionDTO;
import com.meli.TMPracticaSpring2.model.PropiedadDTO;
import com.meli.TMPracticaSpring2.service.PropiedadService;
import com.meli.TMPracticaSpring2.repository.Propiedad;
import org.springframework.web.bind.annotation.*;

@RestController
public class InmobiliariaController {

   @PostMapping("/api/propiedades")
   public PropiedadDTO crearPropiedad(@RequestBody Propiedad propiedad) {
       return PropiedadService.propDTO(propiedad);
   }

}
