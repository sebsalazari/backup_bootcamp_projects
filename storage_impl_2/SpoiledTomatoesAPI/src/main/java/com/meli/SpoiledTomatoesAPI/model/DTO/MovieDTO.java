package com.meli.SpoiledTomatoesAPI.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
   private Long id;
   private String title;
   private Double rating;
   private Integer awards;
   private LocalDate releaseDate;
   private Integer length;
   private Long genreId;
}
