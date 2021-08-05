package com.meli.SocialMeliApp.exception.UserException;

import org.springframework.http.HttpStatus;

public class UserAutoUnfollowException extends UserException{
   public UserAutoUnfollowException() {
      super("El usuario no puede darse unfollow a el mismo ", HttpStatus.BAD_REQUEST);
   }
}
