package com.example.spring_rest.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig {
    @Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig resourceConfig=new ResourceConfig();
        resourceConfig.register(BanqueRestJaxRSService.class);
        return resourceConfig;
    }
}
