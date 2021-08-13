package com.meli.TuCasitaProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {

   @NotBlank(message = "El nombre de la propiedad no puede estar vacío")
   @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
           message = "El nombre de la propiedad debe comenzar con mayúscula.")
   @Size(max = 10, message = "La longitud del nombre no puede superar los 30 caracteres.")
   private String prop_name;

   @NotNull(message = "El ancho del terreno no puede estar vacío.")
   @DecimalMax(value = "75.0", message = "El máximo ancho permitido por terreno es de 75 mts")
   private double prop_land_width;

   @NotNull(message = "El largo del terreno no puede estar vacío.")
   @DecimalMax(value = "100.0", message = "El máximo largo permitido por terreno es de 100 mts")
   private double prop_land_length;

   @NotNull(message = "El barrio no puede estar vacio")
   @Valid
   private DistrictDTO district;

   @NotNull(message = "La lista de ambientes no puede estar vacio")
   private List<@Valid EnvironmentDTO> environments;

}
