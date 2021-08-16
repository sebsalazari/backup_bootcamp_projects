package com.meli.TuCasitaProject.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TotalSquareMetersPropertyDTO {
   private String property_name;
   private double total_square_meters;
}
