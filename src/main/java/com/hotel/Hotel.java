package com.hotel;

public class Hotel {
    protected String name;
    protected int rate;
    protected int weekDayRate;
    protected int weekEndRate;

    public Hotel(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public Hotel(String name, int weekDayRate, int weekEndRate) {
        this.name = name;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
    }

    public String toString() {
        return "Hotel: " + name + "  WeekDayRate: " + weekDayRate + " WeekEndRate " + weekEndRate;
    }

//    public String toString() {
//        return "Hotel: " + name + "  Rate: " + rate;
//    }

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
