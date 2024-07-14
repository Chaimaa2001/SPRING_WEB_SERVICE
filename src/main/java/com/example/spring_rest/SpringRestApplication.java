package com.example.spring_rest;

import com.example.spring_rest.entities.Compte;
import com.example.spring_rest.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class SpringRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args->{
            repositoryRestConfiguration.exposeIdsFor(Compte.class);
            compteRepository.save(new Compte(null,8000,new Date(),"activated"));
            compteRepository.save(new Compte(null,7000,new Date(),"activated"));
            compteRepository.save(new Compte(null,6000,new Date(),"blocked"));
            compteRepository.findAll().forEach(c->{
                System.out.println(c.getSolde());
            });
        };
    }

}
