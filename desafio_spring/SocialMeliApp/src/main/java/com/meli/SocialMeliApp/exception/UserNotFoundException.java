package com.meli.SocialMeliApp.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{

   public UserNotFoundException(Integer userId) {
      super("User  "+ userId+ " not found :( ", HttpStatus.BAD_REQUEST);
   }
}
