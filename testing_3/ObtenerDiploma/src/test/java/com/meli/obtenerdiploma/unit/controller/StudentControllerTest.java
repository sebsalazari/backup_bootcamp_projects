package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
   @Mock
   IStudentService iStudentService;

   @InjectMocks
   StudentController studentController;

   @Test
   public void registerStudent() {
      // Arrange
      StudentDTO studentDTO = TestUtilGenerator.getStudentHonor();
      Mockito.doNothing().when(iStudentService).create(studentDTO);

      // Act
      ResponseEntity<?> received = studentController.registerStudent(studentDTO);

      // Assert
      Mockito.verify(iStudentService, Mockito.atLeastOnce()).create(studentDTO);
      Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
   }

   @Test
   public void getStudent() {
      // Arrange
      Long id = 2L;
      StudentDTO expected = TestUtilGenerator.getStudentHonor();
      Mockito.when(iStudentService.read(id)).thenReturn(expected);

      // Act
      StudentDTO received = studentController.getStudent(id);

      // Assert
      Mockito.verify(iStudentService, Mockito.atLeastOnce()).read(id);
      Assertions.assertEquals(expected, received);
      Assertions.assertEquals(expected.getStudentName(), received.getStudentName());
   }

   @Test
   public void modifyStudent() {
      // Arrange
      StudentDTO studentDTO = TestUtilGenerator.getStudentHonor();
      Mockito.doNothing().when(iStudentService).update(studentDTO);

      // Act
      ResponseEntity<?> received = studentController.modifyStudent(studentDTO);

      // Assert
      Mockito.verify(iStudentService, Mockito.atLeastOnce()).update(studentDTO);
      Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
   }

   @Test
   public void removeStudent() {
      // Arrange
      Long id = 2L;
      StudentDTO studentDTO = TestUtilGenerator.getStudentHonor();
      Mockito.doNothing().when(iStudentService).delete(id);

      // Act
      ResponseEntity<?> received = studentController.removeStudent(id);

      // Assert
      Mockito.verify(iStudentService, Mockito.atLeastOnce()).delete(id);
      Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
   }

   @Test
   public void listStudents() {
      // Arrange
      Set<StudentDTO> expected = TestUtilGenerator.getAllUsers();
      Mockito.when(iStudentService.getAll()).thenReturn(expected);

      // Act
      Set<StudentDTO> received = studentController.listStudents();

      // Assert
      Mockito.verify(iStudentService, Mockito.atLeastOnce()).getAll();
      Assertions.assertEquals(expected.size(), received.size());
      Assertions.assertEquals(expected, received);
   }

   @Test
   public void getStudentNotFoundException() {
      // Arrange
      Long id = 4L;
      Mockito.when(iStudentService.read(id)).thenThrow(StudentNotFoundException.class);

      // Act

      // Assert
      Assertions.assertThrows(StudentNotFoundException.class, () -> studentController.getStudent(id));
      Mockito.verify(iStudentService, Mockito.atLeast(1)).read(id);
   }


}
