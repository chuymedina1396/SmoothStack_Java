package com.ss.utopia_spring.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.utopia_spring.entities.Airport;

@Repository
public interface AirportDAO extends JpaRepository<Airport, String> {

}
