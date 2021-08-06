package com.meli.SocialMeliApp.exception.UserException;

import com.meli.SocialMeliApp.exception.SocialGeneralException;
import org.springframework.http.HttpStatus;

public class AlreadyFollowedException extends SocialGeneralException {
   public AlreadyFollowedException(Integer userId) {
      super("You are already a follower of " + userId, HttpStatus.BAD_REQUEST);
   }
}
