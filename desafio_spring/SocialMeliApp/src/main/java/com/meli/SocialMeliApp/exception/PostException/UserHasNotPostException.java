package com.meli.SocialMeliApp.exception.PostException;

import org.springframework.http.HttpStatus;

public class UserHasNotPostException extends PostException{
   public UserHasNotPostException() {
      super("El usuario aun no ha hecho publicaciones o no existe", HttpStatus.BAD_REQUEST);
   }
}
