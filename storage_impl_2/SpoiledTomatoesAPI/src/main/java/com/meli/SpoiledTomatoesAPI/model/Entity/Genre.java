package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "genres")
public class Genre extends BaseEntity{

   @Column(name = "name")
   private String name;

   @Column(name = "ranking", unique = true)
   private Integer ranking;

   @Column(name = "active")
   private Integer active;

   // --- Relations ---
   @OneToMany(mappedBy = "genreOfMovie")
   private Set<Movie> movieLinkGenre;

   @OneToMany(mappedBy = "genreOfSerie")
   private Set<Serie> serieLinkGenre;
}
