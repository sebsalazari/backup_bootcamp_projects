package com.meli.DiplomasAPISpring.Controller;

import com.meli.DiplomasAPISpring.Model.DiplomaDTO;
import com.meli.DiplomasAPISpring.Repository.Student;
import com.meli.DiplomasAPISpring.Service.DiplomaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiplomaController {

   @PostMapping("/api/diploma")
   public DiplomaDTO createDiploma(@RequestBody Student student){
      return DiplomaService.createDiploma(student);
   }
}
