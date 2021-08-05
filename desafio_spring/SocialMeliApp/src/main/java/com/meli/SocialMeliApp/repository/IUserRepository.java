package com.meli.SocialMeliApp.repository;

import com.meli.SocialMeliApp.model.User;

public interface IUserRepository {
   void followUser(Integer userId, Integer userIdToFollow);
   User findUserById (Integer userId);
   void linkPostToUser();
   void unfollowUser(Integer userId, Integer userIdToFollow);
}
