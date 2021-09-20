package com.controller.dto;

import com.controller.model.entity.RentType;
import com.controller.model.entity.ServiceType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


public class ServiceDto {
    private Integer serviceId;
    @Pattern(regexp = "^DV-\\d{4}$",message = "Mã Dịch vụ có định dạng là DV-XXXX (X là số 0-9)")
    private String codeService;
    private String serviceName;
    private int area;
    // pattern anotation chỉ dùng được cho string 
    @Min(value = 0,message = "giá tiền phải là số nguyên dương")
    private double cost;
    @Min(value = 1,message = "ít nhất 1 nguòi")
    @Max(value = 20,message ="không quá 20 người" )
    private int maxPeople;
    private String standardRoom;
    private String description;
    private double poolArea;
    @Min(value = 1 )
    @Max(value = 20,message ="số tầng từ 1 đến 20" )
    private int numberFloors;
    private RentType rentType;
    private ServiceType serviceType;

    public ServiceDto() {
    }

    public ServiceDto(Integer serviceId, String codeService, String serviceName, int area, double cost, int maxPeople, String standardRoom, String description, double poolArea, int numberFloors, RentType rentType, ServiceType serviceType) {
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
