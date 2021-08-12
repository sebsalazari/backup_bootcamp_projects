package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDIplomaTest {

   @Mock
   IObtenerDiplomaService iObtenerDiplomaService;

   @InjectMocks
   ObtenerDiplomaController obtenerDiplomaController;

   @Test
   public void analyzeScoreHonor() {
      // Arrange
      Long id = 2L;
      StudentDTO expected = TestUtilGenerator.getStudentHonor();
      Mockito.when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(expected);

      // Act
      StudentDTO received = obtenerDiplomaController.analyzeScores(id);

      // Assert
      Mockito.verify(iObtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(id);
      Assertions.assertEquals(expected, received);
   }

   @Test
   public void analyzeScoreNotHonor() {
      // Arrange
      Long id = 2L;
      StudentDTO expected = TestUtilGenerator.getStudentNotHonor();
      Mockito.when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(expected);

      // Act
      StudentDTO received = obtenerDiplomaController.analyzeScores(id);

      // Assert
      Mockito.verify(iObtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(id);
      Assertions.assertEquals(expected, received);
   }
}
