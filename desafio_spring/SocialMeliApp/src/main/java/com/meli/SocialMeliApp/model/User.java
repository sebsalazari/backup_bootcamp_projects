package com.meli.SocialMeliApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
   private int userId;
   private String userName;
   private List<Integer> followers;
   private List<Integer> followed;
   private List<Integer> postList;
}
