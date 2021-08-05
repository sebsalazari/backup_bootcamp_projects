package com.meli.SocialMeliApp.controller;

import com.meli.SocialMeliApp.DTO.ErrorDTO;
import com.meli.SocialMeliApp.exception.PostException.PostIdRepeatException;
import com.meli.SocialMeliApp.exception.PostException.PostUserIdNoExistException;
import com.meli.SocialMeliApp.exception.PostException.UserHasNotPostException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {

   @ExceptionHandler(PostIdRepeatException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(PostIdRepeatException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(PostUserIdNoExistException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(PostUserIdNoExistException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(UserHasNotPostException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(UserHasNotPostException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }
}
