package com.meli.SocialMeliApp.exception.UserException;

import com.meli.SocialMeliApp.exception.SocialGeneralException;
import org.springframework.http.HttpStatus;

public class NotFollowedException extends SocialGeneralException {
   public NotFollowedException() {
      super("The user is already unfollow", HttpStatus.BAD_REQUEST);
   }
}
