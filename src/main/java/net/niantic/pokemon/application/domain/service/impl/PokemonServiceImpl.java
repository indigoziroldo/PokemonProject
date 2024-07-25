package net.niantic.pokemon.application.domain.service.impl;

import net.niantic.pokemon.application.domain.entities.PokemonEntity;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;
import net.niantic.pokemon.application.domain.entities.enums.Type;
import net.niantic.pokemon.application.domain.repository.PokemonRepository;
import net.niantic.pokemon.application.domain.repository.TrainerRepository;
import net.niantic.pokemon.application.domain.rest.dto.PokemonDTO;
import net.niantic.pokemon.application.domain.rest.dto.TrainerDTO;
import net.niantic.pokemon.application.domain.rest.exception.ResourceNotFoundException;
import net.niantic.pokemon.application.domain.rest.forms.PokemonForm;
import net.niantic.pokemon.application.domain.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

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
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setName(pokemonForm.getName());
        pokemonEntity.setHp(pokemonForm.getHp());
        pokemonEntity.setAttack(pokemonForm.getAttack());
        pokemonEntity.setDefense(pokemonForm.getDefense());
        pokemonEntity.setSpeed(pokemonForm.getSpeed());
        pokemonEntity.setType(Type.valueOf(pokemonForm.getType()));
        this.pokemonRepository.save(pokemonEntity);
    }

    @Override
    public List<PokemonDTO> getAllPokemons() {
        List<PokemonEntity> pokemonEntities = pokemonRepository.findAll();
        if(pokemonEntities.isEmpty()) throw new ResourceNotFoundException("Pokemon not found");
        return PokemonDTO.convertToDTO(pokemonEntities);
    }

    @Override
    public void updatePokemon(PokemonForm pokemonForm, Long id) {
        Optional<PokemonEntity> pokemonEntity = pokemonRepository.findById(id);
        PokemonEntity pokemonUpdated = pokemonEntity
                .orElseThrow(() -> new ResourceNotFoundException("Pokemon not found"));
        pokemonRepository.save(convertFormToEntity(pokemonForm,id));
    }

    private PokemonEntity convertFormToEntity(PokemonForm pokemonForm, Long id) {
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setId(id);
        pokemonEntity.setName(pokemonForm.getName());
        pokemonEntity.setHp(pokemonForm.getHp());
        pokemonEntity.setDefense(pokemonForm.getDefense());
        pokemonEntity.setSpeed(pokemonForm.getSpeed());
        pokemonEntity.setType(Type.valueOf(pokemonForm.getType()));
        pokemonEntity.setTrainer(trainerRepository
                .findById(pokemonForm.getTrainerId())
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found")));
        return pokemonEntity;
    }

    @Override
    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }
}
