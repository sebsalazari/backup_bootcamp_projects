package com.meli.SpoiledTomatoesAPI.service;

import com.meli.SpoiledTomatoesAPI.model.DTO.MovieDTO;

import java.util.List;

public interface IMovieService {
   void createMovie(MovieDTO actor);

   void deleteMovie(Long id);

   List<MovieDTO> findAll();
}
