package com.meli.TuCasitaProject.exception;

import com.meli.TuCasitaProject.model.response.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyGeneralException extends RuntimeException {
   private ErrorDTO error;
   private HttpStatus httpStatus;

   public PropertyGeneralException(String message, HttpStatus status) {
      this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
      this.httpStatus = status;
   }
}
