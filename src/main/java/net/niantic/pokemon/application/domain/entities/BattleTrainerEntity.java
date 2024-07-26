package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BATTLE_TRAINER", schema = "public")
public class BattleTrainerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "battle_id")
  private Long battleId;

  @Column(name = "trainer_id")
  private Long trainerId;

  @ManyToOne()
  @JoinColumn(name = "trainer_id")
  private TrainerEntity trainer;

  @ManyToOne()
  @JoinColumn(name = "battle_id")
  private BattleEntity battle;

}
