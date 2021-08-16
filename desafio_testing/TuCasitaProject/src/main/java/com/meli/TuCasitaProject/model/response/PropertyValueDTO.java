package com.meli.TuCasitaProject.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PropertyValueDTO {
   private String property_name;
   private String district_name;
   private double property_value;
}
