package com.gcit.training.hibernatejpaapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.training.hibernatejpaapp.dao.PublisherDao;
import com.gcit.training.hibernatejpaapp.entity.Publisher;

@RestController
@RequestMapping("/lms") // for everything that starts with /lms
public class PublisherController {

	@Autowired
	private PublisherDao publisherDao;
	
	@GetMapping("/publisher") // get request to /lms/publisher
	public List<Publisher> getAllPublisher() {
	    return publisherDao.findAll(); // can start using the dao for reading from the data
	}
	
	
	// Create a new Note
	@PostMapping("/publisher")
	public Publisher createNote(@Valid @RequestBody Publisher publisher) {
	    return publisherDao.save(publisher); // trasnlated into insert.
	}
}
