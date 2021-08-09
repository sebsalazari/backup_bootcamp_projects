package com.meli.SocialMeliApp.controller;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostPromoListDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoQuantityDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostUserFollowedListDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.ProductByCategoryListDTO;
import com.meli.SocialMeliApp.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
   public ResponseEntity<PostUserFollowedListDTO> getListPost(@PathVariable Integer userId, @RequestParam(required = false) String order) {
      return new ResponseEntity<>(iPostService.getListPostFollowed(userId, order), HttpStatus.OK);
   }

   @PostMapping("/products/newpromopost")
   public ResponseEntity<Void> createPromoPost(@RequestBody PromoPostDTO promoPostDTO) {
      iPostService.createPromoPost(promoPostDTO);
      return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @GetMapping("/products/{userId}/countPromo")
   public ResponseEntity<PostInPromoQuantityDTO> getTotalPromoPost(@PathVariable Integer userId) {
      return new ResponseEntity<>(iPostService.getTotalPromoPost(userId), HttpStatus.OK);
   }

   @GetMapping("/products/{userId}/list")
   public ResponseEntity<PostPromoListDTO> getListPromoPost(@PathVariable Integer userId) {
      return new ResponseEntity<>(iPostService.getListPromoPost(userId), HttpStatus.OK);
   }

   // Funcionalidad extra añadida: US-0013 - Listar productos en promocion por categoria y su precio despues del descuento
   @GetMapping("/products/category/{category}/list")
   public ResponseEntity<List<ProductByCategoryListDTO>> getListProductsByCategory(@PathVariable Integer category) {
      return new ResponseEntity<>(iPostService.getListProducts(category), HttpStatus.OK);
   }

}
