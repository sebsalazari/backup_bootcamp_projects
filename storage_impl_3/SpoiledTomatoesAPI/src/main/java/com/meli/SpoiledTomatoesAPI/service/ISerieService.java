package com.meli.SpoiledTomatoesAPI.service;

import com.meli.SpoiledTomatoesAPI.model.DTO.SerieDTO;

import java.util.List;

public interface ISerieService {
   void createSerie(SerieDTO serie);

   void deleteSerie(Long id);

   List<SerieDTO> findAll();

   // --- HQL ---
   List<SerieDTO> getSeriesByNumberSeasons (Integer numSeasons);
}
