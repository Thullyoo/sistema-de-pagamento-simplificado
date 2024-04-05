package br.thullyo.sistemadepagamentosimplificado.service;

import br.thullyo.sistemadepagamentosimplificado.DTO.UserDTO;
import br.thullyo.sistemadepagamentosimplificado.DTO.UserType;
import br.thullyo.sistemadepagamentosimplificado.domain.User;
import br.thullyo.sistemadepagamentosimplificado.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    @Autowired
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    private User user;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        user = new User(1L, new BigDecimal(10), "joao", "13295r1madf", "joao@gmail.com", "senha", UserType.COMMON);
    }


    @Test
    public void UserCreateIsSuccessful(){

        UserDTO userDto = new UserDTO("joao","senha" , "13295r1madf", UserType.COMMON,"joao@gmail.com" ,new BigDecimal(10));
        User newUser = this.userService.createUser(userDto);
        Assertions.assertNotNull(newUser);
        Assertions.assertEquals(newUser.getName(), user.getName());
        Assertions.assertEquals(newUser.getPassword(), user.getPassword());
        Assertions.assertEquals(newUser.getDocument(), user.getDocument());
        Assertions.assertEquals(newUser.getType(), user.getType());
        Assertions.assertEquals(newUser.getEmail(), user.getEmail());
        Assertions.assertEquals(newUser.getBalance(), user.getBalance());
        newUser.setId(1L);
        Assertions.assertEquals(1L, newUser.getId());
    }

    @Test
    public void UserCreateIsFailed(){


        UserDTO userDto = new UserDTO("joao","senha" ,"ff22", UserType.COMMON,"joao@gmail.com" ,new BigDecimal(10));
        UserDTO userDtoWithSameDocument = new UserDTO("luiz","senha" ,"ff22", UserType.COMMON,"luiz@gmail.com" ,new BigDecimal(10));

        User newUser = this.userService.createUser(userDto);
        User userWithDocumentRepeated = this.userService.createUser(userDtoWithSameDocument);



        Assertions.assertNull(userWithDocumentRepeated);

    }

}
