package br.thullyo.sistemadepagamentosimplificado.controller;


import br.thullyo.sistemadepagamentosimplificado.DTO.TransactionResult;
import br.thullyo.sistemadepagamentosimplificado.DTO.TransactionDTO;
import br.thullyo.sistemadepagamentosimplificado.domain.Transaction;
import br.thullyo.sistemadepagamentosimplificado.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transactions",  produces = {"application/json"})
@Tag(name = "Transaction Controller")
public class TransactionController {

    @Autowired
    TransactionService service;
    @Operation(summary = "Realiza a criação de transação", method = "POST")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Transação concluída com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao concluir transação")
    })
    @PostMapping
    public ResponseEntity createTransaction(@RequestBody TransactionDTO dto) throws Exception {
        TransactionResult newTransaction = service.createTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
    }
    @Operation(summary = "Busca todas as transações", method = "GET")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Transações buscadas com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar transações")
    })
    @GetMapping
    public ResponseEntity getAllTransactions(){
        List<Transaction> list = service.getAllTransactions();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
