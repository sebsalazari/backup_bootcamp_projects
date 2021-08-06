package com.meli.SocialMeliApp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.SocialMeliApp.exception.UserException.*;
import com.meli.SocialMeliApp.model.Post;
import com.meli.SocialMeliApp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

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
      addFollowerUser(findUserById(userIdToFollow), userId);
      addUserFollowed(findUserById(userId), userIdToFollow);
   }

   @Override
   public void unfollowUser(Integer userId, Integer userIdToUnfollow) {
      removeFollowerUser(findUserById(userIdToUnfollow), userId);
      removeUserFollowed(findUserById(userId), userIdToUnfollow);
   }

   @Override
   public void linkPostToUser(List<Post> postList) {
      postList.forEach(p -> {
         User user = userList.stream().filter(u -> u.getUserId() == p.getUserId())
                 .findFirst()
                 .orElse(null);
         assert user != null;
         if (!user.getPostList().contains(p.getIdPost())) {
            user.getPostList().add(p.getIdPost());
            updateUserList(user);
         }
      });
   }

   public void updateUserList(User user) {
      int index = userList.indexOf(user);
      userList.set(index, user);
   }

   public void addFollowerUser(User userToFollow, Integer idUserFollower) {
      if (!userToFollow.getFollowers().contains(idUserFollower)) {
         userToFollow.getFollowers().add(idUserFollower);
         updateUserList(userToFollow);
      } else throw new AlreadyFollowedException(userToFollow.getUserId());
   }

   public void addUserFollowed(User userFollower, Integer idUserFollowed) {
      userFollower.getFollowed().add(idUserFollowed);
      updateUserList(userFollower);
   }

   public void removeFollowerUser(User userToUnfollow, Integer idUserUnfollower) {
      if (userToUnfollow.getFollowers().contains(idUserUnfollower)) {
         userToUnfollow.getFollowers().remove(idUserUnfollower);
         updateUserList(userToUnfollow);
      } else throw new NotFollowedException();
   }

   public void removeUserFollowed(User userUnfollower, Integer idUserUnfollowed) {
      userUnfollower.getFollowed().remove(idUserUnfollowed);
      updateUserList(userUnfollower);
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
