package net.niantic.pokemon.application.domain.entities.enums.convert.interfaces;

public interface ConvertEnum <E extends Enum<? extends ValorEnum<T>>, T> {
    T getRepresentacaoValorEnumParaBancoDeDados(E tipoEnum);
    E getEnum(E[] valoresEnum, T valorEnum);
}
