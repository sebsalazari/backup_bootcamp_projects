package com.meli.DiplomasAPISpring.Exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor

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