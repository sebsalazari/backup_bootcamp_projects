package com.meli.SpoiledTomatoesAPI.service;

import com.meli.SpoiledTomatoesAPI.model.DTO.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {
   void createEpisode(EpisodeDTO episodeDTO);

   void deleteEpisode(Long id);

   List<EpisodeDTO> findAll();

   // --- HQL ---
   List<EpisodeDTO> getEpisodesByActorsInEpisodes (String nameActor, String lastnameActor);
}
