package com.controller.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String codeCustomer;
    private String customerName;
    private String customerBirthday;
    private int customerGender;
    private String customerCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customerType_id", referencedColumnName = "customerTypeId")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Contract> contract;
    public Customer() {
    }

    public Customer(Integer customerId, String codeCustomer, String customerName, String customerBirthday, int customerGender, String customerCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerType, List<Contract> contract) {
        this.customerId = customerId;
        this.codeCustomer = codeCustomer;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerCard = customerCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
        this.contract = contract;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerCard() {
        return customerCard;
    }

    public void setCustomerCard(String customerCard) {
        this.customerCard = customerCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }
}
