package com.meli.SocialMeliApp.service;

import com.meli.SocialMeliApp.repository.IUserRepository;
import com.meli.SocialMeliApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

   @Autowired
   IUserRepository iUserRepository;

   @Override
   public void followUser(Integer userId, Integer userIdToFollow) {
      iUserRepository.followUser(userId, userIdToFollow);
   }
}

