package com.meli.SpoiledTomatoesAPI.repository;

import com.meli.SpoiledTomatoesAPI.model.Entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Long> {

   // Query (7)
   @Query("select epi from Episode epi " +
           "inner join epi.actorsInEpisodes act " +
           "on act.firstName =:nameActor " +
           "and act.lastName = :lastnameActor")
   List<Episode> findEpisodesByActorsInEpisodes(@Param("nameActor") String nameActor, @Param("lastnameActor") String lastnameActo);
}
