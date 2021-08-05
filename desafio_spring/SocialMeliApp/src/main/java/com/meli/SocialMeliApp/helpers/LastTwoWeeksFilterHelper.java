package com.meli.SocialMeliApp.helpers;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.DTO.ResponseDTO.PostDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LastTwoWeeksFilterHelper {

   public static List<PostDTO> limitWeeksPost(List<PostCreateDTO> listPost) {
      List<PostDTO> postDTOList = null;
      LocalDate date = LocalDate.now();
      LocalDate weeksBefore;
      weeksBefore = date.minusDays(15);

      postDTOList = passToDto(listPost);
      return postDTOList.stream().filter(item -> item.getDate().isAfter(weeksBefore)).collect(Collectors.toList());
   }

   public static List<PostDTO> passToDto(List<PostCreateDTO> list) {
      return list.stream().map(p -> new PostDTO(p.getIdPost(), p.getDate(), p.getDetail(), p.getCategory(), p.getPrice())).collect(Collectors.toList());
   }
}
