package com.meli.SocialMeliApp.helpers;

import com.meli.SocialMeliApp.DTO.ResponseDTO.PostDTO;
import com.meli.SocialMeliApp.model.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LastTwoWeeksFilterHelper {

   public static List<PostDTO> limitWeeksPost(List<Post> listPost) {
      List<PostDTO> postDTOList = mapperToDto(listPost);
      LocalDate dateMinusWeeks = LocalDate.now().minusWeeks(2);

      return postDTOList.stream().filter(item -> item.getDate().isAfter(dateMinusWeeks))
              .collect(Collectors.toList());
   }

   public static List<PostDTO> mapperToDto(List<Post> list) {
      return list.stream().map(p -> new PostDTO(p.getIdPost(), p.getDate(), p.getDetail(), p.getCategory(),
              p.getPrice(), p.isHasPromo(), p.getDiscount())).collect(Collectors.toList());
   }
}
