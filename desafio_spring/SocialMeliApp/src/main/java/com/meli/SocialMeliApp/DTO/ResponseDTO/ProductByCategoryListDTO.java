package com.meli.SocialMeliApp.DTO.ResponseDTO;

import com.meli.SocialMeliApp.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

/* DTO de respuesta para nuevo endpoint: US-0013 - Listar productos
   en promocion por categoria y su precio despues del descuento */
public class ProductByCategoryListDTO {
   private int category;
   private Product detail;
   private double price;
   private double discount;
   private double netPrice;
}
