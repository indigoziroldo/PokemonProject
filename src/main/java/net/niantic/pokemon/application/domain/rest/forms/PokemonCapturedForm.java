package net.niantic.pokemon.application.domain.rest.forms;

import lombok.Getter;

@Getter
public class PokemonCapturedForm {

    private Long id;
    private String capturedAt;
    private PokemonForm pokemonForm;
    private UserForm userForm;
}
