package com.meli.SocialMeliApp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
   public void followUser(Integer userId, Integer userIdToFollow) {
      if (!userId.equals(userIdToFollow)) {
         addFollowerUser(findUserById(userIdToFollow), userId);
         addUserFollowed(findUserById(userId), userIdToFollow);
      } else {
         // Excepcion no se puede seguir a el mismo
         // Falta validar que el usuario este disponible para seguir o que no estuviera unfollow
      }

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

   public User findUserById(Integer userId) {
      return userList.stream().filter(u -> u.getUserId() == userId)
              .findFirst()
              .orElse(null); // Excepcion userId no encontrado
   }

   public void addFollowerUser(User userToFollow, Integer idUserFollower) {
      userToFollow.getFollowers().add(idUserFollower);
      userList.set(userList.indexOf(userToFollow), userToFollow);
   }

   public void addUserFollowed(User userFollower, Integer idUserFollowed) {
      userFollower.getFollowed().add(idUserFollowed);
      userList.set(userList.indexOf(userFollower), userFollower);
   }


}
