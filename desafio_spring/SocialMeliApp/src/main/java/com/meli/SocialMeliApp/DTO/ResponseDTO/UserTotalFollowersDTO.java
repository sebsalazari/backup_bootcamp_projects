package com.meli.SocialMeliApp.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTotalFollowersDTO {
   private Integer userId;
   private String userName;
   private Integer followersCount;
}
