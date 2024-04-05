package br.thullyo.sistemadepagamentosimplificado.service;

import br.thullyo.sistemadepagamentosimplificado.DTO.TransactionResult;
import br.thullyo.sistemadepagamentosimplificado.domain.Transaction;
import br.thullyo.sistemadepagamentosimplificado.DTO.TransactionDTO;
import br.thullyo.sistemadepagamentosimplificado.domain.User;
import br.thullyo.sistemadepagamentosimplificado.repository.TransactionRepository;
import br.thullyo.sistemadepagamentosimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AuthorizationService authorizationService;

    public TransactionResult createTransaction(TransactionDTO transactioDTO) throws Exception{

        Optional<User> optionalPayee = userRepository.findById(transactioDTO.payeeID());
        Optional<User> optionalPayer = userRepository.findById(transactioDTO.payerID());

        if (optionalPayee.isPresent() && optionalPayer.isPresent()) {
            User payee = optionalPayee.get();
            User payer = optionalPayer.get();

            if (authorizationService.authorization(payee, payer, transactioDTO.amount())) {

                Transaction newTransaction = new Transaction(payer, payee, transactioDTO.amount(), LocalDateTime.now());

                payer.setBalance(payer.getBalance().subtract(transactioDTO.amount()));
                payee.setBalance(payee.getBalance().add(transactioDTO.amount()));

                this.transactionRepository.save(newTransaction);
                this.userRepository.save(payee);
                this.userRepository.save(payer);

                return new TransactionResult(newTransaction, "Created Transaction");

            } else {
                return new TransactionResult(null, "Authorization failed"); // Error message
            }
        } else {
            return new TransactionResult(null, "One or both users not found"); // Error message
        }
    }
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
}