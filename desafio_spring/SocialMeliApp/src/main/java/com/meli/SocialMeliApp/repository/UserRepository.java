package com.meli.SocialMeliApp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.SocialMeliApp.exception.UserAlreadyFollowedException;
import com.meli.SocialMeliApp.exception.UserAutoFollowException;
import com.meli.SocialMeliApp.exception.UserNotFoundException;
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
      if (!userId.equals(userIdToFollow)) {
         addFollowerUser(findUserById(userIdToFollow), userId);
         addUserFollowed(findUserById(userId), userIdToFollow);
      } else
         throw new UserAutoFollowException();
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
