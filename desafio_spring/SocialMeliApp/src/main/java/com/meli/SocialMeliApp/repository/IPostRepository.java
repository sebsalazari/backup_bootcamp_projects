package com.meli.SocialMeliApp.repository;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;

import java.util.List;

public interface IPostRepository {
   void createPost (PostCreateDTO postCreateDTO);
   List<PostCreateDTO> getPostList ();
}
