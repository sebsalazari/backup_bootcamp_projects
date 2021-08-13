package com.meli.TuCasitaProject.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.TuCasitaProject.exception.district.DistrictNotFoundException;
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
   // Almaceno en esta lista los barrios dispoibles y que voy a validar
   private List<String> districtListDB = loadDistrictsValid();

   // Almaceno enn esta lista las propiedades que vayan llegando por request y tener persistencia
   private List<PropertyDTO> propertyListDB = new ArrayList<>();

   @Override
   public void saveProperty(PropertyDTO propertyDTO) {
      if (existsDistrict(propertyDTO.getDistrict()))
         propertyListDB.add(propertyDTO);
   }

   @Override
   public boolean existsDistrict(DistrictDTO districtDTO) {
      if (districtListDB.contains(districtDTO.getDistrict_name()))
         return true;
      else throw new DistrictNotFoundException(districtDTO.getDistrict_name());
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
