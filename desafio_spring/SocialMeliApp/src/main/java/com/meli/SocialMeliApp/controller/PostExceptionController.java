package com.meli.SocialMeliApp.controller;

import com.meli.SocialMeliApp.DTO.ErrorDTO;
import com.meli.SocialMeliApp.exception.PostException.CategoryNotFoundException;
import com.meli.SocialMeliApp.exception.PostException.RepeatedPostException;
import com.meli.SocialMeliApp.exception.PostException.InvalidPostByUserIdException;
import com.meli.SocialMeliApp.exception.PostException.RepeatedProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {

   @ExceptionHandler(RepeatedPostException.class)
   protected ResponseEntity<ErrorDTO> repeatPostException(RepeatedPostException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(InvalidPostByUserIdException.class)
   protected ResponseEntity<ErrorDTO> invalidPostException(InvalidPostByUserIdException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(RepeatedProductException.class)
   protected ResponseEntity<ErrorDTO> repeatedProductException(RepeatedProductException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(CategoryNotFoundException.class)
   protected ResponseEntity<ErrorDTO> categoryNotFoundException(CategoryNotFoundException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

}
