package com.example.currency_converter.models;

public class ConversionCurrency {

    private double value;
    private String to;
    private String from;

    public ConversionCurrency() {
    }

    public ConversionCurrency( double value,String from, String to) {
        this.value = value;
        this.to = to;
        this.from = from;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}

