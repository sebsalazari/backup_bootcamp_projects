package com.meli.SocialMeliApp.exception.UserException;

import org.springframework.http.HttpStatus;

public class UserNotFollowedException extends UserException{
   public UserNotFollowedException() {
      super("El usuario ya se encuentra Unfollow", HttpStatus.BAD_REQUEST);
   }
}
