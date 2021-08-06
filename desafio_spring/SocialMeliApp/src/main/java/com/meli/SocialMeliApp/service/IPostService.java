package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostListUserFollowedDTO;

public interface IPostService {
   void createPost (PostCreateDTO postCreateDTO);
   PostListUserFollowedDTO getListPostFollowed (Integer userId, String order);
   void createPromoPost (PromoPostDTO promoPostDTO);
}