package com.meli.TuCasitaProject.controller;

import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.BiggestEnvironmentDTO;
import com.meli.TuCasitaProject.model.response.PropertyValueDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;
import com.meli.TuCasitaProject.model.response.TotalSquareMetersPropertyDTO;
import com.meli.TuCasitaProject.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

   // US-0003 - Valor total propiedad a partir de sus ambientes
   @GetMapping("/calculate/property/{property_id}/value")
   public ResponseEntity<PropertyValueDTO> valueTotalProperty(@PathVariable int property_id) {
      return new ResponseEntity<>(iPropertyService.valueTotalProperty(property_id), HttpStatus.OK);
   }

   // US-0004 - Ambiente mas grande
   @GetMapping("/calculate/property/{property_id}/biggestroom")
   public ResponseEntity<BiggestEnvironmentDTO> bigRoomProperty(@PathVariable int property_id) {
      return new ResponseEntity<>(iPropertyService.bigRoomProperty(property_id), HttpStatus.OK);
   }

   // US-0005 - Lista de ambientes con sus metros cuadrados calculados
   @GetMapping("/calculate/property/{property_id}/rooms/meters")
   public ResponseEntity<List<BiggestEnvironmentDTO>> listRoomsWithMetersProperty(@PathVariable int property_id) {
      return new ResponseEntity<>(iPropertyService.listRoomsMetersProperty(property_id), HttpStatus.OK);
   }
}
