package com.meli.SocialMeliApp.exception.UserException;

import com.meli.SocialMeliApp.exception.SocialGeneralException;
import org.springframework.http.HttpStatus;

public class SelfFollowException extends SocialGeneralException {
   public SelfFollowException() {
      super("User cannot self-follow", HttpStatus.BAD_REQUEST);
   }
}
