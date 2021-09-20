package com.controller.dto;

import com.controller.model.entity.Customer;
import com.controller.model.entity.Employee;
import com.controller.model.entity.Service;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


public class ContractDto {
    private Integer contractId;
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",message = "vui lòng chọn theo format DD/MM/YYYY")
    private String contractStart;
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",message = "vui lòng chọn theo format DD/MM/YYYY")
    private String contractEnd;
    @Min(value = 0,message = "Tiền phải là số nguyên dương")
    private double deposit;
    @Min(value = 0,message = "Tiền phải là số nguyên dương")
    private double totalMany;
    private Employee employee;
    private Customer customer;
    private Service service;

    public ContractDto() {
    }

    public ContractDto(Integer contractId, String contractStart, String contractEnd, double deposit, double totalMany, Employee employee, Customer customer, Service service) {
        this.contractId = contractId;
        this.contractStart = contractStart;
        this.contractEnd = contractEnd;
        this.deposit = deposit;
        this.totalMany = totalMany;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStart() {
        return contractStart;
    }

    public void setContractStart(String contractStart) {
        this.contractStart = contractStart;
    }

    public String getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(String contractEnd) {
        this.contractEnd = contractEnd;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMany() {
        return totalMany;
    }

    public void setTotalMany(double totalMany) {
        this.totalMany = totalMany;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
