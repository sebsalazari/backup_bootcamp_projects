package com.meli.SocialMeliApp.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostInPromoDTO {
   private int userId;
   private String userName;
   private int promoproducts_count;
}
