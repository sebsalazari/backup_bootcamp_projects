package com.meli.LinkTrackerAPI.exception;

import com.meli.LinkTrackerAPI.model.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkException extends RuntimeException {
   private ErrorDTO error;
   private HttpStatus httpStatus;

   public LinkException(String message, HttpStatus status) {
      this.error = new ErrorDTO(this.getClass().getSimpleName(), message);

      this.httpStatus = status;
   }
}
