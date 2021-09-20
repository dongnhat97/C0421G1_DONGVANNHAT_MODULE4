package com.controller.dto;

import com.controller.model.entity.CustomerType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private Integer customerId;
    @NotEmpty(message = "Tên không được để trống")
    private String customerName;
    @Pattern(regexp = "^KH-\\d{4}$",message = "Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9")
    private String codeCustomer;
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",message = "vui lòng chọn theo format DD/MM/YYYY")
    private String customerBirthday;
    private int customerGender;
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "vui lòng nhập đúng chứng minh nhân dân")
    private String customerCard;
    @Pattern(regexp ="^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",message ="Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String customerPhone;
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$",message = "Vui lòng chọn đúng định dạng email")
    private String customerEmail;
    private String customerAddress;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer customerId, String customerName, String codeCustomer, String customerBirthday, int customerGender, String customerCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.codeCustomer = codeCustomer;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerCard = customerCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
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
}
