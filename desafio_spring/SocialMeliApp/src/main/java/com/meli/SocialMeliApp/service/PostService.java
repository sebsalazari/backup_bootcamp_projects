package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostListUserFollowedDTO;
import com.meli.SocialMeliApp.exception.PostException.UserHasNotPostException;
import com.meli.SocialMeliApp.helpers.LastTwoWeeksFilterHelper;
import com.meli.SocialMeliApp.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

   @Autowired
   IPostRepository iPostRepository;

   @Override
   public void createPost(PostCreateDTO postCreateDTO) {
      iPostRepository.createPost(postCreateDTO);
   }

   @Override
   public PostListUserFollowedDTO getListPostFollowed(Integer userId) {
      List<PostCreateDTO> listPost = iPostRepository.getPostList();
      if (listPost.stream().anyMatch(p -> p.getUserId() == userId)) {
         listPost = listPost.stream().filter(po -> po.getUserId() == userId).collect(Collectors.toList());
      } else
         throw new UserHasNotPostException();

      return new PostListUserFollowedDTO(userId, LastTwoWeeksFilterHelper.limitWeeksPost(listPost));
   }
}
