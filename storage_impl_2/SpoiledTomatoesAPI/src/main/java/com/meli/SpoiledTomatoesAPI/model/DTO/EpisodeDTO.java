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
public class EpisodeDTO {
   private Long id;
   private String title;
   private Integer number;
   private LocalDate releaseDate;
   private Double rating;
   private Long seasonId;
}
