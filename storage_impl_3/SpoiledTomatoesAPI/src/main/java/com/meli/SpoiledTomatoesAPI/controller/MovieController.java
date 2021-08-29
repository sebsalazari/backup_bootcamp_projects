package com.meli.SpoiledTomatoesAPI.controller;

import com.meli.SpoiledTomatoesAPI.model.DTO.MovieDTO;
import com.meli.SpoiledTomatoesAPI.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

   @Autowired
   IMovieService iMovieService;

   @PostMapping("/new_movie")
   public ResponseEntity<String> createMovies(@RequestBody MovieDTO movieDTO) {
      iMovieService.createMovie(movieDTO);
      return new ResponseEntity<>("Movie guardada correctamente en la DB", HttpStatus.CREATED);
   }

   @DeleteMapping("/delete_movie/{id}")
   public ResponseEntity<String> deleteActor(@PathVariable Long id) {
      iMovieService.deleteMovie(id);
      return new ResponseEntity<>("Movie eliminada correctamente en la DB", HttpStatus.OK);
   }

   @GetMapping("/get_movies")
   public ResponseEntity<List<MovieDTO>> getMovies() {
      return new ResponseEntity<>(iMovieService.findAll(), HttpStatus.OK);
   }

   // Consultas HQL - Practica
   @GetMapping("/get_movies/actors/rating/{rating}")
   public ResponseEntity<List<MovieDTO>> getMoviesWithActorsRating(@PathVariable Double rating) {
      return new ResponseEntity<>(iMovieService.getMoviesWhereActorsRating(rating), HttpStatus.OK);
   }

   @GetMapping("/get_movies/genre/equal/{genre}")
   public ResponseEntity<List<MovieDTO>> getMoviesByGenreEqual(@PathVariable String genre) {
      return new ResponseEntity<>(iMovieService.getMoviesByGenre(genre), HttpStatus.OK);
   }
}
