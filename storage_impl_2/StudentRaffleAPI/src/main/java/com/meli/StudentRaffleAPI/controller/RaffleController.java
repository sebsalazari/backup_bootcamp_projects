package com.meli.StudentRaffleAPI.controller;

import com.meli.StudentRaffleAPI.model.Student;
import com.meli.StudentRaffleAPI.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("raffle")
public class RaffleController {

   @Autowired
   IStudentService iStudentService;

   @GetMapping("/students")
   public ResponseEntity<List<Student>> getStudentsRandom() {
      return new ResponseEntity<>(iStudentService.getStudentsRandom(), HttpStatus.OK);
   }
}
