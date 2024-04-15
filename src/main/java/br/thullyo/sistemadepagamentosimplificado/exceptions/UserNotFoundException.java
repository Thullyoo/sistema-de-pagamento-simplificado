package br.thullyo.sistemadepagamentosimplificado.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){super("One or both users not found");}

    public UserNotFoundException(String message){ super(message);}
}
