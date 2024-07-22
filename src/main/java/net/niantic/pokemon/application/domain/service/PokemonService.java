package net.niantic.pokemon.application.domain.service;

import net.niantic.pokemon.application.domain.rest.dto.PokemonDTO;
import net.niantic.pokemon.application.domain.rest.forms.PokemonForm;

import java.util.List;

public interface PokemonService {

    void createPokemon (PokemonForm pokemonForm);

    List<PokemonDTO> getAllPokemons();

    void updatePokemon (PokemonForm pokemonForm, Long id);

    void deletePokemon(Long id);
}
