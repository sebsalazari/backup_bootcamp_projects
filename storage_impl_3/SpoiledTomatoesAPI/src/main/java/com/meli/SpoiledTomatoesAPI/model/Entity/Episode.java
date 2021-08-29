package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "episodes")
public class Episode extends BaseEntity {

   @Column(name = "title")
   private String title;

   @Column(name = "number")
   private Integer number;

   @Column(name = "release_date", nullable = false)
   private LocalDate releaseDate;

   @Column(name = "rating")
   private Double rating;

   // --- Relations ---
   @ManyToMany(mappedBy = "episodesContainsActors")
   private Set<Actor> actorsInEpisodes;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "season_id", referencedColumnName = "id", nullable = false)
   private Season seasonContainsEpisode;
}
