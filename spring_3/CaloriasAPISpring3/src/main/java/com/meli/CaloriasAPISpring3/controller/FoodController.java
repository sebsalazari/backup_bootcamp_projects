package com.meli.CaloriasAPISpring3.controller;

import com.meli.CaloriasAPISpring3.model.Dish;
import com.meli.CaloriasAPISpring3.service.DTO.DishDTO;
import com.meli.CaloriasAPISpring3.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FoodController {

   @Autowired
   IFoodService foodService;

   @PostMapping("/api/calories")
   public ResponseEntity<DishDTO> createDish(@RequestBody Dish dish) throws IOException {
      return new ResponseEntity<>(foodService.getDishDTO(dish), HttpStatus.OK);
   }

   @PostMapping("/api/calories/list")
   public ResponseEntity<List<DishDTO>> createDishList(@RequestBody List<Dish> dishList) throws IOException {
      return new ResponseEntity<>(foodService.getListDishDTO(dishList), HttpStatus.OK);
   }
}
