//Package
package com.ss.utopia.models;

//Utilities 
import java.util.List;
import java.util.Objects;

public class AirplaneType {
    
    private Integer airplaneTypeId;
    private Integer maxCapacity;

    List<Airplane> airplanes;

    public AirplaneType() {
    }

    public AirplaneType(Integer airplaneTypeId, Integer maxCapacity, List<Airplane> airplanes) {
        this.airplaneTypeId = airplaneTypeId;
        this.maxCapacity = maxCapacity;
        this.airplanes = airplanes;
    }

    public Integer getAirplaneTypeId() {
        return this.airplaneTypeId;
    }

    public void setAirplaneTypeId(Integer airplaneTypeId) {
        this.airplaneTypeId = airplaneTypeId;
    }

    public Integer getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Airplane> getAirplanes() {
        return this.airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public AirplaneType airplaneTypeId(Integer airplaneTypeId) {
        setAirplaneTypeId(airplaneTypeId);
        return this;
    }

    public AirplaneType maxCapacity(Integer maxCapacity) {
        setMaxCapacity(maxCapacity);
        return this;
    }

    public AirplaneType airplanes(List<Airplane> airplanes) {
        setAirplanes(airplanes);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AirplaneType)) {
            return false;
        }
        AirplaneType airplaneType = (AirplaneType) o;
        return Objects.equals(airplaneTypeId, airplaneType.airplaneTypeId) && Objects.equals(maxCapacity, airplaneType.maxCapacity) && Objects.equals(airplanes, airplaneType.airplanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airplaneTypeId, maxCapacity, airplanes);
    }

    @Override
    public String toString() {
        return "{" +
            " airplaneTypeId='" + getAirplaneTypeId() + "'" +
            ", maxCapacity='" + getMaxCapacity() + "'" +
            ", airplanes='" + getAirplanes() + "'" +
            "}";
    }
    


    
}