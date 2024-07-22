package net.niantic.pokemon.application.domain.service;

import net.niantic.pokemon.application.domain.rest.dto.TrainerDTO;
import net.niantic.pokemon.application.domain.rest.forms.TrainerForm;

import java.util.List;

public interface TrainerService {

    void createTrainer(TrainerForm trainerForm);

    List<TrainerDTO> getAllTrainers();

    void updateTrainer(TrainerForm trainerForm, Long id);

    void deleteTrainer(Long id);
}
