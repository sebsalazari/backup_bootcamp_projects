package com.meli.SocialMeliApp.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowedException extends UserException {
   public UserAlreadyFollowedException(Integer userId) {
      super("User " + userId + " is already a follower", HttpStatus.BAD_REQUEST);
   }
}
