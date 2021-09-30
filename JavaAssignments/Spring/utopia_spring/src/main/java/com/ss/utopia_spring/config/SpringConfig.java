package com.ss.utopia_spring.config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ss.utopia_spring.service.AirportService;
import com.ss.utopia_spring.daos.AirportDAO;


//Usually used for preparing context
@Configuration 
public class SpringConfig {
    @Bean
    public AirportService getAirportService(){
        return new AirportService();
    }
    @Bean
    public AirportDAO getAirportByCode(){
        return new AirportDAO();
    }
}