package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostPromoListDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostUserFollowedListDTO;

public interface IPostService {
   void createPost (PostCreateDTO postCreateDTO);
   void createPromoPost (PromoPostDTO promoPostDTO);
   PostUserFollowedListDTO getListPostFollowed (Integer userId, String order);
   PostInPromoDTO getTotalPromoPost (Integer userId);
   PostPromoListDTO getListPromoPost (Integer userId);
}
