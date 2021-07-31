package com.meli.DiplomasAPISpring.Service;

import com.meli.DiplomasAPISpring.Model.DiplomaDTO;
import com.meli.DiplomasAPISpring.Repository.Student;
import com.meli.DiplomasAPISpring.Repository.Subject;

import java.util.List;

public class DiplomaService {

   public static double generateAverage(List<Subject> listSubject) {
      double sum = listSubject.stream().mapToDouble(Subject::getSubjectNote).sum();
      return sum / listSubject.size();
   }

   public static String generateMessage(double totalAverage) {
      return (totalAverage >= 9)
              ? "Graduado con honores, felicitaciones! tu promedio es mayor a 9"
              : "Aprobado - Recibes tu diploma";
   }

   public static DiplomaDTO createDiploma(Student student) {
      DiplomaDTO diplomaDTO = new DiplomaDTO(
              student.getName(),
              generateMessage(generateAverage(student.getListSubject())),
              generateAverage(student.getListSubject()));

      return diplomaDTO;
   }
}
