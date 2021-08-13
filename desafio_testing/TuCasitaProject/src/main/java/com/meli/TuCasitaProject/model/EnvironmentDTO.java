package com.meli.TuCasitaProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {

   @NotBlank(message = "El nombre de ambiente no puede estar vacio")
   @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
           message = "El nombre de ambiente debe comenzar con mayúscula.")
   @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
   private String room_name;

   @NotNull(message = "El ancho del ambiente no puede estar vacío")
   @DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts")
   private double room_width;

   @NotNull(message = "El largo del ambiente no puede estar vacío")
   @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts")
   private double room_length;
}
