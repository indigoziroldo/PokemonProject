package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import net.niantic.pokemon.application.domain.entities.enums.Gender;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRAINER", schema = "public")
public class TrainerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String secondName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Gender gender;

    @OneToMany(mappedBy = "trainer")
    private List<PokemonEntity> pokemons;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "trainer_battles",
    joinColumns = @JoinColumn(name = "trainer_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "battle_id", referencedColumnName = "id"))
    private List<BattleEntity> battles;

}
