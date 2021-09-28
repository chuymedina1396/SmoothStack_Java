package com.ss.firstspring.configuration;

import com.ss.firstspring.service.AuthorService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Usually used for preparing a lot
@Configuration 
public class SpringConfig {
    @Bean
    public AuthorService getAuthorService(){
        return new AuthorService();
    }
}