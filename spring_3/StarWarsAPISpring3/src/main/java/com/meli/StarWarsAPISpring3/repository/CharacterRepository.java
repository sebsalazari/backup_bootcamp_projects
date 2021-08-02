package com.meli.StarWarsAPISpring3.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.StarWarsAPISpring3.model.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository {
   @Override
   public List<CharacterDTO> getCharacterByName(String name) throws IOException {
      List<CharacterDTO> characterList = null;
      characterList = loadDatabaseStarWars();

      return characterList.stream().filter(item -> nameContaining(item, name)).collect(Collectors.toList());
   }

   // Load database - JSON
   public List<CharacterDTO> loadDatabaseStarWars() throws IOException {
      File file = null;
      file = ResourceUtils.getFile("classpath:starwars.json");

      ObjectMapper om = new ObjectMapper();
      TypeReference<List<CharacterDTO>> typeDef = new TypeReference<>() {
      };

      List<CharacterDTO> characterList = null;
      characterList = om.readValue(file, typeDef);

      return characterList;
   }

   // Contains some part of character
   private boolean nameContaining(CharacterDTO c, String name) {
      return c.getName().toLowerCase().contains(name.toLowerCase());
   }
}
