package net.niantic.pokemon.application.domain.service.impl;

import net.niantic.pokemon.application.domain.entities.PokemonEntity;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;
import net.niantic.pokemon.application.domain.repository.PokemonRepository;
import net.niantic.pokemon.application.domain.repository.TrainerRepository;
import net.niantic.pokemon.application.domain.rest.dto.PokemonDTO;
import net.niantic.pokemon.application.domain.rest.dto.TrainerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TrainerServiceImpl {

    private final TrainerRepository trainerRepository;
    private final PokemonRepository pokemonRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository, PokemonRepository pokemonRepository) {
        this.trainerRepository = trainerRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public List<TrainerDTO> trainers (){
        List<TrainerEntity> trainerEntities = trainerRepository.findAll();
        return trainerEntities.stream().map(TrainerDTO::new).collect(Collectors.toList());
    }

    public List<PokemonDTO> pokemonsPerTrainer (Long id){
        Optional<TrainerEntity> trainerEntity = trainerRepository.findById(id);
        validartreinador(trainerEntity);
        List<PokemonEntity> pokemonEntities = pokemonRepository.findAllByTrainer(trainerEntity.get());

        return pokemonEntities.stream().map(PokemonDTO::new).collect(Collectors.toList());
    }
    void validartreinador(Optional<TrainerEntity> trainerEntity){
        if(trainerEntity.isEmpty()){
            throw new RuntimeException("trainer not found");
        }
    }

}
