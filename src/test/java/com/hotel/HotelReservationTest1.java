package com.hotel;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest1 {
    @Test
    //Checks for cheapest hotel with max rating.
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
}
