package com.ss.firstspring.controller;

import com.ss.firstspring.service.AuthorService;
import com.ss.firstspring.models.Author;

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
public class AuthorController {

    // Autowired means give me the class so i can work with it.
    @Autowired 
    AuthorService authorService;

    @RequestMapping(path= "/lms/authors/{authorId}", method= RequestMethod.GET)
    public Author getAuthorById(@PathVariable int authorId){
        return authorService.getAuthorById(authorId);
    }

    @RequestMapping(path= "/lms/author/", method= RequestMethod.POST)
    public ResponseEntity<String> addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

}
