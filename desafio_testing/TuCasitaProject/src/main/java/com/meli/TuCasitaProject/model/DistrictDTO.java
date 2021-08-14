package com.meli.TuCasitaProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class DistrictDTO {

   @NotBlank(message = "El barrio no puede estar vacio")
   @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
   private String district_name;

   @NotNull(message = "El precio del metro cuadrado construido de un barrio no puede estar vacío")
   @DecimalMax(value = "4000.0", message = "El precio máximo permitido por metro cuadrado construido no puede superar los 4000 U$S.")
   @Positive(message = "El precio cosntruido no puede ser negativo")
   private double district_built_price;

   @NotNull(message = "El precio del metro cuadrado no construido de un barrio no puede estar vacío.")
   @DecimalMax(value = "1000.0", message = "El precio máximo permitido por metro cuadrado no construido no puede superar los 1000 U$S.")
   @Positive(message = "El precio no construido no puede ser negativo")
   private double district_unbuilt_price;
}
