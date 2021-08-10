package com.meli.DiplomasAPISpring.Controller;

import com.meli.DiplomasAPISpring.Model.DiplomaDTO;
import com.meli.DiplomasAPISpring.Model.StudentDTO;
import com.meli.DiplomasAPISpring.Service.IDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DiplomaController {

   @Autowired
   IDiplomaService iDiplomaService;

   @PostMapping("/api/diploma")
   public ResponseEntity<DiplomaDTO> createDiploma(@Valid @RequestBody StudentDTO student) {
      return new ResponseEntity<>(iDiplomaService.createDiploma(student), HttpStatus.CREATED);
   }
}
