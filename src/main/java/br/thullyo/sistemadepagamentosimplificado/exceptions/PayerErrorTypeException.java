package br.thullyo.sistemadepagamentosimplificado.exceptions;

public class PayerErrorTypeException extends RuntimeException {

    public PayerErrorTypeException() {super("Payer type is invalid");}

    public PayerErrorTypeException(String message) {super(message);}
}
