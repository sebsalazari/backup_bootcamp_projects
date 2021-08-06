package com.meli.SocialMeliApp.exception.UserException;

import com.meli.SocialMeliApp.exception.SocialGeneralException;
import org.springframework.http.HttpStatus;

public class SelfUnfollowException extends SocialGeneralException {
   public SelfUnfollowException() {
      super("You cannot self-unfollow ", HttpStatus.BAD_REQUEST);
   }
}
