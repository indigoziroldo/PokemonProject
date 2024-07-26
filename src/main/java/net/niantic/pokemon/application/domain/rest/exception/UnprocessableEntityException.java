package net.niantic.pokemon.application.domain.rest.exception;

public class UnprocessableEntityException extends RuntimeException { // pra quando dá erro nas regras de negócio da api

    public static final Long serialVersionUID = 422L;

    public UnprocessableEntityException(String message) {
        super(message);
    }
}
