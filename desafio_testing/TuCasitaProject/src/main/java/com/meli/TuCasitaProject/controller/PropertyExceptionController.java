package com.meli.TuCasitaProject.controller;

import com.meli.TuCasitaProject.exception.district.DistrictNotFoundException;
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
      ErrorDTO error = new ErrorDTO(e.getClass().getSimpleName(), e.getMessage());
      return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
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
