package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Airport;

@Repository // this annotation, you dont need to implement anything.

public interface AirportDAO extends JpaRepository<Airport> {

}
