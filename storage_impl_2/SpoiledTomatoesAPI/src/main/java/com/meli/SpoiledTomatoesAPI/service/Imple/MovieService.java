package com.meli.SpoiledTomatoesAPI.service.Imple;

import com.meli.SpoiledTomatoesAPI.model.DTO.MovieDTO;
import com.meli.SpoiledTomatoesAPI.model.Entity.Genre;
import com.meli.SpoiledTomatoesAPI.model.Entity.Movie;
import com.meli.SpoiledTomatoesAPI.repository.IGenreRepository;
import com.meli.SpoiledTomatoesAPI.repository.IMovieRepository;
import com.meli.SpoiledTomatoesAPI.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

   @Autowired
   IMovieRepository iMovieRepository;

   @Autowired
   IGenreRepository iGenreRepository;

   protected ModelMapper mapper;

   MovieService() {
      this.mapper = new ModelMapper();
   }

   @Override
   public void createMovie(MovieDTO movie) {
      Movie newMovie = mapper.map(movie, Movie.class);
      Optional<Genre> genre = iGenreRepository.findById(movie.getGenreId());
      if (genre.isPresent()) {
         newMovie.setGenreOfMovie(genre.get());
         iMovieRepository.save(newMovie);
      } else {
         // Exception genre not found
      }
   }

   @Override
   public void deleteMovie(Long id) {
      iMovieRepository.deleteById(id);
   }

   @Override
   public List<MovieDTO> findAll() {
      List<Movie> aux = iMovieRepository.findAll(PageRequest.of(0, 20))
              .getContent();

      return aux.stream().map(a -> mapper.map(a, MovieDTO.class)).collect(Collectors.toList());
   }
}
