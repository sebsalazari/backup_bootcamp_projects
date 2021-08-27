package com.meli.SpoiledTomatoesAPI.service;

import com.meli.SpoiledTomatoesAPI.model.DTO.ActorDTO;

import java.util.List;

public interface IActorService {
   void createActor(ActorDTO actor);

   void deleteActor(Long id);

   List<ActorDTO> findAll();

   ActorDTO findById(Long id);

   void updateActor(ActorDTO actor);
}
