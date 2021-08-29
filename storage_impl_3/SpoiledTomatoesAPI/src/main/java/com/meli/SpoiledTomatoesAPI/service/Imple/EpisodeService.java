package com.meli.SpoiledTomatoesAPI.service.Imple;

import com.meli.SpoiledTomatoesAPI.model.DTO.EpisodeDTO;
import com.meli.SpoiledTomatoesAPI.model.Entity.Episode;
import com.meli.SpoiledTomatoesAPI.model.Entity.Season;
import com.meli.SpoiledTomatoesAPI.repository.IEpisodeRepository;
import com.meli.SpoiledTomatoesAPI.repository.ISeasonRepository;
import com.meli.SpoiledTomatoesAPI.service.IEpisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService {

   @Autowired
   IEpisodeRepository iEpisodeRepository;

   @Autowired
   ISeasonRepository iSeasonRepository;

   protected ModelMapper mapper;

   EpisodeService() {
      this.mapper = new ModelMapper();
   }

   @Override
   public void createEpisode(EpisodeDTO episodeDTO) {
      Episode newEpisode = mapper.map(episodeDTO, Episode.class);
      Optional<Season> season = iSeasonRepository.findById(episodeDTO.getSeasonId());
      if (season.isPresent()) {
         newEpisode.setSeasonContainsEpisode(season.get());
         iEpisodeRepository.save(newEpisode);
      } else {
         // Exception season not found
      }
   }

   @Override
   public void deleteEpisode(Long id) {
      iEpisodeRepository.deleteById(id);
   }

   @Override
   public List<EpisodeDTO> findAll() {
      List<Episode> aux = iEpisodeRepository.findAll(PageRequest.of(0, 10))
              .getContent();

      return aux.stream().map(a -> mapper.map(a, EpisodeDTO.class)).collect(Collectors.toList());
   }

   @Override
   public List<EpisodeDTO> getEpisodesByActorsInEpisodes(String nameActor, String lastnameActor) {
      List<Episode> aux = iEpisodeRepository.findEpisodesByActorsInEpisodes(nameActor, lastnameActor);

      return aux.stream().map(a -> mapper.map(a, EpisodeDTO.class)).collect(Collectors.toList());
   }
}
