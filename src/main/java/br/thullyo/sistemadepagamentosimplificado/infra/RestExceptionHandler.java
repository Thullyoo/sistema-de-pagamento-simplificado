package br.thullyo.sistemadepagamentosimplificado.infra;

import br.thullyo.sistemadepagamentosimplificado.exceptions.NotAutorizedException;
import br.thullyo.sistemadepagamentosimplificado.exceptions.PayerErrorBalanceException;
import br.thullyo.sistemadepagamentosimplificado.exceptions.PayerErrorTypeException;
import br.thullyo.sistemadepagamentosimplificado.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotAutorizedException.class)
    private ResponseEntity<String> NotAutorizedHandler(NotAutorizedException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> UserNotFoundHandler(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PayerErrorBalanceException.class)
    private ResponseEntity<String> PayerErrorBalanceHandler(PayerErrorBalanceException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(PayerErrorTypeException.class)
    private ResponseEntity<String> PayerErrorTypeHandler(PayerErrorTypeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
