package com.meli.SocialMeliApp.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO extends PostCreateDTO{
   private boolean hasPromo;
   private double discount;
}
