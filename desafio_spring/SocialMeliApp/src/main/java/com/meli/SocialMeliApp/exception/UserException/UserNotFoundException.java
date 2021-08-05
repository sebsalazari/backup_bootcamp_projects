package com.meli.SocialMeliApp.exception.UserException;

import com.meli.SocialMeliApp.exception.UserException.UserException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {

   public UserNotFoundException(Integer userId) {
      super("User  "+ userId+ " not found :( ", HttpStatus.BAD_REQUEST);
   }
}
