package com.hotel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class HotelReservationService {
    List<Hotel> hotelList = new ArrayList<>();
    //Adds hotels details to the hotel list
    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }
    //Returns list of hotels
    public List<Hotel> getHotels() {
        return hotelList;
    }
    //Counts number of weekdays in the given range.
    public int countWeekDays(String firstDate,String lastDate) {
        LocalDate startDate = LocalDate.parse(firstDate);
        LocalDate endDate = LocalDate.parse(lastDate);
        DayOfWeek startW = startDate.getDayOfWeek();
        DayOfWeek endW = endDate.getDayOfWeek();
        int days = (int) ChronoUnit.DAYS.between(startDate,endDate);
        int totalWeekDays = days - 2 * ((days + startW.getValue())/7);
        totalWeekDays += (startW == DayOfWeek.SUNDAY ? 1 : 0) + (endW == DayOfWeek.SUNDAY ? 1 : 0);
        return totalWeekDays;
    }
    //Counts the number of weekends in the given range.
    public int countWeekEnds(String firstDate, String lastDate) {
        LocalDate startDate = LocalDate.parse(firstDate);
        LocalDate endDate = LocalDate.parse(lastDate);
        int weekDaysCount = countWeekDays(firstDate,lastDate);
        int days = (int) ChronoUnit.DAYS.between(startDate,endDate);
        return days - weekDaysCount;
    }
    //To calculate the total rates for reward customers on a given date range.
    public void calculateRewardCustomerRate(String firstDate, String lastDate) {
        int weekDaysCount = countWeekDays(firstDate, lastDate);
        int weekEndsCount = countWeekEnds(firstDate, lastDate);
        hotelList.stream().map(p -> {p.setRateForRewardCustomer(weekDaysCount,weekEndsCount); return p.getTotalRewardCustomerRate(); }).collect(Collectors.toList());
    }
    //Returns list of Hotels which has the least rates for a given range of Dates with the best ratings for reward customers.
    public Hotel findCheapestAndBestHotelForRewardCustomer(String firstDate, String lastDate) {
        calculateRewardCustomerRate(firstDate,lastDate);
        Hotel cheapestHotel =  hotelList.stream().min(Comparator.comparing(Hotel::getTotalRewardCustomerRate)).orElseThrow(NoSuchElementException::new);
        int cheapestRate = cheapestHotel.getTotalRewardCustomerRate();
        Predicate<Hotel> minimum = elements -> elements.getTotalRewardCustomerRate()==cheapestRate;
        List<Hotel> minimumRateHotelList = hotelList.stream().filter(minimum).collect(Collectors.toList());
        Hotel maxRatingList = minimumRateHotelList.stream().max(Comparator.comparing(Hotel::getRatings)).orElseThrow(NoSuchElementException::new);
        System.out.println(maxRatingList);
        return maxRatingList;
    }
    //To calculate the total rates for regular customers on a given date range.
    public void calculateRegularCustomerRate(String firstDate, String lastDate) {
        int weekDaysCount = countWeekDays(firstDate, lastDate);
        int weekEndsCount = countWeekEnds(firstDate, lastDate);
        hotelList.stream().map(p -> {p.setRateForRegularCustomer(weekDaysCount,weekEndsCount); return p.getTotalRegularCustomerRate(); }).collect(Collectors.toList());
    }
    //Returns list of Hotels which has the least rates for a given range of Dates with the best ratings for regular customers.
    public Hotel findCheapestAndBestHotelForRegularCustomer(String firstDate, String lastDate) {
        calculateRegularCustomerRate(firstDate,lastDate);
        Hotel cheapestHotel =  hotelList.stream().min(Comparator.comparing(Hotel::getTotalRegularCustomerRate)).orElseThrow(NoSuchElementException::new);
        int cheapestRate = cheapestHotel.getTotalRegularCustomerRate();
        Predicate<Hotel> minimum = elements -> elements.getTotalRegularCustomerRate()==cheapestRate;
        List<Hotel> minimumRateHotelList = hotelList.stream().filter(minimum).collect(Collectors.toList());
        Hotel maxRatingList = minimumRateHotelList.stream().max(Comparator.comparing(Hotel::getRatings)).orElseThrow(NoSuchElementException::new);
        System.out.println(maxRatingList);
        return maxRatingList;
    }
}