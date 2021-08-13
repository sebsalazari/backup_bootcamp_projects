package com.meli.TuCasitaProject.exception.district;

import com.meli.TuCasitaProject.exception.PropertyGeneralException;
import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends PropertyGeneralException {

   public DistrictNotFoundException(String district) {
      super("The district " + district + " not exist in the database", HttpStatus.NOT_FOUND);
   }
}
