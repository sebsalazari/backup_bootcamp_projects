package com.meli.SocialMeliApp.exception;

import org.springframework.http.HttpStatus;

public class PostIdRepeatException extends PostException {

   public PostIdRepeatException(Integer id) {
      super("The post with ID: " + id + " already exists", HttpStatus.BAD_REQUEST);
   }
}
