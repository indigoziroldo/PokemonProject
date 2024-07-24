package net.niantic.pokemon.application.domain.service.impl;

import net.niantic.pokemon.application.domain.entities.BattleEntity;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;
import net.niantic.pokemon.application.domain.repository.BattleRepository;
import net.niantic.pokemon.application.domain.repository.TrainerRepository;
import net.niantic.pokemon.application.domain.rest.dto.BattleDTO;
import net.niantic.pokemon.application.domain.rest.dto.TrainerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BattleServiceImpl {

    private final BattleRepository battleRepository;
    private final TrainerRepository trainerRepository;

    public BattleServiceImpl(BattleRepository battleRepository, TrainerRepository trainerRepository) {
        this.battleRepository = battleRepository;
        this.trainerRepository = trainerRepository;
    }

    public List<BattleDTO> battles(){
        List<BattleEntity> battleEntities = battleRepository.findAll();
        return battleEntities.stream().map(BattleDTO::new).collect(Collectors.toList());
    }

    public List<TrainerDTO> trainersPerBattle(Long id){
        Optional<BattleEntity> battleEntity = battleRepository.findTrainersById(id);
        authBattle(battleEntity);
        List<TrainerEntity> trainerEntities = this.trainerRepository.findAllByBattle(battleEntity.get());

        return trainerEntities.stream().map(TrainerDTO::new).collect(Collectors.toList());

    }

    void authBattle(Optional<BattleEntity> battleEntity){
        if(battleEntity.isEmpty()){
            throw new RuntimeException("Battle entity not found");
        }
    }


}
