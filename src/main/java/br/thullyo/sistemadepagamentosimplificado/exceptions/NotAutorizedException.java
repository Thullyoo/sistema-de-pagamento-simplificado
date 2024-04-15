package br.thullyo.sistemadepagamentosimplificado.exceptions;

public class NotAutorizedException extends RuntimeException{

    public NotAutorizedException(){ super("Transaciton Not Autorized");}

    public NotAutorizedException(String message){ super(message);}
}
