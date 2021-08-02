package com.meli.CaloriasAPISpring3.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.CaloriasAPISpring3.service.DTO.IngredientDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepository implements IFoodRepository {

   @Override
   public IngredientDTO findIngredientByName(String name) throws IOException {
      List<IngredientDTO> ingredientDTOList = null;
      ingredientDTOList = loadDatabaseIngredient();
      IngredientDTO ingredient = null;

      if (ingredientDTOList != null) {
         Optional<IngredientDTO> optional = ingredientDTOList.stream().filter(item -> item.getName().equals(name)).findFirst();
         ingredient = optional.orElse(null);
      }
      return ingredient;
   }

   // Load to Database - JSON
   public List<IngredientDTO> loadDatabaseIngredient() throws IOException {
      File file = null;
      file = ResourceUtils.getFile("classpath:food.json");

      ObjectMapper om = new ObjectMapper();
      TypeReference<List<IngredientDTO>> typeDef = new TypeReference<>() {
      };

      List<IngredientDTO> ingredienteListDTO = null;
      ingredienteListDTO = om.readValue(file, typeDef);

      return ingredienteListDTO;
   }
}
