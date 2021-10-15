//Package
package com.ss.utopia_spring.entities;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//JPA libraries
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Utilities 
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "airplane_type")
public class AirplaneType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer maxCapacity;
    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "type_id", referencedColumnName = "id")
    // List<Airplane> airplanes;



    public AirplaneType() {
    }

    public AirplaneType(Integer id, Integer maxCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public AirplaneType id(Integer id) {
        setId(id);
        return this;
    }

    public AirplaneType maxCapacity(Integer maxCapacity) {
        setMaxCapacity(maxCapacity);
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
        return Objects.equals(id, airplaneType.id) && Objects.equals(maxCapacity, airplaneType.maxCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxCapacity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", maxCapacity='" + getMaxCapacity() + "'" +
            "}";
    }
    
    
}