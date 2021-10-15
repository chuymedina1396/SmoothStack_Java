package com.ss.utopia_spring.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.utopia_spring.entities.Route;

@Repository
public interface RouteDAO extends JpaRepository<Route, Integer>{
    
}
