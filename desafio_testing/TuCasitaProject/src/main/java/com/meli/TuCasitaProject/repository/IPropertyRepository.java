package com.meli.TuCasitaProject.repository;

import com.meli.TuCasitaProject.model.DistrictDTO;
import com.meli.TuCasitaProject.model.PropertyDTO;

public interface IPropertyRepository {
   void saveProperty(PropertyDTO propertyDTO);
   boolean existsDistrict(DistrictDTO districtDTO);
}
