package com.meli.DiplomasAPISpring.Service;

import com.meli.DiplomasAPISpring.Model.DiplomaDTO;
import com.meli.DiplomasAPISpring.Model.StudentDTO;
import com.meli.DiplomasAPISpring.Model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomaService implements IDiplomaService {

   @Override
   public DiplomaDTO createDiploma(StudentDTO student) {
      DiplomaDTO diplomaDTO = new DiplomaDTO(
              student.getStudentName(),
              generateMessage(generateAverage(student.getSubjects())),
              generateAverage(student.getSubjects()),
              student.getSubjects());

      return diplomaDTO;

   }

   public static double generateAverage(List<SubjectDTO> listSubject) {
      double sum = listSubject.stream().mapToDouble(SubjectDTO::getScore).sum();
      return sum / listSubject.size();
   }

   public static String generateMessage(double totalAverage) {
      return (totalAverage >= 9)
              ? "Graduado con honores, felicitaciones! tu promedio es mayor a 9"
              : "Aprobado - Recibes tu diploma";
   }
}
