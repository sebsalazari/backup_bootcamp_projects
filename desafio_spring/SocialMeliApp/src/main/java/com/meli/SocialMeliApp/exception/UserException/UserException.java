package com.meli.SocialMeliApp.exception.UserException;

import com.meli.SocialMeliApp.DTO.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends RuntimeException{
   private ErrorDTO error;
   private HttpStatus httpStatus;

   public UserException(String message, HttpStatus status) {
      this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
      this.httpStatus = status;
   }

}
