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
public class SerieDTO {
   private Long id;
   private String title;
   private LocalDate releaseDate;
   private LocalDate endDate;
   private Long genreId;
}
