package com.meli.SpoiledTomatoesAPI.model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "comedies")
public class Comedy {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;

   @Column(name = "awards")
   private Integer awards;

   @Column(name = "name")
   private String name;

   @Column(name = "rating")
   private Double rating;
}
