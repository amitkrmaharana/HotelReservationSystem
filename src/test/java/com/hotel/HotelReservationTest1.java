package com.hotel;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest1 {
    @Test
    //Checks for cheapest hotel with max rating.
    public void givenHotel_with3Parameters_whenInvokeFindCheapestAndBestHotels_shoulBeAbleToGiveCheapestHoTelWithBestRatings() {
        HotelReservationService hotelReservationService = new HotelReservationService();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);
        hotelReservationService.addHotel(lakewood);
        hotelReservationService.addHotel(bridgewood);
        hotelReservationService.addHotel(ridgewood);
        Hotel maxRatingList = hotelReservationService.findCheapestAndBestHotel("2020-09-11","2020-09-13");
        Assert.assertTrue(hotelReservationService.hotelList.contains(maxRatingList));
    }
    @Test
    //Checks for max rated hotel.
    public void given3Hotels_whenInvokeBestRatedHotel_shouldBeAbleToReturnBestRatedHotel() {
        HotelReservationService hotelReservationService = new HotelReservationService();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);
        hotelReservationService.addHotel(lakewood);
        hotelReservationService.addHotel(bridgewood);
        hotelReservationService.addHotel(ridgewood);
        Hotel maxRatedHotelList = hotelReservationService.findmaxRatedHotel("2020-09-11","2020-09-13");
        Assert.assertTrue(hotelReservationService.hotelList.contains(maxRatedHotelList));
    }
}
