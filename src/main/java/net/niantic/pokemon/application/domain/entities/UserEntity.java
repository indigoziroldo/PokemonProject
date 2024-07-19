package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import net.niantic.pokemon.application.domain.entities.enums.FavoritePokemon;
import net.niantic.pokemon.application.domain.entities.enums.Gender;
import net.niantic.pokemon.application.domain.entities.enums.Region;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "public")
public class UserEntity {
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

    @Column(name = "battles_earned")
    private Long battlesEarned;

    @Column(name = "favorite_pokemon")
    private FavoritePokemon favoritePokemon;

    @Column
    private Gender gender;

}
