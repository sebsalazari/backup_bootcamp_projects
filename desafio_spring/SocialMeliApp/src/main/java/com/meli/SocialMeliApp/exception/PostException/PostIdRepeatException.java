package com.meli.SocialMeliApp.exception.PostException;

import com.meli.SocialMeliApp.exception.PostException.PostException;
import org.springframework.http.HttpStatus;

public class PostIdRepeatException extends PostException {

   public PostIdRepeatException(Integer id) {
      super("The post with ID: " + id + " already exists", HttpStatus.BAD_REQUEST);
   }
}
