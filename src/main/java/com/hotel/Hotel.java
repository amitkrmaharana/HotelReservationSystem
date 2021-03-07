package com.hotel;

public class Hotel {
    protected String name;
    protected int totalRewardCustomerRate;
    protected int totalRegularCustomerRate;
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
        return "Hotel: " + name + " Rating: " + ratings + " TotalRewardCustomerRate: " + totalRewardCustomerRate;
    }
    //This provides the sum of total rate for the regular customer according to weekdays and weekends
    public void setRateForRegularCustomer(int weekDayCount,int weekEndRate){
        this.regularCustomerWeekDayRate = this.regularCustomerWeekDayRate*weekDayCount;
        this.regularCustomerWeekEndRate = this.regularCustomerWeekEndRate*weekEndRate;
        this.totalRegularCustomerRate = this.regularCustomerWeekDayRate + this.regularCustomerWeekEndRate;
    }
    //This provides the sum of total rate for the rewards customer according to weekdays and weekends
    public void setRateForRewardCustomer(int weekDayCount,int weekEndRate) {
        this.rewardCustomerWeekDayRate = this.rewardCustomerWeekDayRate*weekDayCount;
        this.rewardCustimerWeekEndRate = this.rewardCustimerWeekEndRate*weekEndRate;
        this.totalRewardCustomerRate = this.rewardCustomerWeekDayRate + this.rewardCustimerWeekEndRate;
    }
    //Returns the sum of Total weekDayrate and total weekDayrate to the comparator to compare.

    public int getRatings() {
        return ratings;
    }

    public int getTotalRewardCustomerRate() {
        return totalRewardCustomerRate;
    }

    public int getTotalRegularCustomerRate() {
        return totalRegularCustomerRate;
    }
}