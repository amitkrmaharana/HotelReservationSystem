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
    //Counts number of week days in the given range.
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
    //Returns list of Hotels which has the least rates for a given range of dates with the best ratings.
    public Hotel findCheapestAndBestHotel(String firstDate, String lastDate) {
        int weekDaysCount = countWeekDays(firstDate, lastDate);
        int weekEndsCount = countWeekEnds(firstDate, lastDate);
        hotelList.stream().map(p -> {p.setRate(weekDaysCount,weekEndsCount); return p.getTotalRate(); }).collect(Collectors.toList());
        Hotel cheapestHotel =  hotelList.stream().min(Comparator.comparing(Hotel::getTotalRate)).orElseThrow(NoSuchElementException::new);
        int cheapestRate = cheapestHotel.getTotalRate();
        Predicate<Hotel> minimum = elements -> elements.getTotalRate()==cheapestRate;
        List<Hotel> minimumRateHotelList = hotelList.stream().filter(minimum).collect(Collectors.toList());
        Hotel maxRatingList = minimumRateHotelList.stream().max(Comparator.comparing(Hotel::getRatings)).orElseThrow(NoSuchElementException::new);
        System.out.println(maxRatingList);
        return maxRatingList;
    }
}
