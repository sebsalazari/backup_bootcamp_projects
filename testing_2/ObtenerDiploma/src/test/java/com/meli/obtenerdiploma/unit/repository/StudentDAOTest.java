package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StudentDAOTest {

   IStudentDAO iStudentDAO;

   @BeforeEach
   private void setUp() {
      this.iStudentDAO = new StudentDAO();
   }

   @Test
   @Order(1)
   public void existStudent() {
      // Arrange
      StudentDTO student = new StudentDTO(2L, "Leito Messi", null, null, new ArrayList<>());

      // Act
      boolean received = iStudentDAO.exists(student);

      // Assert
      Assertions.assertTrue(received);
   }

   @Test
   @Order(2)
   public void notExistStudent() {
      // Arrange
      StudentDTO student = new StudentDTO(5L, "Sebastian", null, null, new ArrayList<>());

      // Act
      boolean received = iStudentDAO.exists(student);

      // Assert
      Assertions.assertFalse(received);
   }

   @Test
   @Order(3)
   public void saveStudent() {
      // Arrange
      StudentDTO student = new StudentDTO(4L, "Sebastian", null, null, new ArrayList<>());

      // Act
      iStudentDAO.save(student);

      // Assert
      Assertions.assertTrue(iStudentDAO.exists(student));
   }

   @Test
   @Order(4)
   public void deleteStudent() {
      // Arrange
      Long id = 3L;

      // Act
      boolean received = iStudentDAO.delete(id);

      // Assert
      Assertions.assertTrue(received);
   }

   @Test
   @Order(5)
   public void findByIdStudent() {
      // Arrange
      StudentDTO expected = new StudentDTO(1L, "Neymar", null, null, new ArrayList<>());
      Long id = expected.getId();

      // Act
      StudentDTO received = iStudentDAO.findById(id);

      // Assert
      Assertions.assertEquals(expected.getStudentName(), received.getStudentName());
   }

   @Test
   @Order(6)
   public void findByIdStudentException() {
      // Arrange
      Long id = 5L;

      // Act

      //Assert
      Assertions.assertThrows(StudentNotFoundException.class, () -> iStudentDAO.findById(id));
   }

}
