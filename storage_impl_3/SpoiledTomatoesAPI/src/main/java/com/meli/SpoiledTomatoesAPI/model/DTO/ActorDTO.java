package com.meli.SpoiledTomatoesAPI.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {
   private Long id;
   private String firstName;
   private String lastName;
   private Double rating;
   private Long favoriteMovieId;
}
