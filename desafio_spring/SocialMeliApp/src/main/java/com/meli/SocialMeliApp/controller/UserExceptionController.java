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

   @ExceptionHandler(SelfFollowException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(SelfFollowException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(AlreadyFollowedException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(AlreadyFollowedException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(SelfUnfollowException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(SelfUnfollowException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(NotFollowedException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(NotFollowedException e) {
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }
}
