package com.meli.StarWarsAPISpring3.repository;

import com.meli.StarWarsAPISpring3.model.CharacterDTO;

import java.io.IOException;
import java.util.List;

public interface ICharacterRepository {
   List<CharacterDTO> getCharacterByName(String name) throws IOException;
}
