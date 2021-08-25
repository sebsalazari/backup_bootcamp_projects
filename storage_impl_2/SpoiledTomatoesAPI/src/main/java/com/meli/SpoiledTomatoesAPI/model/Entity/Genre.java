package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "genres")
public class Genre {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "created_at")
   private LocalDateTime createdAt;

   @Column(name = "updated_at")
   private LocalDateTime updateAt;

   @Column(name = "name")
   private String name;

   @Column(name = "ranking", unique = true)
   private Integer ranking;

   @Column(name = "active")
   private Integer active;

   // --- Relations ---

}
