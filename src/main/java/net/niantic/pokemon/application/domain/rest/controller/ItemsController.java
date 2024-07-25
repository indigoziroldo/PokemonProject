package net.niantic.pokemon.application.domain.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.niantic.pokemon.application.domain.rest.dto.ItemsDTO;
import net.niantic.pokemon.application.domain.rest.forms.ItemsForm;
import net.niantic.pokemon.application.domain.service.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemsController {

    private final ItemsService itemsService;

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create")
    public void createItems(@RequestBody @Valid ItemsForm itemsForm) {
        this.itemsService.createItems(itemsForm);
    }

    //READ
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/search")
    public List<ItemsDTO> getAllItems() {
        return this.itemsService.getAllItems();
    }

    //UPDATE
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @PutMapping(path = "/update")
    public void updateItem(@RequestBody @Valid ItemsForm itemsForm, Long id) {
        this.itemsService.updateItems(itemsForm, id);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/delete")
    public String deleteItem(@PathVariable Long id) {
        this.itemsService.deleteItems(id);
        return "Deleted";
    }
}
