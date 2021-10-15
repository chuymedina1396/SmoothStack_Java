//Package
package com.ss.utopia_spring.entities;

//JPA libraries
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origin_id", referencedColumnName = "iata_id")
	private Airport originAirport;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_id", referencedColumnName = "iata_id") //I think this is right
	private Airport destAirport;


    public Route() {
    }

    public Route(Integer id, Airport originAirport, Airport destAirport) {
        this.id = id;
        this.originAirport = originAirport;
        this.destAirport = destAirport;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Route id(Integer id) {
        setId(id);
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Route)) {
            return false;
        }
        Route route = (Route) o;
        return Objects.equals(id, route.id) && Objects.equals(originAirport, route.originAirport) && Objects.equals(destAirport, route.destAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originAirport, destAirport);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", originAirport='" + getOriginAirport() + "'" +
            ", destAirport='" + getDestAirport() + "'" +
            "}";
    }


	

}

