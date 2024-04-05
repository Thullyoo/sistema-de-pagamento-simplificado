package br.thullyo.sistemadepagamentosimplificado.service;

import br.thullyo.sistemadepagamentosimplificado.DTO.UserType;
import br.thullyo.sistemadepagamentosimplificado.domain.Transaction;
import br.thullyo.sistemadepagamentosimplificado.domain.User;
import br.thullyo.sistemadepagamentosimplificado.mocky.AuthMocky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AuthorizationService {

    @Autowired
    AuthMocky authMocky;

    public boolean authorization(User payee, User payer, BigDecimal value){
        if (payer.getType() == UserType.MERCHANT){
            return false;
        }
        if (payer.getBalance().compareTo(value) < 0){
            return false;
        }
        return authMocky.auth();
    }


}
