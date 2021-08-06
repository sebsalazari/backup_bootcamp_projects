package com.meli.SocialMeliApp.exception.PostException;

import com.meli.SocialMeliApp.exception.SocialGeneralException;
import org.springframework.http.HttpStatus;

public class InvalidPostByUserIdException extends SocialGeneralException {
   public InvalidPostByUserIdException(Integer id) {
      super("User: " + id + " not found, impossible to post", HttpStatus.BAD_REQUEST);
   }
}
