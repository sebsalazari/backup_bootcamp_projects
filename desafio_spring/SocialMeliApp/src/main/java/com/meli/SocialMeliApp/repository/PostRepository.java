package com.meli.SocialMeliApp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.exception.PostException.PostIdRepeatException;
import com.meli.SocialMeliApp.exception.PostException.PostUserIdNoExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository {

   @Autowired
   IUserRepository iUserRepository;

   private List<PostCreateDTO> postList = loadJsonDatabase();

   @Override
   public void createPost(PostCreateDTO postCreateDTO) {
      if (!alreadyExistPost(postCreateDTO.getIdPost())) {
         userIdPostIsValid(postCreateDTO.getUserId());
         postList.add(postCreateDTO);
      } else
         throw new PostIdRepeatException(postCreateDTO.getIdPost());
   }

   @Override
   public List<PostCreateDTO> getPostList() {
      return postList;
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

   private List<PostCreateDTO> loadJsonDatabase() {
      List<PostCreateDTO> postList = null;
      File file = null;

      try {
         file = ResourceUtils.getFile("classpath:post.json");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }

      ObjectMapper om = new ObjectMapper();
      om.registerModule(new JavaTimeModule());
      TypeReference<List<PostCreateDTO>> typeDef = new TypeReference<>() {
      };

      try {
         postList = om.readValue(file, typeDef);
      } catch (IOException e) {
         e.printStackTrace();
      }

      return postList;
   }
}
