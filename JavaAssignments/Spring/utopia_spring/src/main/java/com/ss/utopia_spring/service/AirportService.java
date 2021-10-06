package com.ss.utopia_spring.service;

import com.ss.utopia_spring.daos.AirportDAO;
import com.ss.utopia_spring.entities.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;

// Service is a child class of Component so which ever should work
@Component
public class AirportService {
    @Autowired
    AirportDAO airportDAO;

    public Airport getAirportByCode(String airportCode){
        return airportDAO.getById(airportCode);
        
    }
    public Airport addAirport(Airport airport){
        return airportDAO.save(airport);
    }
}
