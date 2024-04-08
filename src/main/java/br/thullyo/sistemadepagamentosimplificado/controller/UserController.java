package br.thullyo.sistemadepagamentosimplificado.controller;

import br.thullyo.sistemadepagamentosimplificado.DTO.UserDTO;
import br.thullyo.sistemadepagamentosimplificado.domain.User;
import br.thullyo.sistemadepagamentosimplificado.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users", produces = {"application/json"})
@Tag(name = "User Controller")
public class UserController {

    @Autowired
    UserService service;

    @Operation(summary = "Criar usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Usuário criado com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Falha ao criar o usuário")
    })
    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDTO dto){
        try {
            User newUser = service.createUser(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Documento duplicado", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar Usuário", e);
        }

    }
    @Operation(summary = "Busca todos os usuários", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de usuários buscada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar usuários")
    })
    @GetMapping
    public ResponseEntity getAllUsers(){
        List<User> list = service.listUsers();
        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @Operation(summary = "Busca o usuário por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar usuário")
    })
    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        Optional<User> user = service.getUserByDocument(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
