package net.niantic.pokemon.application.domain.rest.forms;

import lombok.Getter;

@Getter
public class UserForm {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long battlesEarned;
    private String favoritePokemon;
    private String gender;
}
