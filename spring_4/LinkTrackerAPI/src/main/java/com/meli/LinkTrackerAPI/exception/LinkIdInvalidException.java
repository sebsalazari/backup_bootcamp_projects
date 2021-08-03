package com.meli.LinkTrackerAPI.exception;

import org.springframework.http.HttpStatus;

public class LinkIdInvalidException extends LinkException {

   public LinkIdInvalidException(String id) {
      super("El ID: " + id + " no es valido", HttpStatus.NOT_FOUND);
   }
}
