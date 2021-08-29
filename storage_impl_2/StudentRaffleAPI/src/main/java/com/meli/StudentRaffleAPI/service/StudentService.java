package com.meli.StudentRaffleAPI.service;

import com.meli.StudentRaffleAPI.model.Student;
import com.meli.StudentRaffleAPI.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class StudentService implements IStudentService {

   @Autowired
   IStudentRepository iStudentRepository;

   @Override
   public List<Student> getStudentsRandom() {
      List<Student> studentList = iStudentRepository.findAll();
      Collections.shuffle(studentList, new Random());
      return studentList.subList(0, 9);
   }
}
