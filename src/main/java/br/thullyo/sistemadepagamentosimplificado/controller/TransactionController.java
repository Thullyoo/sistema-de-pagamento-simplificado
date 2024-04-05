package br.thullyo.sistemadepagamentosimplificado.controller;


import br.thullyo.sistemadepagamentosimplificado.DTO.TransactionResult;
import br.thullyo.sistemadepagamentosimplificado.DTO.TransactionDTO;
import br.thullyo.sistemadepagamentosimplificado.domain.Transaction;
import br.thullyo.sistemadepagamentosimplificado.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService service;

    @PostMapping
    public ResponseEntity createTransaction(@RequestBody TransactionDTO dto) throws Exception {
        TransactionResult newTransaction = service.createTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
    }

    @GetMapping
    public ResponseEntity getAllTransactions(){
        List<Transaction> list = service.getAllTransactions();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
