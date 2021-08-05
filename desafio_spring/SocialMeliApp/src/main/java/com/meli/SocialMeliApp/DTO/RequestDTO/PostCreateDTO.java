package com.meli.SocialMeliApp.DTO.RequestDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.SocialMeliApp.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDTO {
   private int userId;
   private int idPost;
   @JsonFormat(pattern = "dd-MM-yyyy")
   private LocalDate date;
   private Product detail;
   private int category;
   private double price;
}
