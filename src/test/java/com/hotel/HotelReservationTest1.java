package com.hotel;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest1 {
    @Test
    //Adds Hotels
    public void givenHotels_whenInvokeAddHotels_shoulBeAbleToAdd() {
        HotelReservationService hotelReservationService = new HotelReservationService();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 110, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 100, 40, 5);
        hotelReservationService.addHotel(lakewood);
        hotelReservationService.addHotel(bridgewood);
        hotelReservationService.addHotel(ridgewood);
        Assert.assertTrue(hotelReservationService.hotelList.contains(lakewood));
    }
    @Test
    //Checks for cheapest hotels with the best ratings for reward customer
    public void given3Hotel_whenInvokeFindCheapestAndBestHotels_forRewardCustomer_shoulBeAbleToGiveCheapestHoTelWithBestRatings() {
        HotelReservationService hotelReservationService = new HotelReservationService();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 110, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 100, 40, 5);
        hotelReservationService.addHotel(lakewood);
        hotelReservationService.addHotel(bridgewood);
        hotelReservationService.addHotel(ridgewood);
        Hotel maxRatingList = hotelReservationService.findCheapestAndBestHotelForRewardCustomer("2020-09-11","2020-09-13");
        Assert.assertTrue(hotelReservationService.hotelList.contains(maxRatingList));
    }
    @Test
    //Checks for cheapest hotels with the best ratings for regular customer
    public void given3Hotel_whenInvokeFindCheapestAndBestHotels_forRegularCustomer_shoulBeAbleToGiveCheapestHoTelWithBestRatings() {
        HotelReservationService hotelReservationService = new HotelReservationService();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 110, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 100, 40, 5);
        hotelReservationService.addHotel(lakewood);
        hotelReservationService.addHotel(bridgewood);
        hotelReservationService.addHotel(ridgewood);
        Hotel maxRatingList = hotelReservationService.findCheapestAndBestHotelForRegularCustomer("2020-09-11","2020-09-13");
        Assert.assertTrue(hotelReservationService.hotelList.contains(maxRatingList));
    }
}