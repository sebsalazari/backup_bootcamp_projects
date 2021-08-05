package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.ResponseDTO.UserFollowedListDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.UserFollowersListDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.UserTotalFollowersDTO;

public interface IUserService {
   void followUser (Integer userId, Integer userIdToFollow);
   UserTotalFollowersDTO getTotalFollowers (Integer userId);
   UserFollowersListDTO getListFollowers (Integer userId, String order);
   UserFollowedListDTO getListFollowed (Integer userId, String order);
   void unFollowUser (Integer userId, Integer userIdToUnfollow);
}
