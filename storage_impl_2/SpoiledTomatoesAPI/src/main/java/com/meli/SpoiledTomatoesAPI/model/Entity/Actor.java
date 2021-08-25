package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "actors")
public class Actor {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "created_at")
   private LocalDateTime createdAt;

   @Column(name = "updated_at")
   private LocalDateTime updateAt;

   @Column(name = "first_name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "rating")
   private Double rating;

   // --- Relations ---

}
