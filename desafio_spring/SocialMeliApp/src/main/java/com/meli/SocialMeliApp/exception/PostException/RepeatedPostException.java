package com.meli.SocialMeliApp.exception.PostException;

import com.meli.SocialMeliApp.exception.SocialGeneralException;
import org.springframework.http.HttpStatus;

public class RepeatedPostException extends SocialGeneralException {

   public RepeatedPostException(Integer id) {
      super("The post with ID: " + id + " already exists", HttpStatus.BAD_REQUEST);
   }
}
