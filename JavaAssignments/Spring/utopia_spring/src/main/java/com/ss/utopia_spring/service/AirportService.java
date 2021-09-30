package com.ss.utopia_spring.service;

import com.ss.utopia_spring.daos.AirportDAO;
import com.ss.utopia_spring.models.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;

// Service is a child class of Component so which ever should work
@Component
public class AirportService {
    @Autowired
    AirportDAO airportDAO;

    public List<Airport> getAirportById(Airport airport){
        return airportDAO.readAirportsByAirportCode(airport.getAirportCode());
    }
    // public Airport addAuthor(Airport airport){
    //     return airportDAO.addAuthor(airport);
    // }
}
