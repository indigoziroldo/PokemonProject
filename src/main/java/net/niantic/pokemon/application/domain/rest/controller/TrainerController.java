package net.niantic.pokemon.application.domain.rest.controller;

import jakarta.validation.Valid;
import net.niantic.pokemon.application.domain.service.TrainerService;
import net.niantic.pokemon.application.domain.rest.dto.TrainerDTO;
import net.niantic.pokemon.application.domain.rest.forms.TrainerForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerService trainerService;

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create")
    public void createTrainer(@RequestBody @Valid TrainerForm trainerForm) {
        this.trainerService.createTrainer(trainerForm);
    }

    //READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/search")
    public List<TrainerDTO> getAllTrainers() {
        return this.trainerService.getAllTrainers();
    }

    //UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/update")
    public void updateTrainer(@RequestBody @Valid TrainerForm trainerForm, Long id) {
        this.trainerService.updateTrainer(trainerForm, id);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/delete")
    public String deleteTrainer(@PathVariable Long id) {
        this.trainerService.deleteTrainer(id);
        return "Deleted";
    }

}
