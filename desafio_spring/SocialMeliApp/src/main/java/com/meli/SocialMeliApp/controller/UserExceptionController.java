package com.meli.SocialMeliApp.controller;

import com.meli.SocialMeliApp.DTO.ErrorDTO;
import com.meli.SocialMeliApp.exception.UserException.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

   @ExceptionHandler(UserNotFoundException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(UserNotFoundException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(UserAutoFollowException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(UserAutoFollowException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(UserAlreadyFollowedException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(UserAlreadyFollowedException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(UserAutoUnfollowException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(UserAutoUnfollowException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(UserNotFollowedException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(UserNotFollowedException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }
}
