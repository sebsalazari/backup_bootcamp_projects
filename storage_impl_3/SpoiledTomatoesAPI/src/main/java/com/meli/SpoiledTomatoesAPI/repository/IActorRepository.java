package com.meli.SpoiledTomatoesAPI.repository;

import com.meli.SpoiledTomatoesAPI.model.Entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {

   // Query (1)
   List<Actor> findActorsByFavoriteMovieIsNotNull();

   // Query (2)
   List<Actor> findActorsByRatingGreaterThanEqual(Double rating);

   // Query (3)
   @Query("select act from Actor as act inner join act.moviesContainsActors mov on mov.title = :nameMovie")
   List<Actor> findActorInMovie(@Param("nameMovie") String nameMovie);
}
