package net.niantic.pokemon.application.domain.service.impl;

import net.niantic.pokemon.application.domain.entities.BattleEntity;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;
import net.niantic.pokemon.application.domain.repository.BattleRepository;
import net.niantic.pokemon.application.domain.repository.PlaceRepository;
import net.niantic.pokemon.application.domain.repository.TrainerRepository;
import net.niantic.pokemon.application.domain.rest.dto.BattleDTO;
import net.niantic.pokemon.application.domain.rest.dto.TrainerDTO;
import net.niantic.pokemon.application.domain.rest.exception.ResourceNotFoundException;
import net.niantic.pokemon.application.domain.rest.forms.BattleForm;
import net.niantic.pokemon.application.domain.service.BattleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BattleServiceImpl implements BattleService {

    private final BattleRepository battleRepository;
    private final TrainerRepository trainerRepository;
    private final PlaceRepository placeRepository;

    public BattleServiceImpl(BattleRepository battleRepository, TrainerRepository trainerRepository, PlaceRepository placeRepository) {
        this.battleRepository = battleRepository;
        this.trainerRepository = trainerRepository;
        this.placeRepository = placeRepository;
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

    //CREATE
    @Override
    public void createBattle(BattleForm battleForm) {
        BattleEntity battleEntity = new BattleEntity();
        battleEntity.setStartTime(LocalDateTime.parse(battleForm.getStartTime()));
        battleEntity.setEndTime(LocalDateTime.parse(battleForm.getEndTime()));
        battleEntity.setPlaceId(battleForm.getPlaceId());
        battleEntity.setTrainerIds(battleForm.getTrainersIds());
        this.battleRepository.save(battleEntity);

    }

    //READ
    @Override
    public List<BattleDTO> getAllBattles() {
        List<BattleEntity> battleEntities = battleRepository.findAll();
        if(battleEntities.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Battle not found");
        return BattleDTO.convertToDTO(battleEntities);
    }

    //UPDATE
    @Override
    public void updateBattle(BattleForm battleForm, Long id) {
        Optional<BattleEntity> battleEntity = battleRepository.findById(id);
        BattleEntity battleUpdated = battleEntity.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Battle not found"));
        battleRepository.save(convertFormToEntity(battleForm,id));
    }

    private BattleEntity convertFormToEntity(BattleForm battleForm, Long id) {
        BattleEntity battleEntity = new BattleEntity();
        battleEntity.setStartTime(LocalDateTime.parse(battleForm.getStartTime()));
        battleEntity.setEndTime(LocalDateTime.parse(battleForm.getEndTime()));
        battleEntity.setPlace(placeRepository
                .findById(battleForm.getPlaceId())
                .orElseThrow(() -> new ResourceNotFoundException("Place not found")));
        battleEntity.setTrainer1(); // SOCORRO
        battleEntity.setId(id);
    }

    //DELETE
    @Override
    public void deleteBattle(Long id) {

    }
}
