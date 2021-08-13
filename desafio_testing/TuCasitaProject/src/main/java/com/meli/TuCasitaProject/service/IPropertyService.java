package com.meli.TuCasitaProject.service;

import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;

public interface IPropertyService {
   RegisteredPropertyDTO registerProperty(PropertyDTO propertyDTO);
}
