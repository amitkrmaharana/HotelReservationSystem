package com.hotel;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class HotelReservationTest1 {
    @Test
    public void givenHotel_with3Parameters_whenInvokeAddHotel_shoulBeAbleToAdd() {
        HotelReservationService hotelReservationService = new HotelReservationService();
        Hotel lakewood = new Hotel("Lakewood", 110, 90);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150);
        hotelReservationService.addHotel(lakewood);
        hotelReservationService.addHotel(bridgewood);
        hotelReservationService.addHotel(ridgewood);
        Hotel cheapestHotels = hotelReservationService.findCheapestHotel("2020-09-11","2020-09-13");
        System.out.println(hotelReservationService.hotelList);
        Assert.assertTrue(hotelReservationService.hotelList.contains(cheapestHotels));
    }
}
