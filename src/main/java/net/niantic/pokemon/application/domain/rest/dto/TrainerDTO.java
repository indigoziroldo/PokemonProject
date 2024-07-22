package net.niantic.pokemon.application.domain.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TrainerDTO {

    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String gender;
    private List<PokemonDTO> pokemon;
    private List<BattleDTO> battle;

}
