package com.meli.TuCasitaProject.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

   @Autowired
   MockMvc mockMvc;

   @Test
   public void registerProperty() throws Exception {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      String payload = getPayloadMapper(propertyDTO);

      // Act
      MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register/property")
              .contentType(MediaType.APPLICATION_JSON)
              .content(payload))
              .andDo(print()).andExpect(status().isCreated())
              .andReturn();

      // Assert
      Assertions.assertEquals(HttpStatus.CREATED.value(), response.getResponse().getStatus());
   }

   @Test
   public void registerPropertyNull() throws Exception {
      // Act
      MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders
              .post("/api/register/property"))
              .andDo(print()).andExpect(status().isBadRequest())
              .andReturn();

      // Assert
      Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponse().getStatus());
   }

   @Test
   public void registerPropertyEmpty() throws Exception {
      // Arrange
      String payload = "{}";

      // Act
      MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register/property")
              .contentType(MediaType.APPLICATION_JSON)
              .content(payload))
              .andDo(print()).andExpect(status().isBadRequest())
              .andReturn();

      // Assert
      Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponse().getStatus());
   }

   @Test
   public void registerPropertyInvalidPayload() throws Exception {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getPropertyInvalidPayload();
      String payload = getPayloadMapper(propertyDTO);

      // Act
      MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register/property")
              .contentType(MediaType.APPLICATION_JSON)
              .content(payload))
              .andDo(print()).andExpect(status().isBadRequest())
              .andReturn();

      // Assert
      Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponse().getStatus());
   }

   @Test
   public void registerPropertyInvalidDimensions() throws Exception {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getPropertyWithInvalidDimensions();
      String payload = getPayloadMapper(propertyDTO);

      // Act
      MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register/property")
              .contentType(MediaType.APPLICATION_JSON)
              .content(payload))
              .andDo(print()).andExpect(status().isBadRequest())
              .andReturn();

      // Assert
      Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponse().getStatus());
   }

   public String getPayloadMapper(Object propertyDTO) {
      String payload = "";
      ObjectWriter writer = new ObjectMapper()
              .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
              .writer().withDefaultPrettyPrinter();

      try {
         payload = writer.writeValueAsString(propertyDTO);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      return payload;
   }
}
