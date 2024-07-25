package net.niantic.pokemon.application.domain.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.niantic.pokemon.application.domain.rest.dto.PlaceDTO;
import net.niantic.pokemon.application.domain.rest.forms.PlaceForm;
import net.niantic.pokemon.application.domain.service.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create")
    public void createPlace(@RequestBody @Valid PlaceForm placeForm) {
        this.placeService.createPlace(placeForm);
    }

    //READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/search")
    public List<PlaceDTO> getAllPlaces() {
        return this.placeService.getAllPlaces();
    }

    //UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/update")
    public void updatePlace(@RequestBody @Valid PlaceForm placeForm, Long id) {
        this.placeService.updatePlace(placeForm, id);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/delete")
    public String deletePlace(@PathVariable Long id) {
        this.placeService.deletePlace(id);
        return "Deleted";
    }
}
