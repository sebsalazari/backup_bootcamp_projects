package com.meli.SocialMeliApp.repository;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoDTO;
import com.meli.SocialMeliApp.model.Post;

import java.util.List;

public interface IPostRepository {
   void createPost (Post postCreateDTO);
   List<Post> getPostList ();
   PostInPromoDTO getTotalPromoPost(Integer userId);
}
