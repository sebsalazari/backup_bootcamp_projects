package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "episodes")
public class Episode {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "created_at")
   private LocalDateTime createdAt;

   @Column(name = "updated_at")
   private LocalDateTime updateAt;

   @Column(name = "title")
   private String title;

   @Column(name = "number")
   private Integer number;

   @Column(name = "release_date")
   private LocalDate releaseDate;

   @Column(name = "rating")
   private Double rating;

   // --- Relations ---
}
