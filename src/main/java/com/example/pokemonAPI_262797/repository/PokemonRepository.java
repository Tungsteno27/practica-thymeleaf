package com.example.pokemonAPI_262797.repository;

import com.example.pokemonAPI_262797.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
