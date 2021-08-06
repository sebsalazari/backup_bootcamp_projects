package com.meli.SocialMeliApp.controller;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoDTO;
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
      return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @GetMapping("/products/followed/{userId}/list")
   public ResponseEntity<PostListUserFollowedDTO> getListPost(@PathVariable Integer userId, @RequestParam(required = false) String order) {
      return new ResponseEntity<>(iPostService.getListPostFollowed(userId, order), HttpStatus.OK);
   }

   @PostMapping("/products/newpromopost")
   public ResponseEntity<Void> createPromoPost(@RequestBody PromoPostDTO promoPostDTO) {
      iPostService.createPromoPost(promoPostDTO);
      return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @GetMapping("/products/{userId}/countPromo")
   public ResponseEntity<PostInPromoDTO> getListPost(@PathVariable Integer userId) {
      return new ResponseEntity<>(iPostService.getTotalPromoPost(userId), HttpStatus.OK);
   }

}
