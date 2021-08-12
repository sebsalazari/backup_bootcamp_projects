package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

   @Autowired
   MockMvc mockMvc;

   @MockBean
   IObtenerDiplomaService iObtenerDiplomaService;

   @Test
   public void analyzeScoreTest() throws Exception {
      Long id = 2L;
      StudentDTO expectedStudent = TestUtilGenerator.getStudentHonor();

      Mockito.when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(expectedStudent);

      ObjectWriter writer = new ObjectMapper()
              .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
              .writer();

      String responseStudentDTO = writer.writeValueAsString(expectedStudent);

      MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
              .get("/analyzeScores/{studentId}", id))
              .andDo(print()).andExpect(status().isOk())
              .andExpect(content().contentType("application/json"))
              .andReturn();

      Assertions.assertEquals(responseStudentDTO, mvcResult.getResponse().getContentAsString());
   }

   @Test
   public void generateDiplomaWithNonExistingId() throws Exception {
      String description = "Error generando el diploma";
      Mockito.when(iObtenerDiplomaService.analyzeScores(100L))
              .thenThrow(new ObtenerDiplomaException(description, HttpStatus.BAD_REQUEST));

      MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders
              .get("/analyzeScores/{studentId}", 100))
              .andDo(print()).andExpect(status().isBadRequest())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andReturn();

      Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(),response.getResponse().getStatus());
   }

}
