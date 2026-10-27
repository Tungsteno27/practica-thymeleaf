package com.example.pokemonAPI_262797.controller;

import com.example.pokemonAPI_262797.model.Pokemon;
import com.example.pokemonAPI_262797.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> listar(){
        return pokemonService.obtenerTodos();
    }
    @PostMapping
    public Pokemon crear(@RequestBody Pokemon pokemon){
        return pokemonService.crear(pokemon);
    }
    @GetMapping("/{id}")
    public Pokemon obtenerPorId(@PathVariable Long id){
        return pokemonService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Pokemon  actualizar(@PathVariable Long id, @RequestBody Pokemon pokemon){
        return pokemonService.actualizar(id, pokemon);
    }
    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarParcial(id, pokemon);
    }
    @DeleteMapping("/{id}")
    public Pokemon eliminar(@PathVariable Long id){
        return pokemonService.eliminar(id);
    }
}
