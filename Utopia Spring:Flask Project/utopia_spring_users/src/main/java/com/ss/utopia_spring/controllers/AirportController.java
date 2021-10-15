package com.ss.utopia_spring.controllers;

import com.ss.utopia_spring.entities.Airport;
import com.ss.utopia_spring.services.AirportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// Rest controller is going to be one of the objects we will manage
@RestController
public class AirportController {

    // Autowired means give me the class so i can work with it.
    @Autowired 
    AirportService airportService;

    @RequestMapping(path= "/airports/{airportcode}", method= RequestMethod.GET)
    public Airport getAirport(@PathVariable String airportcode){
        return airportService.getAirportByCode(airportcode);
    }

    @RequestMapping(path= "/airports/airport/", method= RequestMethod.POST)
    public ResponseEntity<Object> addAirport(@RequestBody Airport airport){
        airportService.addAirport(airport);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

}
