package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "movies")
public class Movie {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "created_at")
   private LocalDateTime createdAt;

   @Column(name = "updated_at")
   private LocalDateTime updateAt;

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

}
