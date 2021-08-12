package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

   @Mock
   private IStudentRepository iStudentRepository;

   @Mock
   private IStudentDAO iStudentDAO;

   @InjectMocks
   private StudentService studentService;

   @Test
   public void createStudent() {
      // Arrange
      StudentDTO studentDTO = TestUtilGenerator.getUser();
      Mockito.doNothing().when(iStudentDAO).save(studentDTO);

      // Act
      studentService.create(studentDTO);

      // Assert
      Mockito.verify(iStudentDAO, Mockito.atLeast(1)).save(studentDTO);
   }

   @Test
   public void readStudent() {
      // Arrange
      Long id = 2L;
      StudentDTO expected = TestUtilGenerator.getUser();
      Mockito.when(iStudentDAO.findById(id)).thenReturn(expected);

      // Act
      StudentDTO received = studentService.read(id);

      // Assert
      Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
      Assertions.assertEquals(expected, received);
   }

   @Test
   public void updateStudent() {
      // Arrange
      StudentDTO studentDTO = TestUtilGenerator.getUser();
      Mockito.doNothing().when(iStudentDAO).save(studentDTO);

      // Act
      studentService.update(studentDTO);

      // Assert
      Mockito.verify(iStudentDAO, Mockito.atLeast(1)).save(studentDTO);
   }

   @Test
   public void deleteStudent() {
      // Arrange
      Long id = 2L;
      Mockito.when(iStudentDAO.delete(id)).thenReturn(true);

      // Act
      studentService.delete(id);

      // Assert
      Mockito.verify(iStudentDAO, Mockito.atLeast(1)).delete(id);
   }

   @Test
   public void getAllStudent() {
      // Arrange
      Set<StudentDTO> expected = TestUtilGenerator.getAllUsers();
      Mockito.when(iStudentRepository.findAll()).thenReturn(expected);

      // Act
      Set<StudentDTO> received = studentService.getAll();

      // Assert
      Mockito.verify(iStudentRepository, Mockito.atLeast(1)).findAll();
      Assertions.assertEquals(expected, received);
   }

   @Test
   public void readStudentException() {
      // Arrange
      Long id = 4L;
      Mockito.when(iStudentDAO.findById(id)).thenThrow(StudentNotFoundException.class);

      // Act

      // Assert
      Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(id));
      Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
   }

}
