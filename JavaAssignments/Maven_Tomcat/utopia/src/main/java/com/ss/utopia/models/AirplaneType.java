//Package
package com.ss.utopia.models;

//Utilities 
import java.util.List;
import java.util.Objects;

public class AirplaneType {
    private Integer airplaneTypeId;
    private Integer max_Capacity;

    List<Airplane> airplanes;


    public AirplaneType() {
    }

    public AirplaneType(Integer airplaneTypeId, Integer max_Capacity, List<Airplane> airplanes) {
        this.airplaneTypeId = airplaneTypeId;
        this.max_Capacity = max_Capacity;
        this.airplanes = airplanes;
    }

    public Integer getAirplaneTypeId() {
        return this.airplaneTypeId;
    }

    public void setAirplaneTypeId(Integer airplaneTypeId) {
        this.airplaneTypeId = airplaneTypeId;
    }

    public Integer getMax_Capacity() {
        return this.max_Capacity;
    }

    public void setMax_Capacity(Integer max_Capacity) {
        this.max_Capacity = max_Capacity;
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

    public AirplaneType max_Capacity(Integer max_Capacity) {
        setMax_Capacity(max_Capacity);
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
        return Objects.equals(airplaneTypeId, airplaneType.airplaneTypeId) && Objects.equals(max_Capacity, airplaneType.max_Capacity) && Objects.equals(airplanes, airplaneType.airplanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airplaneTypeId, max_Capacity, airplanes);
    }

    @Override
    public String toString() {
        return "{" +
            " airplaneTypeId='" + getAirplaneTypeId() + "'" +
            ", max_Capacity='" + getMax_Capacity() + "'" +
            ", airplanes='" + getAirplanes() + "'" +
            "}";
    }


    
}