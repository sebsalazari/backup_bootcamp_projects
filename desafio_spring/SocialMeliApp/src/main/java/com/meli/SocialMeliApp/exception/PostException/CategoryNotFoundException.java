package com.meli.SocialMeliApp.exception.PostException;

import com.meli.SocialMeliApp.exception.SocialGeneralException;
import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends SocialGeneralException {
   public CategoryNotFoundException(Integer id) {
      super("There are no promotional products for the category: " + id + " :(", HttpStatus.NOT_FOUND);
   }
}
