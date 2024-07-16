package net.niantic.pokemon.application.domain.entities.enums.convert.service;

import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.DescricaoEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.GettersEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ValorEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.model.InformacaoEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.formatacao.FormatacaoUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertInfoEnum {

    public static <E extends Enum<E> & GettersEnum<T>, T> List<InformacaoEnum> gerarListaComInformacoesDoEnum(E[] constantesEnum){
        List<InformacaoEnum> informacoesEnum = new ArrayList<>();

        for (E constanteEnum : constantesEnum)
            informacoesEnum.add(new InformacaoEnum(constanteEnum.getValor(),
                    constanteEnum.getDescricao()));

        return informacoesEnum;
    }

    /**
     * Método responsável por gerar uma lista a partir das informações das constantes do Enum ordenadas pela descrição
     * @param <E> - Tipo do Enum
     * @param <T> - Tipo do valor do Enum
     * @param constantesEnum - {@code E[]}
     * @return {@code List<InformacaoEnum>}
     */

    public static <E extends Enum<E> & GettersEnum<T>, T> List<InformacaoEnum> gerarListaComInformacoesDoEnumOrdenadasPelaDescricao(E[] constantesEnum){
        Function<E, InformacaoEnum> function = constanteEnum -> new InformacaoEnum(constanteEnum.getValor(), constanteEnum.getDescricao());
        return ordenarConstantesDoEnumPelaDescricao(constantesEnum, function);
    }

    /**
     * Método responsável por ordenar as constantes do Enum pela descrição
     * @param <E> - Tipo do Enum
     * @param <T> - Tipo do valor do Enum
     * @param constantesEnum - {@code E[]}
     * @param function - {@code Function<E, T>}
     * @return {@code List<T>}
     */

    private static <E extends Enum<E> & DescricaoEnum, T> List<T> ordenarConstantesDoEnumPelaDescricao(E[] constantesEnum, Function<E, T> function){
        Comparator<DescricaoEnum> comparator = ((descricaoEnum, descricao2) -> FormatacaoUtils.COLLATOR.compare(descricaoEnum, descricao2));

        return Arrays.asList(constantesEnum)
                .stream()
                .sorted(comparator)
                .map(function)
                .collect(Collectors.toList());
    }

    /**
     * Método responsável por gerar uma lista com as descrições do Enum
     * @param <E> - {@code List<String>}
     * @param constantesEnum - {@code E[]}
     * @return {@code List<String>}
     */

    public static <E extends Enum<E> & DescricaoEnum> List<String> gerarListaComDescricoesDoEnum(E[] constantesEnum){
        List<String> descricoesEnum = new ArrayList<>();

        for (E constanteEnum : constantesEnum)
            descricoesEnum.add(constanteEnum.getDescricao());

        return descricoesEnum;
    }

    /**
     * Método responsável por gerar uma lista ordenada com as descrições do Enum
     * @param <E> - Tipo do Enum
     * @param constantesEnum - {@code E[]}
     * @return {@code List<String>}
     */

    public static <E extends Enum<E> & DescricaoEnum> List<String> gerarListaOrdenadaComDescricoesDoEnum(E[] constantesEnum){
        return ordenarConstantesDoEnumPelaDescricao(constantesEnum, DescricaoEnum::getDescricao);
    }

    /**
     * Método responsável por gerar com os valores do Enum
     * @param <E> - Tipo do Enum
     * @param <T> - Tipo do valor do Enum
     * @param constantesEnum - {@code E[]}
     * @return {@code List<T>}
     */

    public static <E extends Enum<E> & ValorEnum<T>, T> List<T> gerarListaComValoresDoEnum(E[] constantesEnum){
        List<T> valoresEnum = new ArrayList<>();

        for (E constanteEnum : constantesEnum)
            valoresEnum.add(constanteEnum.getValor());

        return valoresEnum;
    }

    /**
     * Método responsável por gerar uma lista ordenada com os valores do Enum
     * @param <E> - Tipo do Enum
     * @param <T> - Tipo do valor do Enum
     * @param constantesEnum - {@code E[]}
     * @return {@code List<T>}
     */

    public static <E extends Enum<E> & ValorEnum<T>, T> List<T> gerarListaOrdenadaComValoresDoEnum(E[] constantesEnum){
        Comparator<T> comparator = (valorEnum, valor2) -> FormatacaoUtils.COLLATOR.compare(valorEnum, valor2);

        return Arrays.asList(constantesEnum)
                .stream()
                .map(ValorEnum::getValor)
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
