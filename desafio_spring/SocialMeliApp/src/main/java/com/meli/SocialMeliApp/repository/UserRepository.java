package com.meli.SocialMeliApp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.exception.UserException.*;
import com.meli.SocialMeliApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

   @Autowired
   IPostRepository iPostRepository;

   private List<User> userList = loadJsonDatabase();

   @Override
   public User findUserById(Integer userId) {
      User user = userList.stream().filter(u -> u.getUserId() == userId)
              .findFirst()
              .orElse(null);
      if (user == null) throw new UserNotFoundException(userId);
      return user;
   }

   @Override
   public void followUser(Integer userId, Integer userIdToFollow) {
      if (!userId.equals(userIdToFollow)) {
         addFollowerUser(findUserById(userIdToFollow), userId);
         addUserFollowed(findUserById(userId), userIdToFollow);
      } else
         throw new UserAutoFollowException();
   }

   @Override
   public void unfollowUser(Integer userId, Integer userIdToUnfollow) {
      if (!userId.equals(userIdToUnfollow)) {
         removeFollowerUser(findUserById(userIdToUnfollow), userId);
         removeUserFollowed(findUserById(userId), userIdToUnfollow);
      } else
         throw new UserAutoUnfollowException();
   }

   @Override
   public void linkPostToUser() {
      List<PostCreateDTO> listPost = iPostRepository.getPostList();
      listPost.forEach(p -> {
         User user = userList.stream().filter(u -> u.getUserId() == p.getUserId()).findFirst().orElse(null);
         assert user != null;
         if (!user.getPostList().contains(p.getIdPost())) {
            user.getPostList().add(p.getIdPost());
            int index = userList.indexOf(user);
            userList.set(index, user);
         }
      });
   }

   public void addFollowerUser(User userToFollow, Integer idUserFollower) {
      if (!userToFollow.getFollowers().contains(idUserFollower)) {
         userToFollow.getFollowers().add(idUserFollower);
         userList.set(userList.indexOf(userToFollow), userToFollow);
      } else
         throw new UserAlreadyFollowedException(idUserFollower);
   }

   public void addUserFollowed(User userFollower, Integer idUserFollowed) {
      userFollower.getFollowed().add(idUserFollowed);
      userList.set(userList.indexOf(userFollower), userFollower);
   }

   public void removeFollowerUser(User userToUnfollow, Integer idUserUnfollower) {
      if (userToUnfollow.getFollowers().contains(idUserUnfollower)) {
         userToUnfollow.getFollowers().remove(idUserUnfollower);
         userList.set(userList.indexOf(userToUnfollow), userToUnfollow);
      } else
         throw new UserNotFollowedException();
   }

   public void removeUserFollowed(User userUnfollower, Integer idUserUnfollowed) {
      userUnfollower.getFollowed().remove(idUserUnfollowed);
      userList.set(userList.indexOf(userUnfollower), userUnfollower);
   }

   private List<User> loadJsonDatabase() {
      List<User> userList = null;
      File file = null;

      try {
         file = ResourceUtils.getFile("classpath:users.json");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }

      ObjectMapper om = new ObjectMapper();
      TypeReference<List<User>> typeDef = new TypeReference<>() {
      };

      try {
         userList = om.readValue(file, typeDef);
      } catch (IOException e) {
         e.printStackTrace();
      }

      return userList;
   }

}
