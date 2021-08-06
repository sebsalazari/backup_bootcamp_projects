package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.ListPromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostListUserFollowedDTO;
import com.meli.SocialMeliApp.exception.UserException.UserNotFoundException;
import com.meli.SocialMeliApp.helpers.LastTwoWeeksFilterHelper;
import com.meli.SocialMeliApp.helpers.PostMapperHelper;
import com.meli.SocialMeliApp.helpers.SortListByDateHelper;
import com.meli.SocialMeliApp.model.Post;
import com.meli.SocialMeliApp.model.User;
import com.meli.SocialMeliApp.repository.IPostRepository;
import com.meli.SocialMeliApp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

   @Autowired
   IPostRepository iPostRepository;
   @Autowired
   IUserRepository iUserRepository;

   @Override
   public void createPost(PostCreateDTO postCreateDTO) {
      Post post = PostMapperHelper.postReqToPost(postCreateDTO);
      iPostRepository.createPost(post);
   }

   @Override
   public PostListUserFollowedDTO getListPostFollowed(Integer userId, String order) {
      User user = iUserRepository.findUserById(userId);
      List<Post> listPost = iPostRepository.getPostList();
      listPost = listPost.stream().filter(po -> po.getUserId() == user.getUserId()).collect(Collectors.toList());

      List<Post> useOrderList = SortListByDateHelper.getListUserOrder(listPost, order);
      return new PostListUserFollowedDTO(userId, LastTwoWeeksFilterHelper.limitWeeksPost(useOrderList));
   }

   @Override
   public void createPromoPost(PromoPostDTO p) {
      Post post = PostMapperHelper.postPromoReqToPost(PostMapperHelper.newPromoPost(p));
      iPostRepository.createPost(post);
   }

   @Override
   public PostInPromoDTO getTotalPromoPost(Integer userId) {
      return iPostRepository.getTotalPromoPost(userId);
   }

   @Override
   public ListPromoPostDTO getListPromoPost(Integer userId) {
      User user = iUserRepository.findUserById(userId);
      List<Post> listPost = iPostRepository.getPostList();
      listPost = listPost.stream().filter(po -> po.getUserId() == userId && po.isHasPromo()).collect(Collectors.toList());

      return new ListPromoPostDTO(userId, user.getUserName(), PostMapperHelper.postToPostDTO(listPost));
   }
}
