package com.ss.utopia_spring.services;

import com.ss.utopia_spring.daos.AirportDAO;
import com.ss.utopia_spring.daos.RouteDAO;
import com.ss.utopia_spring.daos.FlightDAO;
import com.ss.utopia_spring.entities.Flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;

// Service is a child class of Component so which ever should work
@Component
public class FlightService {
    @Autowired
    FlightDAO flightDAO;

    // GETS LIST OF ALL ROUTES AND THEIR CORRESPONDING ORIGIN AND DEST AIRPORTS
    public List<Flight> getFlights(){
        return flightDAO.findAll();
    }
}
