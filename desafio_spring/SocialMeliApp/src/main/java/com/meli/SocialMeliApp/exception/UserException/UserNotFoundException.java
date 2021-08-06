package com.meli.SocialMeliApp.exception.UserException;

import com.meli.SocialMeliApp.exception.SocialGeneralException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends SocialGeneralException {

   public UserNotFoundException(Integer userId) {
      super("User  "+ userId+ " not found :( ", HttpStatus.BAD_REQUEST);
   }
}
