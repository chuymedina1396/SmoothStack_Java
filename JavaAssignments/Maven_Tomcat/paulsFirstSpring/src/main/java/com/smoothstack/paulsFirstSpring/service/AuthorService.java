package com.smoothstack.paulsFirstSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.paulsFirstSpring.dao.AuthorDao;
import com.smoothstack.paulsFirstSpring.model.Author;

@Service // Service layer handle the transations
public class AuthorService {

	@Autowired
	private AuthorDao authorDao;

	public Author getAuthorById(int authorId) {
		return authorDao.getAuthorById(authorId);
	}
	
	public void addAuthor(Author author) {
		authorDao.addAuthor(author);
	}

}
