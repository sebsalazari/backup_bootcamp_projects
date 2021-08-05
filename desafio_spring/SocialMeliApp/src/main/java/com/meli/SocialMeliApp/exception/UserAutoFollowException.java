package com.meli.SocialMeliApp.exception;

import org.springframework.http.HttpStatus;

public class UserAutoFollowException extends UserException {
   public UserAutoFollowException() {
      super("El usuario no se puede seguir al mismo", HttpStatus.BAD_REQUEST);
   }
}
