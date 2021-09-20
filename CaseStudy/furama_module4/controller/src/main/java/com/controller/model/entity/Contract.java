package com.controller.model.entity;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;
    private String contractStart;
    private String contractEnd;
    private double deposit;
    private double totalMany;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    private Customer customer;
    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id",referencedColumnName = "serviceId")
    private Service service;

    public Contract() {
    }

    public Contract(Integer contractId, String contractStart, String contractEnd, double deposit, double totalMany, Employee employee, Customer customer, Service service) {
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
