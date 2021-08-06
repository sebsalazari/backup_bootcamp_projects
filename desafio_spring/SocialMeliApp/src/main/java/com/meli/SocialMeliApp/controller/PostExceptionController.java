package com.meli.SocialMeliApp.controller;

import com.meli.SocialMeliApp.DTO.ErrorDTO;
import com.meli.SocialMeliApp.exception.PostException.RepeatedPostException;
import com.meli.SocialMeliApp.exception.PostException.InvalidPostByUserIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {

   @ExceptionHandler(RepeatedPostException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(RepeatedPostException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(InvalidPostByUserIdException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(InvalidPostByUserIdException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

}
