package com.meli.SocialMeliApp.helpers;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostDTO;
import com.meli.SocialMeliApp.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapperHelper {
   public static Post postReqToPost(PostCreateDTO p) {
      return new Post(p.getUserId(), p.getIdPost(), p.getDate(), p.getDetail(), p.getCategory(), p.getPrice(),
              false, 0);
   }

   public static Post postPromoReqToPost(PromoPostDTO pr) {
      return new Post(pr.getUserId(), pr.getIdPost(), pr.getDate(), pr.getDetail(), pr.getCategory(), pr.getPrice(),
              pr.isHasPromo(), pr.getDiscount());
   }

   public static List<PostDTO> postToPostDTO (List<Post> post) {
      List<PostDTO> postDTOList = null;

      postDTOList = post.stream().map(p -> new PostDTO(p.getIdPost(), p.getDate(), p.getDetail(), p.getCategory(),
              p.getPrice(), p.isHasPromo(), p.getDiscount())).collect(Collectors.toList());

      return postDTOList;
   }

   public static PromoPostDTO newPromoPost (PromoPostDTO promo){
      return new PromoPostDTO(promo.getUserId(), promo.getIdPost(), promo.getDate(), promo.getDetail(),
              promo.getCategory(), promo.getPrice(), promo.isHasPromo(), promo.getDiscount());
   }
}
