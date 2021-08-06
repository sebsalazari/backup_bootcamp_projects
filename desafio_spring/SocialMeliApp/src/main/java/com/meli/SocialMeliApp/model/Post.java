package com.meli.SocialMeliApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
   private int userId;
   private int idPost;
   private LocalDate date;
   private Product detail;
   private int category;
   private double price;
}