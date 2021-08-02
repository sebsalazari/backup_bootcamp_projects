package com.meli.CaloriasAPISpring3.service;

import com.meli.CaloriasAPISpring3.model.Dish;
import com.meli.CaloriasAPISpring3.model.Ingredient;
import com.meli.CaloriasAPISpring3.repository.IFoodRepository;
import com.meli.CaloriasAPISpring3.service.DTO.DishDTO;
import com.meli.CaloriasAPISpring3.service.DTO.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodService {

   @Autowired
   IFoodRepository foodRepository;

   @Override
   public DishDTO getDishDTO(Dish dish) throws IOException {
      List<IngredientDTO> listIngredientDTO = getListIngredient(dish.getIngredients());
      double totalCalories = getTotalCaloriesDish(listIngredientDTO);
      IngredientDTO ingredientMaxCalories = getMaxCaloriesIngredient(listIngredientDTO);

      return new DishDTO(dish.getName(), totalCalories, listIngredientDTO, ingredientMaxCalories);
   }

   // Obtener una nueva lista de ingredientes pero con su calorias totales de acuerdo al peso
   public List<IngredientDTO> getListIngredient(List<Ingredient> ingredients) throws IOException {
      List<IngredientDTO> list = new ArrayList<>();
      for (Ingredient item : ingredients) {
         IngredientDTO ingredientDTO = new IngredientDTO(item.getName(), getIngredientTotalCalories(item));
         list.add(ingredientDTO);
      }
      return list;
   }

   // Obtener las calorias totales por ingrediente de acuerdo a su peso: gramos * calorias
   public double getIngredientTotalCalories(Ingredient ingredient) throws IOException {
      return ingredient.getWeight() * getCaloriesByNameIngredient(ingredient.getName());
   }

   // Obtener las calorias de un ingrendiente traido de la DB
   public double getCaloriesByNameIngredient(String name) throws IOException {
      return getIngredientByName(name).getCalories();
   }

   // Obtener un ingrediente de la DB (JSON) buscandolo por su nombre
   public IngredientDTO getIngredientByName(String name) throws IOException {
      return foodRepository.findIngredientByName(name);
   }

   // Obtener el total de calorias de todo el plato
   public double getTotalCaloriesDish(List<IngredientDTO> ingredientDTOList) {
      return ingredientDTOList.stream().mapToDouble(IngredientDTO::getCalories).sum();
   }

   // Obtener el ingrediente con mas calorias
   public IngredientDTO getMaxCaloriesIngredient(List<IngredientDTO> ingredientDTOList) {
      Optional<IngredientDTO> ingredient;
      ingredient = ingredientDTOList.stream().max(Comparator.comparing(IngredientDTO::getCalories));
      return ingredient.orElse(null);
   }
}
