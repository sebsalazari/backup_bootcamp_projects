package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.ListPromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostListUserFollowedDTO;

public interface IPostService {
   void createPost (PostCreateDTO postCreateDTO);
   PostListUserFollowedDTO getListPostFollowed (Integer userId, String order);
   void createPromoPost (PromoPostDTO promoPostDTO);
   PostInPromoDTO getTotalPromoPost (Integer userId);
   ListPromoPostDTO getListPromoPost (Integer userId);
}
