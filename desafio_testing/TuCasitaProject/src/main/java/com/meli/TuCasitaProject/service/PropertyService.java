package com.meli.TuCasitaProject.service;

import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService {

   @Autowired
   IPropertyRepository iPropertyRepository;

   @Override
   public void registerProperty(PropertyDTO propertyDTO) {
      iPropertyRepository.saveProperty(propertyDTO);
   }
}
