package com.model.bean;

import java.util.Date;

public class People {
    private String name;
    private Date birthday;
    private int gender;
    private String country;
    private String idCar;
    private String transport;
    private String idTransport;
    private Date star;
    private Date end;
    private String visitCity;
    private String address;
    private String phone;
    private String[] symptom;
    private String exposureHistory;

    public People() {
    }

    public People(String name, Date birthday, int gender, String country, String idCar, String transport, String idTransport, Date star, Date end, String visitCity, String address, String phone, String[] symptom, String exposureHistory) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.country = country;
        this.idCar = idCar;
        this.transport = transport;
        this.idTransport = idTransport;
        this.star = star;
        this.end = end;
        this.visitCity = visitCity;
        this.address = address;
        this.phone = phone;
        this.symptom = symptom;
        this.exposureHistory = exposureHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(String idTransport) {
        this.idTransport = idTransport;
    }

    public Date getStar() {
        return star;
    }

    public void setStar(Date star) {
        this.star = star;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getVisitCity() {
        return visitCity;
    }

    public void setVisitCity(String visitCity) {
        this.visitCity = visitCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getSymptom() {
        return symptom;
    }

    public void setSymptom(String[] symptom) {
        this.symptom = symptom;
    }

    public String getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(String exposureHistory) {
        this.exposureHistory = exposureHistory;
    }
}
