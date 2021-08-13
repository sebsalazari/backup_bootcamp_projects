package com.meli.TuCasitaProject.service;

import com.meli.TuCasitaProject.exception.district.DistrictNotFoundException;
import com.meli.TuCasitaProject.mapper.PropertyMapper;
import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;
import com.meli.TuCasitaProject.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PropertyService implements IPropertyService {

   @Autowired
   IPropertyRepository iPropertyRepository;

   @Override
   public RegisteredPropertyDTO registerProperty(PropertyDTO propertyDTO) {
      if (iPropertyRepository.existsDistrict(propertyDTO.getDistrict())) {
         propertyDTO.setProperty_id(generateIdProperty());
         iPropertyRepository.saveProperty(propertyDTO);
         return PropertyMapper.registerPropertyDTO(propertyDTO);
      } else throw new DistrictNotFoundException(propertyDTO.getDistrict().getDistrict_name());
   }

   public int generateIdProperty() {
      UUID uuid = UUID.randomUUID();
      long highBits = uuid.getMostSignificantBits();
      return Math.abs((int) highBits / 100000);
   }
}
