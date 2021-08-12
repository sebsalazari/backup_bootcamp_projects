package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

   @Autowired
   MockMvc mockMvc;

   @MockBean
   IStudentService iStudentService;

   @MockBean
   IStudentDAO iStudentDAO;

   @Test
   public void registerStudentTest() throws Exception {
      StudentDTO expectedStudent = TestUtilGenerator.getStudentHonor();

      ObjectWriter writer = new ObjectMapper()
              .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
              .writer().withDefaultPrettyPrinter();

      String payloadJson = writer.writeValueAsString(expectedStudent);

      this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
              .contentType(MediaType.APPLICATION_JSON)
              .content(payloadJson))
              .andDo(print()).andExpect(status().isOk());
   }

   @Test
   public void registerStudentNullTest() throws Exception {
      this.mockMvc.perform(MockMvcRequestBuilders
              .post("/student/registerStudent"))
              .andDo(print()).andExpect(status().isBadRequest());
   }

   @Test
   public void registerStudentEmptyTest() throws Exception {
      StudentDTO expectedStudent = new StudentDTO();

      ObjectWriter writer = new ObjectMapper()
              .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
              .writer().withDefaultPrettyPrinter();

      String payloadJson = writer.writeValueAsString(expectedStudent);

      this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
              .contentType(MediaType.APPLICATION_JSON)
              .content(payloadJson))
              .andDo(print()).andExpect(status().isBadRequest());
   }

   @Test
   public void registerStudentWithErrorsTest() throws Exception {
      StudentDTO expectedStudent = TestUtilGenerator.getStudentBadData();

      ObjectWriter writer = new ObjectMapper()
              .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
              .writer().withDefaultPrettyPrinter();

      String payloadJson = writer.writeValueAsString(expectedStudent);

      this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
              .contentType(MediaType.APPLICATION_JSON)
              .content(payloadJson))
              .andDo(print()).andExpect(status().isBadRequest());
   }

   @Test
   public void getStudentByIdTest() throws Exception {
      StudentDTO expectedStudent = TestUtilGenerator.getStudentHonor();
      Long id = expectedStudent.getId();
      Mockito.when(iStudentService.read(id)).thenReturn(expectedStudent);

      ObjectWriter writer = new ObjectMapper()
              .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
              .writer();

      String responseStudentJson = writer.writeValueAsString(expectedStudent);

      MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
              .andDo(print()).andExpect(status().isOk())
              .andExpect(content().contentType("application/json"))
              .andReturn();

      Assertions.assertEquals(responseStudentJson, mvcResult.getResponse().getContentAsString());
   }

   @Test
   public void modifyStudentTest() throws Exception {
      StudentDTO expectedStudent = TestUtilGenerator.getStudentHonor();

      ObjectWriter writer = new ObjectMapper()
              .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
              .writer().withDefaultPrettyPrinter();

      String payloadJson = writer.writeValueAsString(expectedStudent);

      this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
              .contentType(MediaType.APPLICATION_JSON)
              .content(payloadJson))
              .andDo(print()).andExpect(status().isOk());
   }

   @Test
   public void removeStudentByIdTest() throws Exception {
      Long id = 2L;
      Mockito.when(iStudentDAO.delete(id)).thenReturn(true);

      MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
              .andDo(print()).andExpect(status().isOk())
              .andReturn();

      Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
   }

   @Test
   public void removeStudentByIdTestException() throws Exception {
      Long id = null;
      Mockito.when(iStudentDAO.delete(id)).thenReturn(false);

      MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
              .andDo(print()).andExpect(status().isNotFound())
              .andReturn();

      Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
   }

   @Test
   public void listStudentByIdTest() throws Exception {
      Set<StudentDTO> expectedStudentsList = TestUtilGenerator.getAllUsers();
      Mockito.when(iStudentService.getAll()).thenReturn(expectedStudentsList);

      ObjectWriter writer = new ObjectMapper()
              .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
              .writer();

      String responseStudentsJson = writer.writeValueAsString(expectedStudentsList);

      MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
              .andDo(print()).andExpect(status().isOk())
              .andExpect(content().contentType("application/json"))
              .andReturn();

      Assertions.assertEquals(responseStudentsJson, mvcResult.getResponse().getContentAsString());
   }

}