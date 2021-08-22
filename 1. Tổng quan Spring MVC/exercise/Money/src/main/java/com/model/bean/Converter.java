package com.model.bean;

public class Converter {
    double amount;
    double rate;

    public Converter() {
    }

    public Converter(double amount, double rate) {
        this.amount = amount;
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
