package com.meli.SocialMeliApp.repository;

public interface IUserRepository {
   void followUser(Integer userId, Integer userIdToFollow);
}
