package com.meli.TuCasitaProject.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalSquareMetersPropertyDTO {
   private String property_name;
   private double total_square_meters;
}
