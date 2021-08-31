package com.smoothstack.paulsFirstSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.paulsFirstSpring.model.Author;
import com.smoothstack.paulsFirstSpring.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@RequestMapping(path = "/lms/authors/{authorId}", method=RequestMethod.GET)
	public Author getAuthorById(@PathVariable int authorId) {
		
		return authorService.getAuthorById(authorId);
	}
	@RequestMapping(path = "/lms/author" , method = RequestMethod.POST)
	public void addAuthor(@RequestBody Author author) {
		System.out.println(author);
		authorService.addAuthor(author);
	}
}
