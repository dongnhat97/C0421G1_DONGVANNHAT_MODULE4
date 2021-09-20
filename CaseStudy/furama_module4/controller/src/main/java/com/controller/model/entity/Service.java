package com.controller.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    private String codeService;
    private String serviceName;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int numberFloors;
    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rentTypeId")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;
    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    private List<Contract> services;

    public Service() {
    }

    public Service(Integer serviceId, String codeService, String serviceName, int area, double cost, int maxPeople, String standardRoom, String description, double poolArea, int numberFloors, RentType rentType, ServiceType serviceType) {
        this.serviceId = serviceId;
        this.codeService = codeService;
        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
