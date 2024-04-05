package br.thullyo.sistemadepagamentosimplificado.service;


import br.thullyo.sistemadepagamentosimplificado.DTO.UserDTO;
import br.thullyo.sistemadepagamentosimplificado.domain.User;
import br.thullyo.sistemadepagamentosimplificado.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User createUser(UserDTO userDTO){
        User dto = new User(userDTO);
        User newUser = repository.save(dto);
        if (newUser == null){
            return null;
        }
        return dto;
    }

    public List<User> listUsers(){
        return repository.findAll();
    }

    public Optional<User> getUserByDocument(Long id){
        return repository.findById(id);
    }
}
