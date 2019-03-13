package com.stackroute.userservice.config;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.repository.RestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImpl implements ApplicationListener
{
    private RestaurentRepository restaurentRepository;

    @Autowired
    public ApplicationRunnerImpl(RestaurentRepository restaurentRepository) {
        this.restaurentRepository = restaurentRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
     Restaurent restaurent =new Restaurent(1,"dhaba","image","kormangala");
   restaurentRepository.save(restaurent);
    }
}
