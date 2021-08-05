package com.meli.SocialMeliApp.controller;

import com.meli.SocialMeliApp.DTO.ResponseDTO.UserTotalFollowersDTO;
import com.meli.SocialMeliApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

   @Autowired
   IUserService iUserService;

   @PostMapping("/users/{userId}/follow/{userIdToFollow}")
   public ResponseEntity<Void> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
      iUserService.followUser(userId, userIdToFollow);
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @GetMapping("/users/{userId}/followers/count/")
   public ResponseEntity<UserTotalFollowersDTO> totalFollowersUser(@PathVariable Integer userId) {
      return new ResponseEntity<>(iUserService.getTotalFollowers(userId), HttpStatus.OK);
   }
}
