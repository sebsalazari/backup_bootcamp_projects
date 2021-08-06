package com.meli.SocialMeliApp.repository;

import com.meli.SocialMeliApp.model.Post;

import java.util.List;

public interface IPostRepository {
   List<Post> getPostList ();
   void createPost (Post newPost);
   Integer getTotalPromoPost(Integer userId);
}
