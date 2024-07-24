package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private PlaceEntity place;

    @Column(name = "trainers_ids")
    private List<Long> trainerIds;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "trainer_battles",
            joinColumns = @JoinColumn(name = "battle_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id", referencedColumnName = "id"))
    private List<TrainerEntity> trainers;


}
