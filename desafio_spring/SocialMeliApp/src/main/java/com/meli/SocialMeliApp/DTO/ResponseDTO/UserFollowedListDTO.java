package com.meli.SocialMeliApp.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowedListDTO {
   private int userId;
   private String userName;
   private List<UserDTO> followed;
}
