package com.meli.TuCasitaProject.exception.property;

import com.meli.TuCasitaProject.exception.PropertyGeneralException;
import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyGeneralException {

   public PropertyNotFoundException(int id) {
      super("Property with ID: " + id + " is no registered yet", HttpStatus.BAD_REQUEST);
   }
}
