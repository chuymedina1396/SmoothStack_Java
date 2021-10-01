package com.ss.utopia_spring.controllers;

import com.ss.utopia_spring.service.AirportService;
import com.ss.utopia_spring.models.Airport;

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

    @RequestMapping(path= "/airports", method= RequestMethod.GET)
    public String getAuthorById(){
        String myString = "Hello from api";
        return myString;
    }

}
