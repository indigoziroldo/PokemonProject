package net.niantic.pokemon.application.domain.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.niantic.pokemon.application.domain.rest.dto.PokemonDTO;
import net.niantic.pokemon.application.domain.service.PokemonService;
import net.niantic.pokemon.application.domain.rest.forms.PokemonForm;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create")
    public void createPokemon(@RequestBody @Valid PokemonForm battleForm) {
        this.pokemonService.createPokemon(battleForm);
    }

    //READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/search")
    public List<PokemonDTO> getAllPokemons() {
        return this.pokemonService.getAllPokemons();
    }

    //UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/update")
    public void updatePokemon(@RequestBody @Valid PokemonForm pokemonForm, Long id) {
        this.pokemonService.updatePokemon(pokemonForm, id);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/delete")
    public String deletePokemon(@PathVariable Long id) {
        this.pokemonService.deletePokemon(id);
        return "Deleted";
    }
}
