package com.meli.SpoiledTomatoesAPI.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class MiniSerie {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;
   private String name;
   Double rating;
   Integer awards;
}
