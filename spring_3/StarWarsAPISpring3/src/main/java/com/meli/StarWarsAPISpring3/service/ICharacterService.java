package com.meli.StarWarsAPISpring3.service;

import com.meli.StarWarsAPISpring3.model.CharacterDTO;

import java.io.IOException;
import java.util.List;

public interface ICharacterService {
   List<CharacterDTO> getCharacters (String name) throws IOException;
}
