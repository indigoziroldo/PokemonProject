package net.niantic.pokemon.application.domain.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.niantic.pokemon.application.domain.rest.dto.BattleDTO;
import net.niantic.pokemon.application.domain.rest.forms.BattleForm;
import net.niantic.pokemon.application.domain.service.BattleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battle")
@RequiredArgsConstructor
public class BattleController {

    private final BattleService battleService;

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create")
    public void createBattle(@RequestBody @Valid BattleForm battleForm) {
        this.battleService.createBattle(battleForm);
    }

    //READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/search")
    public List<BattleDTO> getAllBattles() {
        return this.battleService.getAllBattles();
    }

    //UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/update")
    public void updateBattle(@RequestBody @Valid BattleForm battleForm, Long id) {
        this.battleService.updateBattle(battleForm, id);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/delete")
    public String deleteBattle(@PathVariable Long id) {
        this.battleService.deleteBattle(id);
        return "Deleted";
    }
}
