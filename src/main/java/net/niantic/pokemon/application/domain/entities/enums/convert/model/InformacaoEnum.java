package net.niantic.pokemon.application.domain.entities.enums.convert.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class InformacaoEnum {
    private Object valor;
    private String descricao;
}
