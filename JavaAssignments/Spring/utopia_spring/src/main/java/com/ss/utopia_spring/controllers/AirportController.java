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

import antlr.collections.List;


// Rest controller is going to be one of the objects we will manage
@RestController
public class AirportController {

    // Autowired means give me the class so i can work with it.
    @Autowired 
    AirportService airportService;

    @RequestMapping(path= "/airports/{airportCode}", method= RequestMethod.GET)
    public Airport getAuthorById(@PathVariable int authorId){
        return airportService.getAirportById(authorId);
    }

    @RequestMapping(path= "/lms/author/", method= RequestMethod.POST)
    public ResponseEntity<String> addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

}
