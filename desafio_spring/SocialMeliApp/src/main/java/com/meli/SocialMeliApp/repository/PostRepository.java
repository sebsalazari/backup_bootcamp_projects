package com.meli.SocialMeliApp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoDTO;
import com.meli.SocialMeliApp.exception.PostException.RepeatedPostException;
import com.meli.SocialMeliApp.exception.PostException.InvalidPostByUserIdException;
import com.meli.SocialMeliApp.model.Post;
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

   private List<Post> postList = loadJsonDatabase();

   @Override
   public List<Post> getPostList() {
      return postList;
   }

   @Override
   public void createPost(Post newPost) {
      if (!alreadyExistPost(newPost.getIdPost()))
         userIdPostIsValid(newPost);
      else throw new RepeatedPostException(newPost.getIdPost());
   }

   @Override
   public Integer getTotalPromoPost(Integer userId) {
      return (int) postList.stream().filter(p -> p.getUserId() == userId && p.isHasPromo())
              .count();
   }

   public boolean alreadyExistPost(Integer idPost) {
      return postList.stream().anyMatch(p -> p.getIdPost() == idPost);
   }

   public void userIdPostIsValid(Post post) {
      if (iUserRepository.findUserById(post.getUserId()) != null) {
         postList.add(post);
         iUserRepository.linkPostToUser(postList);
      } else throw new InvalidPostByUserIdException(post.getUserId());
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
