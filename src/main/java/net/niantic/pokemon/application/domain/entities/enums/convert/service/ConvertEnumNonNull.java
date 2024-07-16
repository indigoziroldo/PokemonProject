package net.niantic.pokemon.application.domain.entities.enums.convert.service;

import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ConvertEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ValorEnum;

import java.util.Objects;

public class ConvertEnumNonNull <E extends Enum<E> & ValorEnum<T>, T> implements ConvertEnum<E, T> {

    public T getRepresentacaoValorEnumParaBancoDeDados(E tipoEnum){
        return tipoEnum.getValor();
    }

    public E getEnum (E[] valoresEnum, T valorEnum){
        if(Objects.isNull(valorEnum))
            throw new NullPointerException("O 'valorEnum' não pode "
            + "ser convertido para o Enum '" + valoresEnum
                    .getClass()
                    .getSimpleName()
                    .split("\\[\\]")[0]
            + "' pois ele está nulo!");

        for (E valorEnumAtual : valoresEnum)
            if (valorEnumAtual.getValor().equals(valorEnum))
                return valorEnumAtual;

        throw new IllegalArgumentException("O valor '" + valorEnum
        + "' para o Enum '" + valoresEnum
                .getClass()
                .getSimpleName()
                .split("\\[\\]")[0]
        + "' é inválido!");
    }
}
