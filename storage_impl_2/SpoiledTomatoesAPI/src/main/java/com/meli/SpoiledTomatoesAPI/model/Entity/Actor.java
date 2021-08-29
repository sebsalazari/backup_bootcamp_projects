package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "actors")
public class Actor extends BaseEntity{

   @Column(name = "first_name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "rating")
   private Double rating;

   // --- Relations ---
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(
           name = "actor_movie",
           joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id")
   )
   private Set<Movie> moviesContainsActors;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
   private Movie favoriteMovie;

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(
           name = "actor_episode",
           joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "episode_id", referencedColumnName = "id")
   )
   private Set<Episode> episodesContainsActors;

}
