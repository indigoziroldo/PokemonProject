package net.niantic.pokemon.application.domain.service.impl;

import net.niantic.pokemon.application.domain.entities.PokemonEntity;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;
import net.niantic.pokemon.application.domain.entities.enums.Gender;
import net.niantic.pokemon.application.domain.repository.PokemonRepository;
import net.niantic.pokemon.application.domain.repository.TrainerRepository;
import net.niantic.pokemon.application.domain.rest.dto.PokemonDTO;
import net.niantic.pokemon.application.domain.rest.dto.TrainerDTO;
import net.niantic.pokemon.application.domain.rest.forms.TrainerForm;
import net.niantic.pokemon.application.domain.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TrainerServiceImpl implements TrainerService {

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
        authTrainer(trainerEntity);
        List<PokemonEntity> pokemonEntities = pokemonRepository.findAllByTrainer(trainerEntity.get());

        return pokemonEntities.stream().map(PokemonDTO::new).collect(Collectors.toList());
    }
    void authTrainer(Optional<TrainerEntity> trainerEntity){
        if(trainerEntity.isEmpty()){
            throw new RuntimeException("trainer not found");
        }
    }

    @Override
    public void createTrainer(TrainerForm trainerForm) {
        TrainerEntity trainerEntity = new TrainerEntity();
        trainerEntity.setFirstName(trainerForm.getFirstName());
        trainerEntity.setSecondName(trainerForm.getLastName());
        trainerEntity.setEmail(trainerForm.getEmail());
        trainerEntity.setPassword(trainerForm.getPassword());
        trainerEntity.setGender(Gender.valueOf(trainerForm.getGender()));

    }

    @Override
    public List<TrainerDTO> getAllTrainers() {
        return List.of();
    }

    @Override
    public void updateTrainer(TrainerForm trainerForm, Long id) {

    }

    @Override
    public void deleteTrainer(Long id) {

    }
}
