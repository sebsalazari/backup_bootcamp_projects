package com.meli.TuCasitaProject.controller;

import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;
import com.meli.TuCasitaProject.model.response.TotalSquareMetersPropertyDTO;
import com.meli.TuCasitaProject.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PropertyController {

   @Autowired
   IPropertyService iPropertyService;

   /*   NOTA
      - Me decante por registrar la propiedad y generar un ID automatico que sera devuelto al usuario para que
        haga las demas consultas a los demas enpoints con este ID y asi tener tambien una persistencia de los datos
      - Evita estar mandando siempre el Body con la propiedad en cada peticion y ya estaria validado tanto el barrio
        como la propiedad al pasar el registro inicial.
      - Ademas para futuras nuevas funciones se podria generar un historico de propiedades registradas en la app */


   // US-0001 - Registrar propiedad
   @PostMapping("/register/property")
   public ResponseEntity<RegisteredPropertyDTO> registerProperty(@RequestBody @Valid PropertyDTO propertyDTO) {
      return new ResponseEntity<>(iPropertyService.registerProperty(propertyDTO), HttpStatus.CREATED);
   }

   // US-0002 - Calculo total metros cuadrados de la propiedad
   @GetMapping("/calculate/property/{property_id}/meters")
   public ResponseEntity<TotalSquareMetersPropertyDTO> totalMetersProperty(@PathVariable int property_id) {
      return new ResponseEntity<>(iPropertyService.totalMetersProperty(property_id), HttpStatus.OK);
   }

   // US-0003

   // US-0004

   // US-0005

}
