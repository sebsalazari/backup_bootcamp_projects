package com.meli.StarWarsAPISpring3.service;

import com.meli.StarWarsAPISpring3.repository.ICharacterRepository;
import com.meli.StarWarsAPISpring3.model.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CharacterService implements ICharacterService {

   @Autowired
   ICharacterRepository iCharacterRepository;

   @Override
   public List<CharacterDTO> getCharacters(String name) throws IOException {
      return iCharacterRepository.getCharacterByName(name);
   }

}
