package com.meli.SpoiledTomatoesAPI.service;

import com.meli.SpoiledTomatoesAPI.model.DTO.ActorDTO;
import com.meli.SpoiledTomatoesAPI.model.Entity.Actor;
import com.meli.SpoiledTomatoesAPI.model.Entity.Movie;
import com.meli.SpoiledTomatoesAPI.repository.IActorRepository;
import com.meli.SpoiledTomatoesAPI.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {

   @Autowired
   IActorRepository iActorRepository;

   @Autowired
   IMovieRepository iMovieRepository;

   ModelMapper mapper;

   ActorService() {
      this.mapper = new ModelMapper();
   }

   @Override
   public void createActor(ActorDTO actor) {
      Actor newActor = mapper.map(actor, Actor.class);
      Optional<Movie> movie = iMovieRepository.findById(actor.getFavoriteMovieId());
      if (movie.isPresent()) {
         newActor.setFavoriteMovie(movie.get());
         iActorRepository.save(newActor);
      } else {
         // Exception movie not found
      }

   }

   @Override
   public void deleteActor(Long id) {
      Actor actor = iActorRepository.getById(id);
      iActorRepository.delete(actor);
   }

   @Override
   public List<ActorDTO> findAll() {
      List<Actor> aux = iActorRepository.findAll(PageRequest.of(1, 20))
              .getContent();

      return aux.stream().map(a -> mapper.map(a, ActorDTO.class)).collect(Collectors.toList());
   }

   @Override
   public ActorDTO findById(Long id) {
      Optional<Actor> actor = iActorRepository.findById(id);
      return mapper.map(actor.get(), ActorDTO.class);
   }

   @Override
   public void updateActor(ActorDTO actor) {
      Actor updateActor = mapper.map(actor, Actor.class);
      iActorRepository.save(updateActor);
   }
}
