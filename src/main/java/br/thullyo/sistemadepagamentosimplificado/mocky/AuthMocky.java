package br.thullyo.sistemadepagamentosimplificado.mocky;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class AuthMocky {

    public boolean auth(){
        Random randomizer = new Random();
        Boolean authorize = randomizer.nextBoolean();
        return authorize;
    }

}
