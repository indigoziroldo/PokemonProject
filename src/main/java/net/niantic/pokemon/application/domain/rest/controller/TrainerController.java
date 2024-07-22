package net.niantic.pokemon.application.domain.rest.controller;

import net.niantic.pokemon.application.domain.service.TrainerService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerService trainerService;
}
