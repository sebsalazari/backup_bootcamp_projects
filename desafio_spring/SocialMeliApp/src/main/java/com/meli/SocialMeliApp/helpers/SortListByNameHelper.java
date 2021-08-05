package com.meli.SocialMeliApp.helpers;

import com.meli.SocialMeliApp.DTO.ResponseDTO.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortListByNameHelper {

   public static List<UserDTO> getListUserOrder(List<UserDTO> userDTOList, String order) {
      List<UserDTO> newList = null;
      // Si no se pasa el param se retorna la lista comun y corriente sin ordenar como en el endpoint 3 y 4
      if(order == null) order = "default";
      switch (order) {
         case "name_asc":
            newList = orderNameAsc(userDTOList);
            break;

         case "name_desc":
            newList = orderNameDesc(userDTOList);
            break;

         default:
            return userDTOList;
      }
      return newList;
   }

   public static List<UserDTO> orderNameAsc(List<UserDTO> listUser) {
      listUser.sort((u1, u2) -> u1.getUserName().compareTo(u2.getUserName()));
      return listUser;
   }

   public static List<UserDTO> orderNameDesc(List<UserDTO> listUser) {
      listUser.sort((u1, u2) -> u2.getUserName().compareTo(u1.getUserName()));
      return listUser;
   }
}
