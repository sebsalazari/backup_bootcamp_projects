package com.meli.TuCasitaProject.controller;

import com.meli.TuCasitaProject.exception.district.DistrictNotFoundException;
import com.meli.TuCasitaProject.exception.property.PropertyNotFoundException;
import com.meli.TuCasitaProject.model.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {

   // Excepciones personalizadas
   @ExceptionHandler(DistrictNotFoundException.class)
   protected ResponseEntity<ErrorDTO> handleDistrictNotFoundExceptions(DistrictNotFoundException e) {
      return new ResponseEntity<>(e.getError(), HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(PropertyNotFoundException.class)
   protected ResponseEntity<ErrorDTO> handlePropertyNotFoundExceptions(PropertyNotFoundException e) {
      return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
   }

   // Excepciones para las validaciones de entrada
   @ExceptionHandler(MethodArgumentNotValidException.class)
   protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
      ErrorDTO error = new ErrorDTO(e.getClass().getSimpleName(), e.getBindingResult().getAllErrors());
      return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
   }

   @ExceptionHandler(HttpMessageNotReadableException.class)
   protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
      ErrorDTO error = new ErrorDTO(e.getClass().getSimpleName(), e.getMessage());
      return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
   }
}
