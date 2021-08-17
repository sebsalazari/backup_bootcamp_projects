package com.meli.TuCasitaProject.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.TuCasitaProject.exception.property.PropertyNotFoundException;
import com.meli.TuCasitaProject.mapper.PropertyMapper;
import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.TotalSquareMetersPropertyDTO;
import com.meli.TuCasitaProject.repository.IPropertyRepository;
import com.meli.TuCasitaProject.util.TestUtilGenerator;
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
public class PropertyControllerIntegrationMockTest {

   @Autowired
   MockMvc mockMvc;

   @MockBean
   IPropertyRepository iPropertyRepository;

   @Test
   public void registerPropertyDistrictNotFound() throws Exception {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(2);
      Mockito.when(iPropertyRepository.existsDistrict(propertyDTO.getDistrict())).thenReturn(false);
      String payload = getPayloadMapper(propertyDTO);

      // Act
      MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register/property")
              .contentType(MediaType.APPLICATION_JSON)
              .content(payload))
              .andDo(print()).andExpect(status().isNotFound())
              .andReturn();

      // Assert
      Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), response.getResponse().getStatus());
   }

   @Test
   public void getPropertyNotFound() throws Exception {
      // Arrange
      int id_property = 99999999;
      Mockito.when(iPropertyRepository.getProperty(id_property)).thenThrow(PropertyNotFoundException.class);

      // Act
      MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/calculate/property/{property_id}/meters", id_property))
              .andDo(print()).andExpect(status().isBadRequest())
              .andReturn();

      // Assert
      Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
   }

   @Test
   public void getTotalSquareMetersProperty() throws Exception {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      int id_property = propertyDTO.getProperty_id();
      Mockito.when(iPropertyRepository.getProperty(id_property)).thenReturn(propertyDTO);

      TotalSquareMetersPropertyDTO metersProperty = new TotalSquareMetersPropertyDTO(propertyDTO.getProp_name(), 3000);
      String responseJson = getPayloadMapper(metersProperty);

      // Act
      MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/calculate/property/{property_id}/meters", id_property))
              .andDo(print()).andExpect(status().isOk())
              .andExpect(content().contentType("application/json"))
              .andReturn();

      // Asserts
      Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
      Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
   }

   @Test
   public void valueTotalProperty() throws Exception {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      int id_property = propertyDTO.getProperty_id();
      Mockito.when(iPropertyRepository.getProperty(id_property)).thenReturn(propertyDTO);

      String responseJson = getPayloadMapper(PropertyMapper.valueTotalPropertyDTO(propertyDTO, 3988800.0));

      // Act
      MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/calculate/property/{property_id}/value", id_property))
              .andDo(print()).andExpect(status().isOk())
              .andExpect(content().contentType("application/json"))
              .andReturn();

      // Asserts
      Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
      Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
   }

   @Test
   public void bigRoomProperty() throws Exception {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      int id_property = propertyDTO.getProperty_id();
      Mockito.when(iPropertyRepository.getProperty(id_property)).thenReturn(propertyDTO);

      String responseJson = getPayloadMapper(PropertyMapper.biggerRoomPropertyDTO(propertyDTO.getEnvironments().get(0)));

      // Act
      MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/calculate/property/{property_id}/biggestroom", id_property))
              .andDo(print()).andExpect(status().isOk())
              .andExpect(content().contentType("application/json"))
              .andReturn();

      // Asserts
      Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
      Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
   }

   @Test
   public void listRoomCalculateProperty() throws Exception {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      int id_property = propertyDTO.getProperty_id();
      Mockito.when(iPropertyRepository.getProperty(id_property)).thenReturn(propertyDTO);

      String responseJson = getPayloadMapper(PropertyMapper.listMetersRoomDTO(propertyDTO.getEnvironments()));

      // Act
      MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/calculate/property/{property_id}/rooms/meters", id_property))
              .andDo(print()).andExpect(status().isOk())
              .andExpect(content().contentType("application/json"))
              .andReturn();

      // Asserts
      Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
      Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
   }

   public String getPayloadMapper(Object propertyDTO) {
      String payload = "";
      ObjectWriter writer = new ObjectMapper()
              .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
              .writer();

      try {
         payload = writer.writeValueAsString(propertyDTO);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      return payload;
   }
}