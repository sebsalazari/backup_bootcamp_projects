package com.meli.TuCasitaProject.unit.repository;

import com.meli.TuCasitaProject.exception.district.DistrictNotFoundException;
import com.meli.TuCasitaProject.exception.property.PropertyNotFoundException;
import com.meli.TuCasitaProject.model.DistrictDTO;
import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.repository.IPropertyRepository;
import com.meli.TuCasitaProject.repository.PropertyRepository;
import com.meli.TuCasitaProject.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class PropertyRepositoryTest {

   IPropertyRepository iPropertyRepository;

   @BeforeEach
   private void setUp() {
      this.iPropertyRepository = new PropertyRepository();
      this.iPropertyRepository.saveProperty(TestUtilGenerator.getProperty().get(0));
   }

   @Test
   public void saveProperty() {
      // Arrange
      PropertyDTO expectedProperty = TestUtilGenerator.getProperty().get(1);

      // Act
      iPropertyRepository.saveProperty(expectedProperty);

      // Assert
      Assertions.assertEquals(expectedProperty, iPropertyRepository.getProperty(expectedProperty.getProperty_id()));
   }

   @Test
   public void getProperty() {
      // Arrange
      PropertyDTO expectedProperty = TestUtilGenerator.getProperty().get(0);

      // Act
      PropertyDTO receivedProperty = iPropertyRepository.getProperty(123);

      // Assert
      Assertions.assertEquals(expectedProperty.getProp_name(), receivedProperty.getProp_name());
      Assertions.assertEquals(expectedProperty.getProperty_id(), receivedProperty.getProperty_id());
   }

   @Test
   public void getPropertyException() {
      // Arrange
      int property_id = 999;

      // Act

      // Assert
      Assertions.assertThrows(PropertyNotFoundException.class, () -> iPropertyRepository.getProperty(property_id));
   }

   @Test
   public void existDistrict() {
      // Arrange
      DistrictDTO expectedDistrict = TestUtilGenerator.getDistricts().get(0);

      // Act
      boolean received = iPropertyRepository.existsDistrict(expectedDistrict);

      // Assert
      Assertions.assertTrue(received);
   }

   @Test
   public void notExistDistrict() {
      // Arrange
      DistrictDTO expectedDistrict = TestUtilGenerator.getDistricts().get(2);

      // Act
      boolean received = iPropertyRepository.existsDistrict(expectedDistrict);

      // Assert
      Assertions.assertFalse(received);
   }

   @Test
   public void DistrictException() {
      // Arrange
      DistrictDTO district = TestUtilGenerator.getDistricts().get(2);

      // Assert
      try {
         iPropertyRepository.existsDistrict(district);
      } catch (DistrictNotFoundException d) {
         d.printStackTrace();
      }

   }

   @Test
   public void loadDistrictDB() {
      // Arrange
      File file = null;

      // Act
      try {
         file = ResourceUtils.getFile("classpath:districts.json");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }

      // Assert
      Assertions.assertNotNull(file);
   }

}
