package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestUtilGenerator {

   public static Set<StudentDTO> getAllUsers() {
      Set<StudentDTO> users = new HashSet<>();

      StudentDTO student1 = new StudentDTO(1L, "Neymar", null, null, new ArrayList<>() {
         {
            add(new SubjectDTO("Matematica", 9.0));
            add(new SubjectDTO("Fisica", 7.0));
            add(new SubjectDTO("Quimica", 6.0));
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

   public static Set<StudentDTO> getOneUser() {
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

   public static StudentDTO getUser() {
      StudentDTO student2 = new StudentDTO(2L, "Leito Messi", null, null, new ArrayList<>() {
         {
            add(new SubjectDTO("Quimica", 10.0));
            add(new SubjectDTO("Biologia", 8.0));
            add(new SubjectDTO("Religion", 4.0));
         }
      });

      return student2;
   }

   public static StudentDTO getStudentHonor() {
      StudentDTO student2 = new StudentDTO(2L, "Leito Messi",
              "El alumno Leito Messi ha obtenido un promedio de 9.53. Felicitaciones!",
              (10.0 + 9.5 + 9.1) / 3,
              new ArrayList<>() {
                 {
                    add(new SubjectDTO("Quimica", 10.0));
                    add(new SubjectDTO("Biologia", 9.5));
                    add(new SubjectDTO("Religion", 9.1));
                 }
              });

      return student2;
   }

   public static StudentDTO getStudentNotHonor() {
      StudentDTO student2 = new StudentDTO(2L, "Leito Messi",
              "El alumno Leito Messi ha obtenido un promedio de 8.53. Puedes mejorar.",
              (8.0 + 8.5 + 9.1) / 3,
              new ArrayList<>() {
                 {
                    add(new SubjectDTO("Quimica", 8.0));
                    add(new SubjectDTO("Biologia", 8.5));
                    add(new SubjectDTO("Religion", 9.1));
                 }
              });

      return student2;
   }

   public static StudentDTO getStudentBadData() {
      StudentDTO student2 = new StudentDTO(2L, "ronaldo",
              "El alumno Leito Messi ha obtenido un promedio de 9.53. Felicitaciones!",
              (10.0 + 9.5 + 9.1) / 3,
              new ArrayList<>() {
                 {
                    add(new SubjectDTO("quimica", 10.0));
                    add(new SubjectDTO("Biologia", -9.5));
                    add(new SubjectDTO("Religion", 9.1));
                 }
              });

      return student2;
   }
}
