package com.example.currency_converter.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Currency {
    @Id
    private String name;
    private double valueInUSD;

    public Currency() {
    }

    public Currency(String name, double valueInUSD) {
        this.name = name;
        this.valueInUSD = valueInUSD;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", valueInUSD=" + valueInUSD +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValueInUSD() {
        return valueInUSD;
    }

    public void setValueInUSD(double valueInUSD) {
        this.valueInUSD = valueInUSD;
    }
}


