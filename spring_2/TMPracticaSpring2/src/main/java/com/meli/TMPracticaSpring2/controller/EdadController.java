package com.meli.TMPracticaSpring2.controller;

import com.meli.TMPracticaSpring2.model.EdadDTO;
import com.meli.TMPracticaSpring2.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

   @GetMapping("/api/edad")
   public EdadDTO calculoEdad(@RequestParam Integer dia, @RequestParam Integer mes, @RequestParam Integer anio) {
      return EdadService.edadDTO(dia, mes, anio);
   }
}
