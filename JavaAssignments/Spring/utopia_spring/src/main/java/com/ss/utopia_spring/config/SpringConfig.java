package com.ss.utopia_spring.config;

//Services needed
import com.ss.utopia_spring.service.AirportService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



//Usually used for preparing context
@Configuration 
public class SpringConfig {
    @Bean
    public AirportService getAirportService(){
        return new AirportService();
    }
    
}