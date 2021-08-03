package com.meli.LinkTrackerAPI.controller;

import com.meli.LinkTrackerAPI.exception.LinkIdInvalidException;
import com.meli.LinkTrackerAPI.exception.PasswordIncorrectException;
import com.meli.LinkTrackerAPI.exception.URLInvalidException;
import com.meli.LinkTrackerAPI.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionController {

   @ExceptionHandler(URLInvalidException.class)
   protected ResponseEntity<ErrorDTO> URLGlobalException(URLInvalidException e) {
      e.printStackTrace();
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(LinkIdInvalidException.class)
   protected ResponseEntity<ErrorDTO> LinkIdInvalidGlobalException(LinkIdInvalidException e) {
      e.printStackTrace();
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }

   @ExceptionHandler(PasswordIncorrectException.class)
   protected ResponseEntity<ErrorDTO> PasswordInvalidGlobalException(PasswordIncorrectException e) {
      e.printStackTrace();
      return new ResponseEntity<>(e.getError(), e.getHttpStatus());
   }
}
