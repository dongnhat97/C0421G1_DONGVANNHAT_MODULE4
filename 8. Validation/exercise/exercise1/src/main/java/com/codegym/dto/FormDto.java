package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;

public class FormDto implements Validator {
    private Long id;
    @NotEmpty(message = "Trường name không được rỗng")
    @Size(min = 4,max = 45,message = "Tên phải tối thiểu 4 ksi tự và tối đa 45 kí tự")
    private String firstName;
    @NotEmpty(message = "Trường name không được rỗng")
    @Size(min = 4,max = 45,message = "Tên phải tối thiểu 4 ksi tự và tối đa 45 kí tự")
    private String lastName;
    @Pattern(regexp = "^(?=0)\\d{10,11}$",message = "Phone number is not exist")
    private String numberPhone;
    @Min(value = 18,message = "tuổi phải trên 18")
    private int age;

    public FormDto() {
    }

    public FormDto(Long id, String firstName, String lastName, String numberPhone, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
      
    }
}
