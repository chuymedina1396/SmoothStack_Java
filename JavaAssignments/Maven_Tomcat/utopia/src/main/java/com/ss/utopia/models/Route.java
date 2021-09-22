//Package
package com.ss.utopia.models;

//Utilities 
import java.util.List;
import java.util.Objects;

public class Route {

	private Integer routeId;
	private Airport originAirport;
	private Airport destAirport;

    private List<Flight> flights;

    public Route() {
    }

    public Route(Integer routeId, Airport originAirport, Airport destAirport, List<Flight> flights) {
        this.routeId = routeId;
        this.originAirport = originAirport;
        this.destAirport = destAirport;
        this.flights = flights;
    }

    public Integer getRouteId() {
        return this.routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Airport getOriginAirport() {
        return this.originAirport;
    }

    public void setOriginAirport(Airport originAirport) {
        this.originAirport = originAirport;
    }

    public Airport getDestAirport() {
        return this.destAirport;
    }

    public void setDestAirport(Airport destAirport) {
        this.destAirport = destAirport;
    }

    public List<Flight> getFlights() {
        return this.flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Route routeId(Integer routeId) {
        setRouteId(routeId);
        return this;
    }

    public Route originAirport(Airport originAirport) {
        setOriginAirport(originAirport);
        return this;
    }

    public Route destAirport(Airport destAirport) {
        setDestAirport(destAirport);
        return this;
    }

    public Route flights(List<Flight> flights) {
        setFlights(flights);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Route)) {
            return false;
        }
        Route route = (Route) o;
        return Objects.equals(routeId, route.routeId) && Objects.equals(originAirport, route.originAirport) && Objects.equals(destAirport, route.destAirport) && Objects.equals(flights, route.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, originAirport, destAirport, flights);
    }

    @Override
    public String toString() {
        return "{" +
            " routeId='" + getRouteId() + "'" +
            ", originAirport='" + getOriginAirport() + "'" +
            ", destAirport='" + getDestAirport() + "'" +
            ", flights='" + getFlights() + "'" +
            "}";
    }
	

}
