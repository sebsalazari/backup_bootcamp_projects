package com.meli.SocialMeliApp.controller;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostListUserFollowedDTO;
import com.meli.SocialMeliApp.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

   @Autowired
   IPostService iPostService;

   @PostMapping("/products/newpost")
   public ResponseEntity<Void> createPost(@RequestBody PostCreateDTO postCreateDTO) {
      iPostService.createPost(postCreateDTO);
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @GetMapping("/products/followed/{userId}/list")
   public ResponseEntity<PostListUserFollowedDTO> getListPost(@PathVariable Integer userId, @RequestParam(required = false) String order) {
      return new ResponseEntity<>(iPostService.getListPostFollowed(userId, order), HttpStatus.OK);
   }
}
