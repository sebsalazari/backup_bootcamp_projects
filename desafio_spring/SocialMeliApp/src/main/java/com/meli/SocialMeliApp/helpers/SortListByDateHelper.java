package com.meli.SocialMeliApp.helpers;

import com.meli.SocialMeliApp.DTO.RequestDTO.PostCreateDTO;
import com.meli.SocialMeliApp.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortListByDateHelper {
   public static List<Post> getListUserOrder(List<Post> userDTOList, String order) {
      List<Post> newList = null;
      // Si no se pasa el param se retorna la lista comun y corriente sin ordenar como en el endpoint 3 y 4
      if(order == null) order = "default";
      switch (order) {
         case "date_asc":
            newList = orderDateAsc(userDTOList);
            break;

         case "date_desc":
            newList = orderDateDesc(userDTOList);
            break;

         default:
            return userDTOList;
      }
      return newList;
   }

   public static List<Post> orderDateAsc(List<Post> listUser) {
      listUser.sort((u1, u2) -> u1.getDate().compareTo(u2.getDate()));
      return listUser;
   }

   public static List<Post> orderDateDesc(List<Post> listUser) {
      listUser.sort((u1, u2) -> u2.getDate().compareTo(u1.getDate()));
      return listUser;
   }
}
