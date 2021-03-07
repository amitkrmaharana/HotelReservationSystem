package com.hotel;

public class Hotel {
    protected String name;
    protected int totalRate;
    protected int weekDayRate;
    protected int weekEndRate;
    protected int ratings;
    // Created constructor to add name , weekday and weekaend rates
    public Hotel(String name, int weekDayRate, int weekEndRate, int ratings) {
        this.name = name;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.ratings = ratings;
    }
    public String toString() {
        return "Hotel: " + name + "  TotalRate: " + totalRate + " Ratings " + ratings;
    }
    //This provides the sum of total rate for the given range
    public void setRate(int weekDayCount,int weekEndRate){
        this.weekDayRate = this.weekDayRate*weekDayCount;
        this.weekEndRate = this.weekEndRate*weekEndRate;
        this.totalRate = this.weekDayRate + this.weekEndRate;
    }
    //Returns the sum of Total weekDayrate and total weekDayrate to the comparator to compare.
    public int getRate() {
        return this.weekDayRate + this.weekEndRate;
    }

    public int getTotalRate() {
        return this.totalRate;
    }
}
