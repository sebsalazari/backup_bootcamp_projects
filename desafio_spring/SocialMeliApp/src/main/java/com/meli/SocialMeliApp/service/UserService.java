package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.DTO.ResponseDTO.UserTotalFollowersDTO;
import com.meli.SocialMeliApp.model.User;
import com.meli.SocialMeliApp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

