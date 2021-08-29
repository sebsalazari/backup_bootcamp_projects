package com.meli.SpoiledTomatoesAPI.service.Imple;

import com.meli.SpoiledTomatoesAPI.model.DTO.SerieDTO;
import com.meli.SpoiledTomatoesAPI.model.Entity.Genre;
import com.meli.SpoiledTomatoesAPI.model.Entity.Serie;
import com.meli.SpoiledTomatoesAPI.repository.IGenreRepository;
import com.meli.SpoiledTomatoesAPI.repository.ISerieRepository;
import com.meli.SpoiledTomatoesAPI.service.ISerieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService {

   @Autowired
   ISerieRepository iSerieRepository;

   @Autowired
   IGenreRepository iGenreRepository;

   protected ModelMapper mapper;

   SerieService() {
      this.mapper = new ModelMapper();
   }

   @Override
   public void createSerie(SerieDTO serie) {
      Serie newSerie = mapper.map(serie, Serie.class);
      Optional<Genre> genre = iGenreRepository.findById(serie.getGenreId());
      if (genre.isPresent()) {
         newSerie.setGenreOfSerie(genre.get());
         iSerieRepository.save(newSerie);
      } else {
         // Exception genre not found
      }
   }

   @Override
   public void deleteSerie(Long id) {
      iSerieRepository.deleteById(id);
   }

   @Override
   public List<SerieDTO> findAll() {
      List<Serie> aux = iSerieRepository.findAll(PageRequest.of(0, 10))
              .getContent();

      return aux.stream().map(a -> mapper.map(a, SerieDTO.class)).collect(Collectors.toList());
   }

   @Override
   public List<SerieDTO> getSeriesByNumberSeasons(Integer numSeasons) {
      List<Serie> aux = iSerieRepository.findSeriesByNumberSeasons(numSeasons);

      return aux.stream().map(a -> mapper.map(a, SerieDTO.class)).collect(Collectors.toList());
   }
}
