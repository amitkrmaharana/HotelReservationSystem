package com.hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelReservationService {
    private List<Hotel> hotelList = new ArrayList<>();
    int result;

    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    public List<Hotel> getHotels() {
        return hotelList;
    }



}
