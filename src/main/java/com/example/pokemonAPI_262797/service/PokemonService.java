package com.example.pokemonAPI_262797.service;

import com.example.pokemonAPI_262797.model.Pokemon;
import com.example.pokemonAPI_262797.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> obtenerTodos (){
        return pokemonRepository.findAll();
    }
    public Pokemon obtenerPorId (Long id){
        return pokemonRepository.findById(id).orElse(null);
    }
    public Pokemon crear (Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    public Pokemon actualizar(Long id, Pokemon pokemon) {
        Pokemon encontrado = obtenerPorId(id);
        if (encontrado == null) {
            return null;
        }
        pokemon.setId(id);
        return pokemonRepository.save(pokemon);
    }
    public Pokemon eliminar (Long id){
        Pokemon encontrado = obtenerPorId(id);
        if(encontrado == null){
            return null;
        }
        pokemonRepository.deleteById(id);
        return encontrado;
    }

    public Pokemon actualizarParcial(Long id, Pokemon pokemon) {
        Pokemon encontrado = pokemonRepository.findById(id).orElse(null);
        if (encontrado == null) {
            return null;
        }
        if (pokemon.getNombre() != null) {
            encontrado.setNombre(pokemon.getNombre());
        }
        if (pokemon.getTipo() != null) {
            encontrado.setTipo(pokemon.getTipo());
        }
        if (pokemon.getNivel() != null) {
            encontrado.setNivel(pokemon.getNivel());
        }
        if (pokemon.getAtaque() != null) {
            encontrado.setAtaque(pokemon.getAtaque());
        }
        if (pokemon.getDefensa() != null) {
            encontrado.setDefensa(pokemon.getDefensa());
        }
        if (pokemon.getDescripcion() != null) {
            encontrado.setDescripcion(pokemon.getDescripcion());
        }
        if (pokemon.getImagenUrl() != null) {
            encontrado.setImagenUrl(pokemon.getImagenUrl());
        }
        return pokemonRepository.save(encontrado);
    }
}
