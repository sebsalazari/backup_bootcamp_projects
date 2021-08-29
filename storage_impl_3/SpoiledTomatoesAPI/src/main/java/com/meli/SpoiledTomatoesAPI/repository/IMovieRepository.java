package com.meli.SpoiledTomatoesAPI.repository;

import com.meli.SpoiledTomatoesAPI.model.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {

   // Query (4)
   @Query("select distinct mov from Movie as mov inner join mov.actorsInMovies act on act.rating >= :rating")
   List<Movie> findMoviesWithActorsRating(@Param("rating") Double rating);

   // Query (5)
   @Query("select mov from Movie as mov inner join mov.genreOfMovie gen on gen.name = :nameGenre")
   List<Movie> findMoviesByGenreEquals(@Param("nameGenre") String nameGenre);
}
