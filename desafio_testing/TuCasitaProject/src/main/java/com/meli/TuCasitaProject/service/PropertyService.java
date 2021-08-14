package com.meli.TuCasitaProject.service;

import com.meli.TuCasitaProject.exception.district.DistrictNotFoundException;
import com.meli.TuCasitaProject.exception.property.RatioSizePropertyInvalidException;
import com.meli.TuCasitaProject.mapper.PropertyMapper;
import com.meli.TuCasitaProject.model.DistrictDTO;
import com.meli.TuCasitaProject.model.EnvironmentDTO;
import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.BiggestEnvironmentDTO;
import com.meli.TuCasitaProject.model.response.PropertyValueDTO;
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
         validationRatioSizeDimensions(propertyDTO);
         propertyDTO.setProperty_id(generateIdProperty());
         iPropertyRepository.saveProperty(propertyDTO);

         return PropertyMapper.registerPropertyDTO(propertyDTO);
      } else throw new DistrictNotFoundException(propertyDTO.getDistrict().getDistrict_name());
   }

   @Override
   public TotalSquareMetersPropertyDTO totalMetersProperty(int property_id) {
      PropertyDTO propertyDTO = iPropertyRepository.getProperty(property_id);
      return new TotalSquareMetersPropertyDTO(propertyDTO.getProp_name(),
              calculateTotalSquareMeters(propertyDTO));
   }

   @Override
   public PropertyValueDTO valueTotalProperty(int property_id) {
      PropertyDTO propertyDTO = iPropertyRepository.getProperty(property_id);
      double built = calculateTotalSquareMetersForEnvironments(propertyDTO.getEnvironments());
      double noBuilt = calculateMetersNotBuild(propertyDTO, built);

      return PropertyMapper.valueTotalPropertyDTO(propertyDTO,
              calculateValueProperty(propertyDTO.getDistrict(), built, noBuilt));
   }

   @Override
   public BiggestEnvironmentDTO bigRoomProperty(int property_id) {
      PropertyDTO propertyDTO = iPropertyRepository.getProperty(property_id);
      return PropertyMapper.biggerRoomPropertyDTO(biggestRoom(propertyDTO.getEnvironments()));
   }

   @Override
   public List<BiggestEnvironmentDTO> listRoomsMetersProperty(int property_id) {
      PropertyDTO propertyDTO = iPropertyRepository.getProperty(property_id);
      return PropertyMapper.listMetersRoomDTO(propertyDTO.getEnvironments());
   }

   public int generateIdProperty() {
      UUID uuid = UUID.randomUUID();
      long highBits = uuid.getMostSignificantBits();
      return Math.abs((int) highBits / 100000);
   }

   public double calculateTotalSquareMeters(PropertyDTO propertyDTO) {
      return propertyDTO.getProp_land_width() * propertyDTO.getProp_land_length();
   }

   public double calculateTotalSquareMetersForEnvironments(List<EnvironmentDTO> environments) {
      return environments.stream().mapToDouble(e -> e.getRoom_width() * e.getRoom_length()).sum();
   }

   public double calculateMetersNotBuild(PropertyDTO propertyDTO, double built) {
      return calculateTotalSquareMeters(propertyDTO) - built;
   }

   public double calculateValueProperty(DistrictDTO districtDTO, double builtMeters, double noBuiltMeters) {
      return (builtMeters * districtDTO.getDistrict_built_price()) +
              (noBuiltMeters * districtDTO.getDistrict_unbuilt_price());
   }

   public EnvironmentDTO biggestRoom(List<EnvironmentDTO> environments) {
      EnvironmentDTO environment = null;
      double aux = 0;
      for (EnvironmentDTO e : environments) {
         if ((e.getRoom_width() * e.getRoom_length() > aux)) {
            aux = e.getRoom_width() * e.getRoom_length();
            environment = e;
         }
      }

      return environment;
   }

   public void validationRatioSizeDimensions(PropertyDTO p) {
      if (calculateTotalSquareMetersForEnvironments(p.getEnvironments()) > calculateTotalSquareMeters(p))
         throw new RatioSizePropertyInvalidException();
   }
}
