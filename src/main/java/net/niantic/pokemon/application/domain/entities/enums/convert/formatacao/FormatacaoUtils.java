package net.niantic.pokemon.application.domain.entities.enums.convert.formatacao;

import java.text.Collator;
import java.util.Locale;

public class FormatacaoUtils {

    public static final Locale LOCALE_BR = new Locale("pt", "BR");

    public static final Collator COLLATOR = Collator.getInstance(LOCALE_BR);
}
