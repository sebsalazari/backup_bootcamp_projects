package com.meli.SocialMeliApp.helpers;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostInPromoQuantityDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.ProductByCategoryListDTO;
import com.meli.SocialMeliApp.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapperHelper {
   public static Post postReqToPost(PostCreateDTO p) {
      return new Post(p.getUserId(), p.getIdPost(), p.getDate(), p.getDetail(), p.getCategory(), p.getPrice(),
              false, 0);
   }

   public static Post postPromoReqToPost(PromoPostDTO p) {
      return new Post(p.getUserId(), p.getIdPost(), p.getDate(), p.getDetail(), p.getCategory(), p.getPrice(),
              p.isHasPromo(), p.getDiscount());
   }

   public static List<PostDTO> postToPostDTO(List<Post> post) {
      return post.stream().map(p -> new PostDTO(p.getIdPost(), p.getDate(), p.getDetail(), p.getCategory(), p.getPrice(),
              p.isHasPromo(), p.getDiscount()))
              .collect(Collectors.toList());
   }

   public static PromoPostDTO newPromoPost(PromoPostDTO p) {
      return new PromoPostDTO(p.getUserId(), p.getIdPost(), p.getDate(), p.getDetail(), p.getCategory(), p.getPrice(),
              p.isHasPromo(), p.getDiscount());
   }

   public static PostInPromoQuantityDTO postInPromoDTO(Integer userId, String userName, Integer total) {
      return new PostInPromoQuantityDTO(userId, userName, total);
   }

   public static List<ProductByCategoryListDTO> productByCategoryListDTO(List<Post> postList) {
      return postList.stream().map(p -> new ProductByCategoryListDTO(p.getCategory(), p.getDetail(), p.getPrice(), p.getDiscount(),
              (p.getPrice() - (p.getPrice() * p.getDiscount()))))
              .collect(Collectors.toList());
   }
}
