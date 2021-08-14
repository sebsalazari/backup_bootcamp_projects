package com.meli.TuCasitaProject.service;

import com.meli.TuCasitaProject.exception.district.DistrictNotFoundException;
import com.meli.TuCasitaProject.mapper.PropertyMapper;
import com.meli.TuCasitaProject.model.EnvironmentDTO;
import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;
import com.meli.TuCasitaProject.model.response.TotalSquareMetersPropertyDTO;
import com.meli.TuCasitaProject.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

   @Override
   public TotalSquareMetersPropertyDTO totalMetersProperty(int property_id) {
      PropertyDTO propertyDTO = iPropertyRepository.getProperty(property_id);
      return new TotalSquareMetersPropertyDTO(propertyDTO.getProp_name(),
              calculateTotalSquareMeters(propertyDTO.getEnvironments()));
   }

   public int generateIdProperty() {
      UUID uuid = UUID.randomUUID();
      long highBits = uuid.getMostSignificantBits();
      return Math.abs((int) highBits / 100000);
   }

   public double calculateTotalSquareMeters(List<EnvironmentDTO> environments) {
      return environments.stream().mapToDouble(e -> e.getRoom_width() * e.getRoom_length()).sum();
   }
}
