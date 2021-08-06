package com.meli.SocialMeliApp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoDTO;
import com.meli.SocialMeliApp.exception.PostException.PostIdRepeatException;
import com.meli.SocialMeliApp.exception.PostException.PostUserIdNoExistException;
import com.meli.SocialMeliApp.model.Post;
import com.meli.SocialMeliApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {

   @Autowired
   IUserRepository iUserRepository;

   private List<Post> postList = loadJsonDatabase();

   @Override
   public void createPost(Post postCreateDTO) {
      if (!alreadyExistPost(postCreateDTO.getIdPost())) {
         userIdPostIsValid(postCreateDTO.getUserId());
         postList.add(postCreateDTO);
      } else
         throw new PostIdRepeatException(postCreateDTO.getIdPost());
   }

   @Override
   public List<Post> getPostList() {
      return postList;
   }

   @Override
   public PostInPromoDTO getTotalPromoPost(Integer userId) {
      User user = iUserRepository.findUserById(userId);
      if (user != null) {
         List<Post> auxList = postList.stream().filter(p -> p.getUserId() == userId && p.isHasPromo()).collect(Collectors.toList());
         return new PostInPromoDTO(userId, user.getUserName(), auxList.size());
      } else
         throw new PostUserIdNoExistException(userId);
   }

   public boolean alreadyExistPost(Integer idPost) {
      return postList.stream().anyMatch(p -> p.getIdPost() == idPost);
   }

   public void userIdPostIsValid(Integer userId) {
      if (iUserRepository.findUserById(userId) != null) {
         iUserRepository.linkPostToUser();
      } else
         throw new PostUserIdNoExistException(userId);
   }

   private List<Post> loadJsonDatabase() {
      List<Post> postList = null;
      File file = null;

      try {
         file = ResourceUtils.getFile("classpath:post.json");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }

      ObjectMapper om = new ObjectMapper();
      om.registerModule(new JavaTimeModule());
      TypeReference<List<Post>> typeDef = new TypeReference<>() {
      };

      try {
         postList = om.readValue(file, typeDef);
      } catch (IOException e) {
         e.printStackTrace();
      }

      return postList;
   }
}
