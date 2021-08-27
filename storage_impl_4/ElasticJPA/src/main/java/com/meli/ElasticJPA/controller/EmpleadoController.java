package com.meli.ElasticJPA.controller;

import com.meli.ElasticJPA.model.Empleado;
import com.meli.ElasticJPA.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

   @Autowired
   IEmpleadoService iEmpleadoService;

   @PostMapping("/empleado/new")
   public ResponseEntity<String> saveEmpleado(@RequestBody Empleado empleado) {
      iEmpleadoService.save(empleado);
      return new ResponseEntity<>("Empleado guardado con exito", HttpStatus.OK);
   }

   @GetMapping("/get-empleados")
   public ResponseEntity<List<Empleado>> getEmpleados() {
      return new ResponseEntity<>(iEmpleadoService.findAll(), HttpStatus.OK);
   }

   @DeleteMapping("/empleado/delete/{id}")
   public ResponseEntity<String> deleteEmpleado(@PathVariable Integer id) {
      iEmpleadoService.delete(id);
      return new ResponseEntity<>("Empleado eliminado con exito", HttpStatus.OK);
   }

   // --- EndPoints Practica ---
   // (1) Encontrar empleados por edad
   @GetMapping("/get-empleados/age/{age}")
   public ResponseEntity<List<Empleado>> getEmpleadosByAge(@PathVariable Integer age) {
      return new ResponseEntity<>(iEmpleadoService.getListEmpleadosByAge(age), HttpStatus.OK);
   }

   // (2) Encontrar empleados por nombre
   @GetMapping("/get-empleados/name/{name}")
   public ResponseEntity<List<Empleado>> getEmpleadosByName(@PathVariable String name) {
      return new ResponseEntity<>(iEmpleadoService.getListEmpleadosByName(name), HttpStatus.OK);
   }

   // (1) Encontrar empleados por rango de edades
   @GetMapping("/get-empleados/rank-age/{age1}/{age2}")
   public ResponseEntity<List<Empleado>> getEmpleadosByRankAge(@PathVariable Integer age1, @PathVariable Integer age2) {
      return new ResponseEntity<>(iEmpleadoService.getListEmpleadosByRankAge(age1, age2), HttpStatus.OK);
   }
}
