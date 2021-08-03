package com.meli.LinkTrackerAPI.exception;

import org.springframework.http.HttpStatus;

public class PasswordIncorrectException extends LinkException{

   public PasswordIncorrectException() {
      super("La contraseña es incorrecta", HttpStatus.BAD_REQUEST);
   }
}
