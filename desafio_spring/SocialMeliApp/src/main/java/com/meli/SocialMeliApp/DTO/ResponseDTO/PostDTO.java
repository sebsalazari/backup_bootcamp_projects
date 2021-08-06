package com.meli.SocialMeliApp.DTO.ResponseDTO;

import com.meli.SocialMeliApp.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
   private int idPost;
   private LocalDate date;
   private Product detail;
   private int category;
   private double price;
   private boolean hasPromo;
   private double discount;
}
