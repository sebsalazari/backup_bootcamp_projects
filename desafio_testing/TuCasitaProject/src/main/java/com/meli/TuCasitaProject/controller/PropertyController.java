package com.meli.TuCasitaProject.controller;

import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PropertyController {

   @Autowired
   IPropertyService iPropertyService;

   // US-0001 - Registrar una nueva propiedad
   @PostMapping("/register/property")
   public ResponseEntity<?> registerProperty(@RequestBody PropertyDTO propertyDTO) {
      iPropertyService.registerProperty(propertyDTO);
      return new ResponseEntity<Void>(HttpStatus.CREATED);
   }

}
