package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

   @Autowired
   IPostRepository iPostRepository;

   @Override
   public void createPost(PostCreateDTO postCreateDTO) {
      iPostRepository.createPost(postCreateDTO);
   }
}
