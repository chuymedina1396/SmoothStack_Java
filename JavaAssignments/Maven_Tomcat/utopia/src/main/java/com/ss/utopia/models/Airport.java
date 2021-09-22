package com.ss.utopia.models;
import java.util.List;
import java.util.Objects;


public class Airport {

	private String airportCode;
	private String city;
	private List<Route> routes;


    public Airport() {
    }

    public Airport(String airportCode, String city, List<Route> routes) {
        this.airportCode = airportCode;
        this.city = city;
        this.routes = routes;
    }

    public String getAirportCode() {
        return this.airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Route> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Airport airportCode(String airportCode) {
        setAirportCode(airportCode);
        return this;
    }

    public Airport city(String city) {
        setCity(city);
        return this;
    }

    public Airport routes(List<Route> routes) {
        setRoutes(routes);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Airport)) {
            return false;
        }
        Airport airport = (Airport) o;
        return Objects.equals(airportCode, airport.airportCode) && Objects.equals(city, airport.city) && Objects.equals(routes, airport.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportCode, city, routes);
    }

    @Override
    public String toString() {
        return "{" +
            " airportCode='" + getAirportCode() + "'" +
            ", city='" + getCity() + "'" +
            ", routes='" + getRoutes() + "'" +
            "}";
    }

}
