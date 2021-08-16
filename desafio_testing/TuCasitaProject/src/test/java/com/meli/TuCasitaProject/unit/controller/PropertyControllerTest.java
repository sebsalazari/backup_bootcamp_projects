package com.meli.TuCasitaProject.unit.controller;

import com.meli.TuCasitaProject.controller.PropertyController;
import com.meli.TuCasitaProject.exception.district.DistrictNotFoundException;
import com.meli.TuCasitaProject.exception.property.PropertyNotFoundException;
import com.meli.TuCasitaProject.exception.property.RatioSizePropertyInvalidException;
import com.meli.TuCasitaProject.mapper.PropertyMapper;
import com.meli.TuCasitaProject.model.DistrictDTO;
import com.meli.TuCasitaProject.model.EnvironmentDTO;
import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.BiggestEnvironmentDTO;
import com.meli.TuCasitaProject.model.response.PropertyValueDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;
import com.meli.TuCasitaProject.model.response.TotalSquareMetersPropertyDTO;
import com.meli.TuCasitaProject.service.IPropertyService;
import com.meli.TuCasitaProject.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

   @Mock
   IPropertyService iPropertyService;

   @InjectMocks
   PropertyController propertyController;

   @Test
   public void registerProperty() {
      // Arrange
      String messageExpected = "Successful registration - " +
              "with the id_property you can make the other queries";
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      Mockito.when(iPropertyService.registerProperty(propertyDTO))
              .thenReturn(PropertyMapper.registerPropertyDTO(propertyDTO));

      // Act
      ResponseEntity<RegisteredPropertyDTO> receivedRegister = propertyController.registerProperty(propertyDTO);

      // Assert
      Assertions.assertEquals(HttpStatus.CREATED, receivedRegister.getStatusCode());
      Assertions.assertEquals(propertyDTO.getProperty_id(), receivedRegister.getBody().getId_property());
      Assertions.assertEquals(messageExpected, receivedRegister.getBody().getMessage());

      Mockito.verify(iPropertyService, Mockito.atLeastOnce()).registerProperty(propertyDTO);
   }

   @Test
   public void totalMetersProperty() {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      TotalSquareMetersPropertyDTO expectedTotal = new TotalSquareMetersPropertyDTO(propertyDTO.getProp_name(), 3000);
      Mockito.when(iPropertyService.totalMetersProperty(propertyDTO.getProperty_id())).thenReturn(expectedTotal);

      // Act
      ResponseEntity<TotalSquareMetersPropertyDTO> receivedTotal = propertyController.totalMetersProperty(propertyDTO.getProperty_id());

      // Assert
      Assertions.assertEquals(HttpStatus.OK, receivedTotal.getStatusCode());
      Assertions.assertEquals(expectedTotal.getProperty_name(), receivedTotal.getBody().getProperty_name());
      Assertions.assertEquals(expectedTotal.getTotal_square_meters(), receivedTotal.getBody().getTotal_square_meters());

      Mockito.verify(iPropertyService, Mockito.atLeastOnce()).totalMetersProperty(propertyDTO.getProperty_id());
   }

   @Test
   public void valueTotalProperty() {
      // Arrange
      double valueTotal = 3988800.0;
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      Mockito.when(iPropertyService.valueTotalProperty(propertyDTO.getProperty_id()))
              .thenReturn(PropertyMapper.valueTotalPropertyDTO(propertyDTO, valueTotal));

      // Act
      ResponseEntity<PropertyValueDTO> receivedValue = propertyController.valueTotalProperty(propertyDTO.getProperty_id());

      // Assert
      Assertions.assertEquals(HttpStatus.OK, receivedValue.getStatusCode());
      Assertions.assertEquals(valueTotal, receivedValue.getBody().getProperty_value());
      Assertions.assertEquals(propertyDTO.getProp_name(), receivedValue.getBody().getProperty_name());
      Assertions.assertEquals(propertyDTO.getDistrict().getDistrict_name(), receivedValue.getBody().getDistrict_name());

      Mockito.verify(iPropertyService, Mockito.atLeastOnce()).valueTotalProperty(propertyDTO.getProperty_id());
   }

   @Test
   public void biggestRoomProperty() {
      // Arrange
      EnvironmentDTO bigRoom = TestUtilGenerator.getRoom().get(0);
      double squareMeters = bigRoom.getRoom_length() * bigRoom.getRoom_width();

      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      Mockito.when(iPropertyService.bigRoomProperty(propertyDTO.getProperty_id()))
              .thenReturn(PropertyMapper.biggerRoomPropertyDTO(bigRoom));

      // Act
      ResponseEntity<BiggestEnvironmentDTO> receivedBigRoom = propertyController.bigRoomProperty(propertyDTO.getProperty_id());

      // Assert
      Assertions.assertEquals(HttpStatus.OK, receivedBigRoom.getStatusCode());
      Assertions.assertEquals(bigRoom.getRoom_name(), receivedBigRoom.getBody().getRoom_name());
      Assertions.assertEquals(squareMeters, receivedBigRoom.getBody().getTotal_meters_room());

      Mockito.verify(iPropertyService, Mockito.atLeastOnce()).bigRoomProperty(propertyDTO.getProperty_id());
   }

   @Test
   public void listRoomWithMetersProperty() {
      // Arrange
      List<EnvironmentDTO> listRooms = TestUtilGenerator.getRoom();
      double squareMeters1 = listRooms.get(0).getRoom_length() * listRooms.get(0).getRoom_width();

      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      Mockito.when(iPropertyService.listRoomsMetersProperty(propertyDTO.getProperty_id()))
              .thenReturn(PropertyMapper.listMetersRoomDTO(listRooms));

      // Act
      ResponseEntity<List<BiggestEnvironmentDTO>> receivedListRooms = propertyController.listRoomsWithMetersProperty(propertyDTO.getProperty_id());

      // Assert
      Assertions.assertEquals(HttpStatus.OK, receivedListRooms.getStatusCode());
      Assertions.assertEquals(listRooms.size(), receivedListRooms.getBody().size());
      Assertions.assertEquals(squareMeters1, receivedListRooms.getBody().get(0).getTotal_meters_room());

      Mockito.verify(iPropertyService, Mockito.atLeastOnce()).listRoomsMetersProperty(propertyDTO.getProperty_id());
   }

   @Test
   public void DistrictNotFoundException() {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(2);
      Mockito.when(iPropertyService.totalMetersProperty(propertyDTO.getProperty_id()))
              .thenThrow(new DistrictNotFoundException(propertyDTO.getDistrict().getDistrict_name()));

      // Act
      try {
         propertyController.totalMetersProperty(propertyDTO.getProperty_id());
      } catch (DistrictNotFoundException d) { // Assert
         Assertions.assertEquals(HttpStatus.NOT_FOUND, d.getHttpStatus());
         Assertions.assertEquals("The district " + propertyDTO.getDistrict().getDistrict_name() + " not exist in the database",
                 d.getError().getMessage());
         Assertions.assertEquals("DistrictNotFoundException", d.getError().getName());

         Mockito.verify(iPropertyService, Mockito.atLeastOnce()).totalMetersProperty(propertyDTO.getProperty_id());
      }
   }

   @Test
   public void PropertyNotFoundException() {
      // Arrange
      int id_not_found = 999;
      Mockito.when(iPropertyService.totalMetersProperty(id_not_found))
              .thenThrow(new PropertyNotFoundException(id_not_found));

      // Act
      try {
         propertyController.totalMetersProperty(id_not_found);
      } catch (PropertyNotFoundException p) { // Assert
         Assertions.assertEquals(HttpStatus.BAD_REQUEST, p.getHttpStatus());
         Assertions.assertEquals("Property with ID: " + id_not_found + " is no registered yet",
                 p.getError().getMessage());
         Assertions.assertEquals("PropertyNotFoundException", p.getError().getName());

         Mockito.verify(iPropertyService, Mockito.atLeastOnce()).totalMetersProperty(id_not_found);
      }
   }

   @Test
   public void RatioSizeDimensionsException() {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getPropertyWithInvalidDimensions();
      Mockito.when(iPropertyService.registerProperty(propertyDTO))
              .thenThrow(new RatioSizePropertyInvalidException());

      // Act
      try {
         propertyController.registerProperty(propertyDTO);
      } catch (RatioSizePropertyInvalidException r) { // Assert
         Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getHttpStatus());
         Assertions.assertEquals("Dimensions of the total property and the main rooms is not valid",
                 r.getError().getMessage());
         Assertions.assertEquals("RatioSizePropertyInvalidException", r.getError().getName());

         Mockito.verify(iPropertyService, Mockito.atLeastOnce()).registerProperty(propertyDTO);
      }
   }
}
