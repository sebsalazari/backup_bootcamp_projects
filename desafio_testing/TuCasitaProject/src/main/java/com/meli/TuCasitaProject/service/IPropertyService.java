package com.meli.TuCasitaProject.service;

import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.BiggestEnvironmentDTO;
import com.meli.TuCasitaProject.model.response.PropertyValueDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;
import com.meli.TuCasitaProject.model.response.TotalSquareMetersPropertyDTO;

public interface IPropertyService {
   RegisteredPropertyDTO registerProperty(PropertyDTO propertyDTO);

   TotalSquareMetersPropertyDTO totalMetersProperty(int property_id);

   PropertyValueDTO valueTotalProperty(int property_id);

   BiggestEnvironmentDTO bigRoomProperty (int property_id);
}
