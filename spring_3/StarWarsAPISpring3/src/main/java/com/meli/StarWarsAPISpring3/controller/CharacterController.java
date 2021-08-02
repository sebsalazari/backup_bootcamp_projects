package com.meli.StarWarsAPISpring3.controller;

import com.meli.StarWarsAPISpring3.model.CharacterDTO;
import com.meli.StarWarsAPISpring3.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CharacterController {

   @Autowired
   ICharacterService characterService;

   @GetMapping("/api/starwars")
   public ResponseEntity<List<CharacterDTO>> createCharacter(@RequestParam String name) throws IOException {
      return new ResponseEntity<>(characterService.getCharacters(name), HttpStatus.OK);
   }
}
