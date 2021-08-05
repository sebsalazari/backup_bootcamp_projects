package com.meli.SocialMeliApp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository{

   private List<PostCreateDTO> postList = loadJsonDatabase();

   @Override
   public void createPost(PostCreateDTO postCreateDTO) {
      postList.add(postCreateDTO);
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
