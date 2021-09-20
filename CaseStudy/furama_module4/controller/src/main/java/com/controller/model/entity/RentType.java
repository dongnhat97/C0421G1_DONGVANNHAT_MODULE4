package com.controller.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    private String rentTypeName;
    private double reTypeCost;
    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    private List<Service> services;

    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName, double reTypeCost, List<Service> services) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.reTypeCost = reTypeCost;
        this.services = services;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getReTypeCost() {
        return reTypeCost;
    }

    public void setReTypeCost(double reTypeCost) {
        this.reTypeCost = reTypeCost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
