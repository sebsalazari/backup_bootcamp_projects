package com.meli.SocialMeliApp.helpers;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.RequestDTO.PromoPostDTO;
import com.meli.SocialMeliApp.model.Post;

public class PostMapperHelper {
   public static Post postReqToPost(PostCreateDTO p) {
      return new Post(p.getUserId(), p.getIdPost(), p.getDate(), p.getDetail(), p.getCategory(), p.getPrice(), false, 0);
   }

   public static Post postPromoReqToPost(PromoPostDTO pr) {
      return new Post(pr.getUserId(), pr.getIdPost(), pr.getDate(), pr.getDetail(), pr.getCategory(), pr.getPrice(), pr.isHasPromo(), pr.getDiscount());
   }
}
