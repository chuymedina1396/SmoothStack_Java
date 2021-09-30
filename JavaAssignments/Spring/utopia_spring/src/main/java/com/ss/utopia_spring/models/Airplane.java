//Package
package com.ss.utopia_spring.models;

//Utilities 
import java.util.List;
import java.util.Objects;

public class Airplane {
    
    private Integer airplaneId;
    private AirplaneType airplaneTypeId;
    private List<Flight> flights; 


    public Airplane() {
    }

    public Airplane(Integer airplaneId, AirplaneType airplaneTypeId, List<Flight> flights) {
        this.airplaneId = airplaneId;
        this.airplaneTypeId = airplaneTypeId;
        this.flights = flights;
    }

    public Integer getAirplaneId() {
        return this.airplaneId;
    }

    public void setAirplaneId(Integer airplaneId) {
        this.airplaneId = airplaneId;
    }

    public AirplaneType getAirplaneTypeId() {
        return this.airplaneTypeId;
    }

    public void setAirplaneTypeId(AirplaneType airplaneTypeId) {
        this.airplaneTypeId = airplaneTypeId;
    }

    public List<Flight> getFlights() {
        return this.flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Airplane airplaneId(Integer airplaneId) {
        setAirplaneId(airplaneId);
        return this;
    }

    public Airplane airplaneTypeId(AirplaneType airplaneTypeId) {
        setAirplaneTypeId(airplaneTypeId);
        return this;
    }

    public Airplane flights(List<Flight> flights) {
        setFlights(flights);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Airplane)) {
            return false;
        }
        Airplane airplane = (Airplane) o;
        return Objects.equals(airplaneId, airplane.airplaneId) && Objects.equals(airplaneTypeId, airplane.airplaneTypeId) && Objects.equals(flights, airplane.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airplaneId, airplaneTypeId, flights);
    }

    @Override
    public String toString() {
        return "{" +
            " airplaneId='" + getAirplaneId() + "'" +
            ", airplaneTypeId='" + getAirplaneTypeId() + "'" +
            ", flights='" + getFlights() + "'" +
            "}";
    }
    
}