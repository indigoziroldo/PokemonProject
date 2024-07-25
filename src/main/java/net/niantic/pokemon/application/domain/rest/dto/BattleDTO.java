package net.niantic.pokemon.application.domain.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.niantic.pokemon.application.domain.entities.BattleEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class BattleDTO {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private PlaceDTO placeDTO;
    private TrainerDTO trainerDTO;

    public BattleDTO(BattleEntity battleEntity) {
        this.id = battleEntity.getId();
        this.startTime = battleEntity.getStartTime();
        this.endTime = battleEntity.getEndTime();
        this.placeDTO = new PlaceDTO(battleEntity.getPlace());
        this.trainerDTO = new TrainerDTO(battleEntity.getTrainer());
    }
    public static List<BattleDTO> convertToDTO(List<BattleEntity> battleEntities) {
        return battleEntities
                .stream()
                .map(BattleDTO::new)
                .collect(Collectors.toList());
    }

}
