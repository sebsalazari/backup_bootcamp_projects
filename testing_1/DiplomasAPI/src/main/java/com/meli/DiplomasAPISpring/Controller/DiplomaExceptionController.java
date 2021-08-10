package com.meli.DiplomasAPISpring.Controller;

import com.meli.DiplomasAPISpring.Exception.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DiplomaExceptionController {

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
