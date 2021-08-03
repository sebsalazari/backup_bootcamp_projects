package com.meli.LinkTrackerAPI.exception;

import org.springframework.http.HttpStatus;

public class URLInvalidException extends LinkException {

   public URLInvalidException(String url) {
      super("La URL -> " + url + " no es un link valido", HttpStatus.BAD_REQUEST);
   }

}
