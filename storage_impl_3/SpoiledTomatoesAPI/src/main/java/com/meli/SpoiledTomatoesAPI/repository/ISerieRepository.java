package com.meli.SpoiledTomatoesAPI.repository;

import com.meli.SpoiledTomatoesAPI.model.Entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Long> {

   // Query (6)
   @Query("select ser from Serie ser where ser.seasonsOfSerie.size >= :numSeasons")
   List<Serie> findSeriesByNumberSeasons(@Param("numSeasons") Integer numSeasons);
}
