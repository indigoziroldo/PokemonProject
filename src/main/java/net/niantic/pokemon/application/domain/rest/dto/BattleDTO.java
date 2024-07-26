package net.niantic.pokemon.application.domain.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.niantic.pokemon.application.domain.entities.BattleEntity;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BattleDTO {
  private Long id;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private PlaceDTO placeDTO;
  private BattleTrainer trainer1;
  private BattleTrainer trainer2;

  public BattleDTO(BattleEntity battleEntity, TrainerEntity trainer1, TrainerEntity trainer2) {
    this.id = battleEntity.getId();
    this.startTime = battleEntity.getStartTime();
    this.endTime = battleEntity.getEndTime();
    this.placeDTO = new PlaceDTO(battleEntity.getPlace());
    this.trainer1 = new BattleTrainer(trainer1.getId());
    this.trainer2 = new BattleTrainer(trainer2.getId());
  }

  @Getter
  @Setter
  @AllArgsConstructor
  protected static class BattleTrainer {
    private long id;
  }

}
