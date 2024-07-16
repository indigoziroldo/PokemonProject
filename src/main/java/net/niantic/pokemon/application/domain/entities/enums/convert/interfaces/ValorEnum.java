package net.niantic.pokemon.application.domain.entities.enums.convert.interfaces;

import com.fasterxml.jackson.annotation.JsonValue;


public interface ValorEnum<T> {


    @JsonValue
    T getValor();
}