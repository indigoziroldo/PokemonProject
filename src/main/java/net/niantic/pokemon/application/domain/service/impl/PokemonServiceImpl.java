package net.niantic.pokemon.application.domain.service.impl;

import net.niantic.pokemon.application.domain.entities.PokemonEntity;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;
import net.niantic.pokemon.application.domain.repository.PokemonRepository;
import net.niantic.pokemon.application.domain.repository.TrainerRepository;
import net.niantic.pokemon.application.domain.rest.dto.PokemonDTO;
import net.niantic.pokemon.application.domain.rest.dto.TrainerDTO;
import net.niantic.pokemon.application.domain.rest.forms.PokemonForm;
import net.niantic.pokemon.application.domain.service.PokemonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    private final TrainerRepository trainerRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, TrainerRepository trainerRepository) {
        this.pokemonRepository = pokemonRepository;
        this.trainerRepository = trainerRepository;
    }

    public List<PokemonDTO> pokemons(){
        List<PokemonEntity> pokemonEntities = pokemonRepository.findAll();
        return pokemonEntities.stream().map(PokemonDTO::new).collect(Collectors.toList());
    }

    public List<TrainerDTO> trainersPerPokemon(Long id){
        Optional<PokemonEntity> pokemonEntity = pokemonRepository.findById(id);
        authPokemon(pokemonEntity);
        List<TrainerEntity> trainerEntities = this.trainerRepository.findAllByPokemon(pokemonEntity.get());

        return trainerEntities.stream().map(TrainerDTO::new).collect(Collectors.toList());
    }

    void authPokemon(Optional<PokemonEntity> pokemonEntity){
        if(pokemonEntity.isEmpty()){
            throw new RuntimeException("pokemon not found");
        }
    }


    @Override
    public void createPokemon(PokemonForm pokemonForm) {

    }

    @Override
    public List<PokemonDTO> getAllPokemons() {
        return List.of();
    }

    @Override
    public void updatePokemon(PokemonForm pokemonForm, Long id) {

    }

    @Override
    public void deletePokemon(Long id) {

    }
}
