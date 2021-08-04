package com.meli.SocialMeliApp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.SocialMeliApp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

   private List<User> userList = loadJsonDatabase();

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
      }catch (IOException e){
         e.printStackTrace();
      }

      return userList;
   }
}
