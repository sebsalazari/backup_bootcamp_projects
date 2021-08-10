package com.meli.DiplomasAPISpring.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectDTO {

   @NotNull(message = "El nombre es obligatorio")
   @NotEmpty(message = "El nombre de la materia no puede estar vacío")
   @Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre de la materia debe comenzar con mayúscula")
   @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
   private String name;

   @NotNull(message = "La nota no puede estar vacío")
   @DecimalMax(value = "10.0", message = "La máxima nota es 10.0")
   @DecimalMin(value = "0.0", message = "La mínima nota es 0.0")
   private double score;
}
