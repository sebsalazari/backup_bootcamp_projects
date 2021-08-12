package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaTest {

   @Mock
   private IStudentDAO iStudentDAO;

   @InjectMocks
   private ObtenerDiplomaService obtenerDiplomaService;

   @Test
   public void analyzeCorrectScoreHonor() {
      // Arrange
      Long id = 2L;
      StudentDTO expected = TestUtilGenerator.getStudentHonor();
      double averageExpected = expected.getAverageScore();
      Mockito.when(iStudentDAO.findById(id)).thenReturn(expected);

      // Act
      StudentDTO received = obtenerDiplomaService.analyzeScores(id);

      // Assert
      Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
      Assertions.assertEquals(expected, received);
      Assertions.assertEquals(averageExpected, received.getAverageScore());

   }

   @Test
   public void analyzeCorrectScoreNotHonor() {
      // Arrange
      Long id = 2L;
      StudentDTO expected = TestUtilGenerator.getStudentNotHonor();
      double averageExpected = expected.getAverageScore();
      Mockito.when(iStudentDAO.findById(id)).thenReturn(expected);

      // Act
      StudentDTO received = obtenerDiplomaService.analyzeScores(id);

      // Assert
      Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
      Assertions.assertEquals(expected, received);
      Assertions.assertEquals(averageExpected, received.getAverageScore());

   }

   @Test
   public void analyzeCorrectMessageHonor() {
      // Arrange
      Long id = 2L;
      StudentDTO expected = TestUtilGenerator.getStudentHonor();
      String expectedMessage = expected.getMessage();
      Mockito.when(iStudentDAO.findById(id)).thenReturn(expected);

      // Act
      StudentDTO received = obtenerDiplomaService.analyzeScores(id);

      // Assert
      Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
      Assertions.assertEquals(expectedMessage, received.getMessage());

   }

   @Test
   public void analyzeCorrectMessageNotHonor() {
      // Arrange
      Long id = 2L;
      StudentDTO expected = TestUtilGenerator.getStudentNotHonor();
      String expectedMessage = expected.getMessage();
      Mockito.when(iStudentDAO.findById(id)).thenReturn(expected);

      // Act
      StudentDTO received = obtenerDiplomaService.analyzeScores(id);

      // Assert
      Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
      Assertions.assertEquals(expectedMessage, received.getMessage());

   }

   @Test
   public void analyzeStudentNotFoundException() {
      // Arrange
      Long id = 100L;
      Mockito.when(iStudentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));

      // Act

      // Assert
      Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(id));

   }


}
