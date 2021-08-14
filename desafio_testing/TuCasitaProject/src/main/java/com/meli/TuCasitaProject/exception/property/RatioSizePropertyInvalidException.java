package com.meli.TuCasitaProject.exception.property;

import com.meli.TuCasitaProject.exception.PropertyGeneralException;
import org.springframework.http.HttpStatus;

public class RatioSizePropertyInvalidException extends PropertyGeneralException {

   public RatioSizePropertyInvalidException() {
      super("Dimensions of the total property and the main rooms is not valid", HttpStatus.BAD_REQUEST);
   }
}
