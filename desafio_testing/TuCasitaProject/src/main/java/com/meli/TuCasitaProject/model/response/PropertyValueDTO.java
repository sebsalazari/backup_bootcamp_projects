package com.meli.TuCasitaProject.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValueDTO {
   private String property_name;
   private String district_name;
   private double property_value;
}
