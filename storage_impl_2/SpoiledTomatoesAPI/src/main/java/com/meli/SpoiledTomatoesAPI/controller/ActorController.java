package com.meli.SpoiledTomatoesAPI.controller;

import com.meli.SpoiledTomatoesAPI.model.DTO.ActorDTO;
import com.meli.SpoiledTomatoesAPI.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actor")
public class ActorController {

   @Autowired
   IActorService iActorService;

   @PostMapping("/new_actor")
   public ResponseEntity<String> createActor(@RequestBody ActorDTO actorRequestDTO) {
      iActorService.createActor(actorRequestDTO);
      return new ResponseEntity<>("Actor creado correctamente en la DB", HttpStatus.CREATED);
   }

   @PostMapping("/delete_actor/{id}")
   public ResponseEntity<String> deleteActor(@PathVariable Long id) {
      iActorService.deleteActor(id);
      return new ResponseEntity<>("Actor eliminado correctamente en la DB", HttpStatus.OK);
   }

   @GetMapping("/get_actors")
   public ResponseEntity<List<ActorDTO>> getActors() {
      return new ResponseEntity<>(iActorService.findAll(), HttpStatus.OK);
   }

   @GetMapping("/get_one_actor/{id}")
   public ResponseEntity<ActorDTO> getOneActor(@PathVariable Long id) {
      return new ResponseEntity<>(iActorService.findById(id), HttpStatus.OK);
   }

   @PostMapping("/update_actor")
   public ResponseEntity<String> updateActor(@RequestBody ActorDTO actorRequestDTO) {
      iActorService.updateActor(actorRequestDTO);
      return new ResponseEntity<>("Actor actualizado correctamente en la DB", HttpStatus.OK);
   }
}
