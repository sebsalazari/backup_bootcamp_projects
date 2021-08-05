package com.meli.SocialMeliApp.exception.UserException;

import com.meli.SocialMeliApp.exception.UserException.UserException;
import org.springframework.http.HttpStatus;

public class UserAlreadyFollowedException extends UserException {
   public UserAlreadyFollowedException(Integer userId) {
      super("User " + userId + " is already a follower", HttpStatus.BAD_REQUEST);
   }
}
