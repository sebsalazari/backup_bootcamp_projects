package com.meli.SocialMeliApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
   @JsonFormat(pattern = "dd-MM-yyyy")
   private LocalDate date;
   private Product detail;
   private int category;
   private double price;
   private boolean hasPromo;
   private double discount;
}
