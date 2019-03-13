package com.stackroute.userservice.config;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.repository.RestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineListenerImpl implements CommandLineRunner {

    private RestaurentRepository restaurentRepository;
    @Autowired
    public CommandLineListenerImpl(RestaurentRepository restaurentRepository) {
        this.restaurentRepository = restaurentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Restaurent restaurent =new Restaurent(2,"dhaba","image","kormangala");
        restaurentRepository.save(restaurent);
    }
}
