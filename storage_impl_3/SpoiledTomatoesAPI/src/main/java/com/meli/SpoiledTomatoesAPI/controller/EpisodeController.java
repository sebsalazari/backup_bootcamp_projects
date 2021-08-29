package com.meli.SpoiledTomatoesAPI.controller;

import com.meli.SpoiledTomatoesAPI.model.DTO.EpisodeDTO;
import com.meli.SpoiledTomatoesAPI.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("episode")
public class EpisodeController {
   @Autowired
   IEpisodeService iEpisodeService;

   @PostMapping("/new_episode")
   public ResponseEntity<String> createEpisode(@RequestBody EpisodeDTO episodeDTO) {
      iEpisodeService.createEpisode(episodeDTO);
      return new ResponseEntity<>("Episodio guardado correctamente en la DB", HttpStatus.CREATED);
   }

   @DeleteMapping("/delete_episode/{id}")
   public ResponseEntity<String> deleteEpisode(@PathVariable Long id) {
      iEpisodeService.deleteEpisode(id);
      return new ResponseEntity<>("Episodio eliminado correctamente en la DB", HttpStatus.OK);
   }

   @GetMapping("/get_episodes")
   public ResponseEntity<List<EpisodeDTO>> getEpisodes() {
      return new ResponseEntity<>(iEpisodeService.findAll(), HttpStatus.OK);
   }
}
