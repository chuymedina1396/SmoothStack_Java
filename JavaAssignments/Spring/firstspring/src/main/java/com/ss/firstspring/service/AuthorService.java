package com.ss.firstspring.service;

import com.ss.firstspring.dao.AuthorDAO;
import com.ss.firstspring.models.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;

// Service is a child class of Component so which ever should work
@Component
public class AuthorService {
    @Autowired
    AuthorDAO authorDAO;

    public Author getAuthorById(int authorId){
        return authorDAO.getAuthorById(authorId);
    }
    public Author addAuthor(Author author){
        return authorDAO.addAuthor(author);
    }
}
