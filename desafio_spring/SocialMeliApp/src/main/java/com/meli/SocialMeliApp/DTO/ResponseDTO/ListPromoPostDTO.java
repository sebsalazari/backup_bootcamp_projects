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
public class ListPromoPostDTO {
   private Integer userId;
   private String userName;
   private List<PostDTO> posts;
}
