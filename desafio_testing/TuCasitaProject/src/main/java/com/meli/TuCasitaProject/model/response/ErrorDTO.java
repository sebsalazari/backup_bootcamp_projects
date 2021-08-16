package com.meli.TuCasitaProject.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
   private String name;
   private String message;
   private Map<String, String> messages;

   // Constructor para listar todos lo errores de la validacion y no solo uno
   public ErrorDTO(String name, List<ObjectError> errors) {
      this.name = name;
      messages = new HashMap<>();

      errors.forEach((error) -> {
         String fieldName = ((FieldError) error).getField();
         String errorMessage = error.getDefaultMessage();
         messages.put(fieldName, errorMessage);
      });
   }

   public ErrorDTO(String name, String message) {
      this.name = name;
      this.message = message;
   }
}