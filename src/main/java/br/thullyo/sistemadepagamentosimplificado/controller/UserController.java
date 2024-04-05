package br.thullyo.sistemadepagamentosimplificado.controller;

import br.thullyo.sistemadepagamentosimplificado.DTO.UserDTO;
import br.thullyo.sistemadepagamentosimplificado.domain.User;
import br.thullyo.sistemadepagamentosimplificado.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

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

    @GetMapping
    public ResponseEntity getAllUsers(){
        List<User> list = service.listUsers();
        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        Optional<User> user = service.getUserByDocument(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
