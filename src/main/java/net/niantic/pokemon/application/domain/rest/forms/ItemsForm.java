package net.niantic.pokemon.application.domain.rest.forms;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ItemsForm {

    private Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal basePower;

}
