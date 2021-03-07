package com.hotel;

public class Hotel {
    private String name;
    private int rate;

    public Hotel(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }
    public String toString() {
        return "Hotel: " + name + "  Rate: " + rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(int count) {
        this.rate = this.rate*count;
    }

    public int getRate() {
        return rate;
    }

}
