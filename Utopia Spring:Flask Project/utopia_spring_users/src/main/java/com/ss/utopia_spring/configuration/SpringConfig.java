package com.ss.utopia_spring.configuration;

import com.ss.utopia_spring.services.AirportService;
import com.ss.utopia_spring.services.RouteService;
import com.ss.utopia_spring.services.FlightService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//Usually used for preparing context
@Configuration 
public class SpringConfig {
    @Bean
    public AirportService getAirportService(){
        return new AirportService();
    }
    @Bean
    public RouteService getRouteService(){
        return new RouteService();
    }
    @Bean
    public FlightService getFlightService(){
        return new FlightService();
    }
    
}