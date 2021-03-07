package com.hotel;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class HotelReservationTest1 {
    @Test
    public void givenHotel_whenInvokeAddHotel_shoulBeAbleToAdd() {
        HotelReservationService hotelReservationService = new HotelReservationService();
        Hotel hotel = new Hotel("Lakewood",110);
        hotelReservationService.addHotel(hotel);
        List hotelList = hotelReservationService.getHotels();
        System.out.println(hotelList);
        Assert.assertTrue(hotelList.contains(hotel));
    }
    @Test
    public void given3Hotels_whenInvokeFindCheapestHotel_shouldBeAbleToReturnCheapestHotel() {
        HotelReservationService hotelReservationService = new HotelReservationService();
        Hotel Lakewood = new Hotel("Lakewood",110);
        Hotel Bridgewood = new Hotel("Bridgewood",160);
        Hotel RidgeWood = new Hotel("Ridgewood",220);
        hotelReservationService.addHotel(Lakewood);
        hotelReservationService.addHotel(Bridgewood);
        hotelReservationService.addHotel(RidgeWood);
        int countDays = hotelReservationService.countDays("2020-09-10","2020-09-12");
        System.out.println(countDays);
        Hotel result = hotelReservationService.findCheapestHotel(countDays);
        System.out.println(result);
        Assert.assertTrue(hotelReservationService.hotelList.contains(result));
    }
    @Test
    public void givenHotel_with3Parameters_whenInvokeAddHotel_shoulBeAbleToAdd() {
        HotelReservationService hotelReservationService = new HotelReservationService();
        Hotel hotel = new Hotel("Lakewood", 110, 90);
        hotelReservationService.addHotel(hotel);
        List hotelList = hotelReservationService.getHotels();
        System.out.println(hotelList);
        Assert.assertTrue(hotelList.contains(hotel));
    }
}
