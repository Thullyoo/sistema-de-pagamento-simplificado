package br.thullyo.sistemadepagamentosimplificado.service;

import br.thullyo.sistemadepagamentosimplificado.DTO.UserType;
import br.thullyo.sistemadepagamentosimplificado.domain.Transaction;
import br.thullyo.sistemadepagamentosimplificado.domain.User;
import br.thullyo.sistemadepagamentosimplificado.repository.TransactionRepository;
import br.thullyo.sistemadepagamentosimplificado.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionServiceTest {

    @Autowired
    @InjectMocks
    TransactionService transactionService;

    @Mock
    UserRepository userRepository;

    @Mock
    TransactionRepository transactionRepository;

    @Mock
    AuthorizationService authorizationService;

    private Transaction transcation;



    @BeforeEach
    public void setUp(){
        User payee = new User(1L,new BigDecimal(10),"joao" , "13295r1madf","joao@gmail.com" ,"444" , UserType.COMMON);
        User payer = new User(2L,new BigDecimal(30),"luiz" , "13295r1m55adf","luiz@gmail.com" ,"444" , UserType.MERCHANT);
        transcation = new Transaction(payer, payee , new BigDecimal(40), LocalDateTime.now());
    }

    @Test
    public void createTransactionIsSuccesseful(){

    }



}
