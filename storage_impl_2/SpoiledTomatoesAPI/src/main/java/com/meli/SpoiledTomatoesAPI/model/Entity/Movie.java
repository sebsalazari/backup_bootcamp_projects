package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "movies")
public class Movie extends BaseEntity {

   @Column(name = "title")
   private String title;

   @Column(name = "rating")
   private Double rating;

   @Column(name = "awards")
   private Integer awards;

   @Column(name = "release_date")
   private LocalDate releaseDate;

   @Column(name = "length")
   private Integer length;

   // --- Relations ---
   @ManyToMany(mappedBy = "moviesContainsActors")
   private Set<Actor> actorsInMovies;

   @OneToMany(mappedBy = "favoriteMovie")
   private Set<Actor> actorsWithFavoriteMovie;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "genre_id", referencedColumnName = "id")
   private Genre genreOfMovie;
}
