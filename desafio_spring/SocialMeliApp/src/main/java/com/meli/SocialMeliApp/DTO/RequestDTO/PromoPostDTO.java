package com.meli.SocialMeliApp.DTO.RequestDTO;

import com.meli.SocialMeliApp.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PromoPostDTO extends PostCreateDTO {
   private boolean hasPromo;
   private double discount;

   public PromoPostDTO(int userId, int postId, LocalDate date, Product detail, int category, double price,
                       boolean hasPromo, double discount) {
      super(userId, postId, date, detail, category, price);
      this.hasPromo = hasPromo;
      this.discount = discount;
   }
}
