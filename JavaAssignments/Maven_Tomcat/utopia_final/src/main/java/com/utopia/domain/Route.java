package com.ss.uto.domain;

public class Route {

	private Integer routeId;
	private Airport originAirport;
	private Airport destAirport;

//	private List<Flight> flights;
	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Airport getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}

	public Airport getDestAirport() {
		return destAirport;
	}

	public void setDestAirport(Airport destAirport) {
		this.destAirport = destAirport;
	}

}
