package com.meli.TuCasitaProject.unit.service;

import com.meli.TuCasitaProject.exception.district.DistrictNotFoundException;
import com.meli.TuCasitaProject.exception.property.PropertyNotFoundException;
import com.meli.TuCasitaProject.exception.property.RatioSizePropertyInvalidException;
import com.meli.TuCasitaProject.mapper.PropertyMapper;
import com.meli.TuCasitaProject.model.EnvironmentDTO;
import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.BiggestEnvironmentDTO;
import com.meli.TuCasitaProject.model.response.PropertyValueDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;
import com.meli.TuCasitaProject.model.response.TotalSquareMetersPropertyDTO;
import com.meli.TuCasitaProject.repository.IPropertyRepository;
import com.meli.TuCasitaProject.service.PropertyService;
import com.meli.TuCasitaProject.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

   @Mock
   IPropertyRepository iPropertyRepository;

   @InjectMocks
   PropertyService propertyService;

   @Test
   public void registerProperty() {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      RegisteredPropertyDTO expectedProperty = PropertyMapper.registerPropertyDTO(propertyDTO);
      Mockito.when(iPropertyRepository.existsDistrict(propertyDTO.getDistrict())).thenReturn(true);
      Mockito.doNothing().when(iPropertyRepository).saveProperty(propertyDTO);

      // Act
      RegisteredPropertyDTO receivedProperty = propertyService.registerProperty(propertyDTO);

      // Assert
      Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).saveProperty(propertyDTO);
      Assertions.assertEquals(expectedProperty.getMessage(), receivedProperty.getMessage());
   }

   @Test
   public void registerPropertyInvalidDimensionsException() {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getPropertyWithInvalidDimensions();
      Mockito.when(iPropertyRepository.existsDistrict(propertyDTO.getDistrict())).thenReturn(true);

      // Act

      // Assert
      Assertions.assertThrows(RatioSizePropertyInvalidException.class, () -> propertyService.registerProperty(propertyDTO));
   }

   @Test
   public void registerPropertyDistrictNotFound() {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(2);
      Mockito.when(iPropertyRepository.existsDistrict(propertyDTO.getDistrict())).thenReturn(false);
      // Act

      // Assert
      Assertions.assertThrows(DistrictNotFoundException.class, () -> propertyService.registerProperty(propertyDTO));
   }

   @Test
   public void getPropertyNice() {
      // Arrange
      int id_property = 123;
      Mockito.when(iPropertyRepository.getProperty(id_property)).thenReturn(TestUtilGenerator.getProperty().get(0));

      // Act
      PropertyDTO receivedProperty = iPropertyRepository.getProperty(id_property);

      // Assert
      Assertions.assertEquals(id_property, receivedProperty.getProperty_id());
   }

   @Test
   public void getPropertyNotFound() {
      // Arrange
      int id_not_found = 999;
      Mockito.when(iPropertyRepository.getProperty(id_not_found)).thenThrow(PropertyNotFoundException.class);

      // Act

      // Assert
      Assertions.assertThrows(PropertyNotFoundException.class, () -> iPropertyRepository.getProperty(id_not_found));
   }

   @Test
   public void totalSquareMetersProperty() {
      // Arrange
      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      double metersSquareTotal = propertyDTO.getProp_land_length() * propertyDTO.getProp_land_width();
      Mockito.when(iPropertyRepository.getProperty(propertyDTO.getProperty_id())).thenReturn(propertyDTO);

      // Act
      TotalSquareMetersPropertyDTO receivedTotal = propertyService.totalMetersProperty(propertyDTO.getProperty_id());

      // Assert
      Assertions.assertEquals(metersSquareTotal, receivedTotal.getTotal_square_meters());
      Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).getProperty(propertyDTO.getProperty_id());
   }

   @Test
   public void valueTotalProperty() {
      // Arrange
      double expectedPropertyPrice = 3988800.0;

      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      PropertyValueDTO expectedPropertyValue = PropertyMapper.valueTotalPropertyDTO(propertyDTO, expectedPropertyPrice);

      Mockito.when(iPropertyRepository.getProperty(propertyDTO.getProperty_id())).thenReturn(propertyDTO);

      // Act
      PropertyValueDTO receivedPropertyValue = propertyService.valueTotalProperty(propertyDTO.getProperty_id());

      // Assert
      Assertions.assertEquals(expectedPropertyValue.getProperty_value(), receivedPropertyValue.getProperty_value());
      Assertions.assertEquals(expectedPropertyValue.getProperty_name(), receivedPropertyValue.getProperty_name());

      Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).getProperty(propertyDTO.getProperty_id());
   }

   @Test
   public void biggerRoomProperty() {
      // Arrange
      EnvironmentDTO biggestRoom = TestUtilGenerator.getRoom().get(0);

      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      BiggestEnvironmentDTO expectedBigRoom = PropertyMapper.biggerRoomPropertyDTO(biggestRoom);

      Mockito.when(iPropertyRepository.getProperty(propertyDTO.getProperty_id())).thenReturn(propertyDTO);

      // Act
      BiggestEnvironmentDTO receivedBigRoom = propertyService.bigRoomProperty(propertyDTO.getProperty_id());

      // Assert
      Assertions.assertEquals(expectedBigRoom.getTotal_meters_room(), receivedBigRoom.getTotal_meters_room());
      Assertions.assertEquals(expectedBigRoom.getRoom_name(), receivedBigRoom.getRoom_name());

      Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).getProperty(propertyDTO.getProperty_id());
   }

   @Test
   public void listRoomsMetersProperty() {
      // Arrange
      List<EnvironmentDTO> listRooms = TestUtilGenerator.getRoom();

      PropertyDTO propertyDTO = TestUtilGenerator.getProperty().get(0);
      List<BiggestEnvironmentDTO> expectedCalculateListRooms = PropertyMapper.listMetersRoomDTO(listRooms);

      Mockito.when(iPropertyRepository.getProperty(propertyDTO.getProperty_id())).thenReturn(propertyDTO);

      // Act
      List<BiggestEnvironmentDTO> receivedCalculateListRooms= propertyService.listRoomsMetersProperty(propertyDTO.getProperty_id());

      // Assert
      Assertions.assertEquals(expectedCalculateListRooms.size(), receivedCalculateListRooms.size());
      Assertions.assertEquals(expectedCalculateListRooms.get(0).getTotal_meters_room(), receivedCalculateListRooms.get(0).getTotal_meters_room());
      Assertions.assertEquals(expectedCalculateListRooms.get(1).getTotal_meters_room(), receivedCalculateListRooms.get(1).getTotal_meters_room());
      Assertions.assertEquals(expectedCalculateListRooms.get(2).getTotal_meters_room(), receivedCalculateListRooms.get(2).getTotal_meters_room());

      Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).getProperty(propertyDTO.getProperty_id());
   }
}
