package com.meli.CaloriasAPISpring3.repository;

import com.meli.CaloriasAPISpring3.service.DTO.IngredientDTO;

import java.io.IOException;

public interface IFoodRepository {
   IngredientDTO findIngredientByName(String name) throws IOException;
}
