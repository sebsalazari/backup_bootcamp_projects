package com.meli.SocialMeliApp.exception.PostException;

import com.meli.SocialMeliApp.exception.SocialGeneralException;
import org.springframework.http.HttpStatus;

public class RepeatedProductException extends SocialGeneralException {

   public RepeatedProductException(Integer id) {
      super("The product with ID: " + id + " already exists", HttpStatus.BAD_REQUEST);
   }
}
