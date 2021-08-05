package com.meli.SocialMeliApp.repository;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;

public interface IPostRepository {
   void createPost (PostCreateDTO postCreateDTO);
}
