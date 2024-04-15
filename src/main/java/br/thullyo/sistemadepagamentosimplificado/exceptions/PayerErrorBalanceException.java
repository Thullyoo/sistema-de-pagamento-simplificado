package br.thullyo.sistemadepagamentosimplificado.exceptions;

public class PayerErrorBalanceException extends RuntimeException {

    public PayerErrorBalanceException() {super("Payer Balance is insufficient");}

    public PayerErrorBalanceException(String message) {super(message);}
}
