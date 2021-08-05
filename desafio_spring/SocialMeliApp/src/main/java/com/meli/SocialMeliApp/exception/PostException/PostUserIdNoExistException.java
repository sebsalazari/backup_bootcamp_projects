package com.meli.SocialMeliApp.exception.PostException;

import com.meli.SocialMeliApp.exception.PostException.PostException;
import org.springframework.http.HttpStatus;

public class PostUserIdNoExistException extends PostException {
   public PostUserIdNoExistException(Integer id) {
      super("El Usuario: " + id + " no existe", HttpStatus.BAD_REQUEST);
   }
}
