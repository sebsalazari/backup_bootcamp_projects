package com.meli.CaloriasAPISpring3.service;

import com.meli.CaloriasAPISpring3.model.Dish;
import com.meli.CaloriasAPISpring3.service.DTO.DishDTO;

import java.io.IOException;

public interface IFoodService {
   DishDTO getDishDTO(Dish dish) throws IOException;
}
