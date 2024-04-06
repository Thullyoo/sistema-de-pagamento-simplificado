package br.thullyo.sistemadepagamentosimplificado.service;

import br.thullyo.sistemadepagamentosimplificado.DTO.TransactionDTO;
import br.thullyo.sistemadepagamentosimplificado.DTO.TransactionResult;
import br.thullyo.sistemadepagamentosimplificado.DTO.UserType;
import br.thullyo.sistemadepagamentosimplificado.domain.Transaction;
import br.thullyo.sistemadepagamentosimplificado.domain.User;
import br.thullyo.sistemadepagamentosimplificado.mocky.AuthMocky;
import br.thullyo.sistemadepagamentosimplificado.repository.TransactionRepository;
import br.thullyo.sistemadepagamentosimplificado.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;

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

    @Mock
    AuthMocky authMocky;

    private Transaction transaction;

    private User payer;
    private User payee;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        payer = new User(1L,new BigDecimal(10),"joao" , "13295r1madf","joao@gmail.com" ,"444" , UserType.COMMON);
        payee = new User(2L,new BigDecimal(30),"luiz" , "13295r1m55adf","luiz@gmail.com" ,"444" , UserType.MERCHANT);
        transaction = new Transaction(payer, payee , new BigDecimal(40), LocalDateTime.of(2022, 4, 5, 0, 0));
    }

    @Test
    public void createTransactionIsSuccesseful() throws Exception {

        TransactionDTO dto = new TransactionDTO(2L, 1L, new BigDecimal(40) );

        when(this.userRepository.findById(1L)).thenReturn(Optional.of(payer));
        when(this.userRepository.findById(2L)).thenReturn(Optional.of(payee));

        when(this.authorizationService.authorization(payee, payer, dto.amount())).thenReturn(true);
        when(this.authMocky.auth()).thenReturn(true);

        when(this.userRepository.save(payee)).thenReturn(payee);
        when(this.userRepository.save(payer)).thenReturn(payee);
        when(this.transactionRepository.save(transaction)).thenReturn(transaction);

        TransactionResult newTransaction = this.transactionService.createTransaction(dto);
        newTransaction.getTransaction().setTime_transaction(LocalDateTime.of(2022, 4, 5, 0, 0));
        Assertions.assertNotNull(newTransaction.getTransaction());
        Assertions.assertEquals(newTransaction.getTransaction().getAmount(), transaction.getAmount());
        Assertions.assertEquals(newTransaction.getTransaction().getPayee(), transaction.getPayee());
        Assertions.assertEquals(newTransaction.getTransaction().getPayer(), transaction.getPayer());
        Assertions.assertEquals(newTransaction.getTransaction().getTime_transaction(), transaction.getTime_transaction());

    }
    @Test
    public void createTransactionIsFail() throws Exception{

        TransactionDTO dto = new TransactionDTO(2L, 5L, new BigDecimal(40) );

        when(this.userRepository.findById(1L)).thenReturn(Optional.of(payer));
        when(this.userRepository.findById(5L)).thenReturn(null);

        when(this.authorizationService.authorization(payee, null, dto.amount())).thenReturn(false);
        when(this.authMocky.auth()).thenReturn(false);

        TransactionResult newTransaction = this.transactionService.createTransaction(dto);

        Assertions.assertNull(newTransaction.getTransaction());

    }


}
