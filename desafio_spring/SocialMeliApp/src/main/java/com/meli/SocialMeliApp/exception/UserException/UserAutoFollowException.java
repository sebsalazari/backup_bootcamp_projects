package com.meli.SocialMeliApp.exception.UserException;

import com.meli.SocialMeliApp.exception.UserException.UserException;
import org.springframework.http.HttpStatus;

public class UserAutoFollowException extends UserException {
   public UserAutoFollowException() {
      super("El usuario no se puede seguir al mismo", HttpStatus.BAD_REQUEST);
   }
}
