package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BATTLE", schema = "public")
public class BattleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private LocalDateTime startTime;

  @Column
  private LocalDateTime endTime;

  @Column(name = "place_id")
  private Long placeId;

  @ManyToOne()
  @JoinColumn(name = "place_id", insertable = false, updatable = false)
  private PlaceEntity place;

  @OneToMany()
  @JoinColumn(name = "battle_id", insertable = false, updatable = false)
  private List<BattleTrainerEntity> matches;


  // TODO: Voltar se pedirem?
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "trainer_battles",
//            joinColumns = @JoinColumn(name = "battle_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "trainer_id", referencedColumnName = "id"))
//    private TrainerEntity trainer;


}
