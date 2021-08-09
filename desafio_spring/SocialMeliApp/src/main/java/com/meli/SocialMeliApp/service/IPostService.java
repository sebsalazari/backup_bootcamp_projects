package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostPromoListDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoQuantityDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostUserFollowedListDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.ProductByCategoryListDTO;

import java.util.List;

public interface IPostService {
   void createPost (PostCreateDTO postCreateDTO);
   void createPromoPost (PromoPostDTO promoPostDTO);
   PostUserFollowedListDTO getListPostFollowed (Integer userId, String order);
   PostInPromoQuantityDTO getTotalPromoPost (Integer userId);
   PostPromoListDTO getListPromoPost (Integer userId);
   List<ProductByCategoryListDTO> getListProducts (Integer category); //US-0013
}
