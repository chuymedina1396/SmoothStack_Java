package com.ss.utopia_spring.controllers;

import com.ss.utopia_spring.entities.Flight;
import com.ss.utopia_spring.services.FlightService;
import com.ss.utopia_spring.services.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// Rest controller is going to be one of the objects we will manage
@RestController
public class FlightController {

    // Autowired means give me the class so i can work with it.
    @Autowired 
    FlightService flightService;

    @RequestMapping(path= "/flights", method= RequestMethod.GET)
    public List<Flight> getFlights(){
        return flightService.getFlights();
    }

    // @RequestMapping(path= "/airports/airport/", method= RequestMethod.POST)
    // public ResponseEntity<Object> addAirport(@RequestBody Airport airport){
    //     airportService.addAirport(airport);
    //     return new ResponseEntity<Object>(HttpStatus.CREATED);
    // }

}
