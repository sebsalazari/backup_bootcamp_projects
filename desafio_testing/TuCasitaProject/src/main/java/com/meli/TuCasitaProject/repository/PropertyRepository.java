package com.meli.TuCasitaProject.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.TuCasitaProject.exception.property.PropertyNotFoundException;
import com.meli.TuCasitaProject.model.DistrictDTO;
import com.meli.TuCasitaProject.model.PropertyDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepository implements IPropertyRepository {
   // Almaceno en esta lista los barrios disponibles y que voy a validar
   private List<String> districtListDB = loadDistrictsValid();

   // Almaceno en esta lista las propiedades que vayan llegando por request y tener persistencia para el resto de consultas
   private List<PropertyDTO> propertyListDB = new ArrayList<>();

   @Override
   public void saveProperty(PropertyDTO propertyDTO) {
      propertyListDB.add(propertyDTO);
   }

   @Override
   public boolean existsDistrict(DistrictDTO districtDTO) {
      return districtListDB.contains(districtDTO.getDistrict_name());
   }

   @Override
   public PropertyDTO getProperty(int property_id) {
      return propertyListDB.stream()
              .filter(p -> p.getProperty_id() == property_id)
              .findAny()
              .orElseThrow(() -> new PropertyNotFoundException(property_id));
   }

   public static List<String> loadDistrictsValid() {
      List<String> districtList = new ArrayList<>();
      File file = null;

      try {
         file = ResourceUtils.getFile("classpath:districts.json");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }

      ObjectMapper mapper = new ObjectMapper();
      TypeReference<List<DistrictDTO>> typeDef = new TypeReference<>() {
      };

      try {
         List<DistrictDTO> districtList2 = mapper.readValue(file, typeDef);
         districtList2.forEach(d -> {
            districtList.add(d.getDistrict_name());
         });
      } catch (IOException e) {
         e.printStackTrace();
      }

      return districtList;
   }
}
