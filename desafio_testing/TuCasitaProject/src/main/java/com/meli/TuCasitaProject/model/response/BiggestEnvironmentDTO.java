package com.meli.TuCasitaProject.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BiggestEnvironmentDTO {
   private String room_name;
   private double total_meters_room;
}
