package com.ss.firstspring.dao;

import com.ss.firstspring.models.Author;

import org.springframework.stereotype.Component;


@Component
public class AuthorDAO {
    public Author getAuthorById(int authorId){
        Author author = new Author();
        author.setAuthorId(authorId);
        author.setName("author name __" + authorId);
        return author;
    }

    public Author addAuthor(Author author){
        Author newAuthor = new Author();
        author.setAuthorId(newAuthor.getAuthorId());
        author.setName("author name __" + newAuthor.getName());
        return author;
    }

}
