package com.meli.CaloriasAPISpring3.service.DTO;

import com.meli.CaloriasAPISpring3.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
   private String nameDish;
   private double totalCalories;
   private List<IngredientDTO> ingredient;
   private IngredientDTO ingredientMaxCalories;
}
