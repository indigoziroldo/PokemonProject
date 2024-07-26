package net.niantic.pokemon.application.domain.rest.exception;

public class UnprocessableEntityException extends RuntimeException { // Erro de regra de negócio

  public static final long serialVersionUID = 422L;

  public UnprocessableEntityException(String message) {
    super(message);
  }
}
