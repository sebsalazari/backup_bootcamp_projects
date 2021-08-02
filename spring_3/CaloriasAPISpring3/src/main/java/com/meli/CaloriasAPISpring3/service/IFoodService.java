package com.meli.CaloriasAPISpring3.service;

import com.meli.CaloriasAPISpring3.model.Dish;
import com.meli.CaloriasAPISpring3.service.DTO.DishDTO;

import java.io.IOException;
import java.util.List;

public interface IFoodService {
   DishDTO getDishDTO(Dish dish) throws IOException;

   List<DishDTO> getListDishDTO (List<Dish> listDish) throws IOException;
}