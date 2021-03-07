package com.hotel;

public class Hotel {
    protected String name;
    protected int totalRate;
    protected int regularCustomerWeekDayRate;
    protected int regularCustomerWeekEndRate;
    protected int rewardCustomerWeekDayRate;
    protected int rewardCustimerWeekEndRate;
    protected int ratings;
    //
    public Hotel(String name, int regularCustomerWeekDayRate, int regularCustomerWeekEndRate, int rewardCustomerWeekDayRate, int rewardCustimerWeekEndRate, int ratings) {
        this.name = name;
        this.regularCustomerWeekDayRate = regularCustomerWeekDayRate;
        this.regularCustomerWeekEndRate = regularCustomerWeekEndRate;
        this.rewardCustomerWeekDayRate = rewardCustomerWeekDayRate;
        this.rewardCustimerWeekEndRate = rewardCustimerWeekEndRate;
        this.ratings = ratings;
    }

    public String toString() {
        return "Hotel: " + name + "  RegularCustomerWeekDayRate: " + regularCustomerWeekDayRate + " RegularCustomerWeekEndRate: " + regularCustomerWeekEndRate + " RewardCustomerWeekDayRate: " + rewardCustomerWeekDayRate + " RewardCustomerWeekEndRate: " + rewardCustimerWeekEndRate;
    }
    //This provides the sum of total rate for the regular customer in the given range
    public void setRateForRegularCustomer(int weekDayCount,int weekEndRate){
        this.regularCustomerWeekDayRate = this.regularCustomerWeekDayRate*weekDayCount;
        this.regularCustomerWeekEndRate = this.regularCustomerWeekEndRate*weekEndRate;
        this.totalRate = this.regularCustomerWeekDayRate + this.regularCustomerWeekEndRate;
    }
    //Returns the sum of Total weekDayrate and total weekDayrate to the comparator to compare.

    public int getRatings() {
        return ratings;
    }

    public int getTotalRate() {
        return this.totalRate;
    }
}
