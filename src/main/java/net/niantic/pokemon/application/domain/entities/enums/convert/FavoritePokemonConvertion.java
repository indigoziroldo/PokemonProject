package net.niantic.pokemon.application.domain.entities.enums.convert;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.niantic.pokemon.application.domain.entities.enums.FavoritePokemon;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ConvertEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.service.ConvertEnumMaybeNull;

@Converter(autoApply = true)
public class FavoritePokemonConvertion implements AttributeConverter<FavoritePokemon, String> {

    public ConvertEnum<FavoritePokemon, String> convertEnum = new ConvertEnumMaybeNull<>();

    @Override
    public String convertToDatabaseColumn(FavoritePokemon favoritePokemon) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(favoritePokemon);
    }
    public FavoritePokemon convertToEntityAttribute(String dbData) {
        return convertEnum.getEnum(FavoritePokemon.values(), dbData);
    }
}
