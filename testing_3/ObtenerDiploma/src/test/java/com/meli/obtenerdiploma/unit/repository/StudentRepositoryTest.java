package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {

   IStudentRepository iStudentRepository;

   @BeforeEach
   private void setUp() {
      this.iStudentRepository = new StudentRepository();
   }

   @Test
   public void findAll() {
      // Arrange
      Set<StudentDTO> expected = TestUtilGenerator.getAllUsers();

      // Act
      Set<StudentDTO> received = iStudentRepository.findAll();

      // Assert
      Assertions.assertEquals(expected.size(), received.size());
   }

   @Test
   public void findAllException() {
      // Arrange

      Set<StudentDTO> expected = TestUtilGenerator.getOneUser();

      // Act
      Set<StudentDTO> received = iStudentRepository.findAll();


      // Assert
      Assertions.assertNotEquals(expected.size(), received.size());
   }

}
