package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestUtilGenerator {

   public static Set<StudentDTO> getAllUsers() {
      Set<StudentDTO> users = new HashSet<>();

      StudentDTO student1 = new StudentDTO(1L, "Neymar", null, null, new ArrayList<>() {
         {
            add(new SubjectDTO("Matemática", 9.0));
            add(new SubjectDTO("Física", 7.0));
            add(new SubjectDTO("Química", 6.0));
         }
      });

      StudentDTO student2 = new StudentDTO(2L, "Leito Messi", null, null, new ArrayList<>() {
         {
            add(new SubjectDTO("Quimica", 10.0));
            add(new SubjectDTO("Biologia", 8.0));
            add(new SubjectDTO("Religion", 4.0));
         }
      });

      StudentDTO student3 = new StudentDTO(3L, "Mbappe", null, null, new ArrayList<>() {
         {
            add(new SubjectDTO("Ed. Fisica", 10.0));
            add(new SubjectDTO("Artes", 6.0));
            add(new SubjectDTO("Musica", 9.0));
         }
      });

      users.add(student1);
      users.add(student2);
      users.add(student3);

      return users;
   }

   public static Set<StudentDTO> getOneUser(){
      Set<StudentDTO> users = new HashSet<>();

      StudentDTO student2 = new StudentDTO(2L, "Leito Messi", null, null, new ArrayList<>() {
         {
            add(new SubjectDTO("Quimica", 10.0));
            add(new SubjectDTO("Biologia", 8.0));
            add(new SubjectDTO("Religion", 4.0));
         }
      });

      users.add(student2);

      return users;
   }
}
