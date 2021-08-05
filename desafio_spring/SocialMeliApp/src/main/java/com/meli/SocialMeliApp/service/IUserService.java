package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.ResponseDTO.UserTotalFollowersDTO;

public interface IUserService {
   void followUser (Integer userId, Integer userIdToFollow);
   UserTotalFollowersDTO getTotalFollowers (Integer userId);
}
