package com.smoothstack.paulsFirstSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smoothstack.paulsFirstSpring.dao.AuthorDao;

@Configuration
public class SpringConfig {

	//@Bean
	public AuthorDao getAuthorDao() {
		return new AuthorDao();
	}
}
