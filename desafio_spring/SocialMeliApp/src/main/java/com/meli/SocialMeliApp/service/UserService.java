package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.ResponseDTO.UserDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.UserFollowedListDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.UserFollowersListDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.UserTotalFollowersDTO;
import com.meli.SocialMeliApp.model.User;
import com.meli.SocialMeliApp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

   @Autowired
   IUserRepository iUserRepository;

   @Override
   public void followUser(Integer userId, Integer userIdToFollow) {
      iUserRepository.followUser(userId, userIdToFollow);
   }

   @Override
   public UserTotalFollowersDTO getTotalFollowers(Integer userId) {
      User user = iUserRepository.findUserById(userId);
      return new UserTotalFollowersDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
   }

   @Override
   public UserFollowersListDTO getListFollowers(Integer userId) {
      User user = iUserRepository.findUserById(userId);
      List<UserDTO> userDTOList = new ArrayList<>();
      user.getFollowers().forEach(u -> {
         User aux = iUserRepository.findUserById(u);
         userDTOList.add(new UserDTO(aux.getUserId(), aux.getUserName()));
      });

      return new UserFollowersListDTO(user.getUserId(), user.getUserName(), userDTOList);
   }

   @Override
   public UserFollowedListDTO getListFollowed(Integer userId) {
      User user = iUserRepository.findUserById(userId);
      List<UserDTO> userDTOList = new ArrayList<>();
      user.getFollowed().forEach(u -> {
         User aux = iUserRepository.findUserById(u);
         userDTOList.add(new UserDTO(aux.getUserId(), aux.getUserName()));
      });

      return new UserFollowedListDTO(user.getUserId(), user.getUserName(), userDTOList);
   }

   @Override
   public void unFollowUser(Integer userId, Integer userIdToUnfollow) {
      iUserRepository.unfollowUser(userId, userIdToUnfollow);
   }

}

