package com.meli.SpoiledTomatoesAPI.controller;

import com.meli.SpoiledTomatoesAPI.model.DTO.SerieDTO;
import com.meli.SpoiledTomatoesAPI.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("serie")
public class SerieController {

   @Autowired
   ISerieService iSerieService;

   @PostMapping("/new_serie")
   public ResponseEntity<String> createSerie(@RequestBody SerieDTO serieDTO) {
      iSerieService.createSerie(serieDTO);
      return new ResponseEntity<>("Serie guardada correctamente en la DB", HttpStatus.CREATED);
   }

   @DeleteMapping("/delete_serie/{id}")
   public ResponseEntity<String> deleteSerie(@PathVariable Long id) {
      iSerieService.deleteSerie(id);
      return new ResponseEntity<>("Serie eliminada correctamente en la DB", HttpStatus.OK);
   }

   @GetMapping("/get_series")
   public ResponseEntity<List<SerieDTO>> getSeries() {
      return new ResponseEntity<>(iSerieService.findAll(), HttpStatus.OK);
   }

   // Consultas HQL - Practica
   @GetMapping("/get_series/total/seasons/{numSeasons}")
   public ResponseEntity<List<SerieDTO>> getSeriesByNumSeasons(@PathVariable Integer numSeasons) {
      return new ResponseEntity<>(iSerieService.getSeriesByNumberSeasons(numSeasons), HttpStatus.OK);
   }
}
