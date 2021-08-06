package com.meli.SocialMeliApp.repository;

import com.meli.SocialMeliApp.model.Post;
import com.meli.SocialMeliApp.model.User;

import java.util.List;

public interface IUserRepository {
   User findUserById (Integer userId);
   void followUser(Integer userId, Integer userIdToFollow);
   void unfollowUser(Integer userId, Integer userIdToFollow);
   void linkPostToUser(List<Post> postList);
}
