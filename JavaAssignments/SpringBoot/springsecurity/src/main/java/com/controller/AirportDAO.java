package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Bring in Airport DAO
import com.dao.Airport;
// Bring in Airport Model
import com.models.Airport;

@RestController
@RequestMapping("/airports") // for everything that starts with /lms
public class AirportController {

	@Autowired
	private PublisherDao publisherDao;
	
	@GetMapping("/airports") // get request to /lms/publisher
	public List<Airport> getAllPublisher() {
	    return publisherDao.findAll(); // can start using the dao for reading from the data
	}
	
	
	// Create a new Note
	@PostMapping("/airports")
	public Publisher createNote(@Valid @RequestBody Publisher publisher) {
	    return publisherDao.save(publisher); // trasnlated into insert.
	}
}
