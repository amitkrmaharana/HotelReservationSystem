package com.hotel;

import java.util.HashMap;
import java.util.Scanner;

public class HotelReservation {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String,Integer> hotelData = new HashMap<>();
    static HotelReservation hotelReservation = new HotelReservation();
    public void sethotelNameAndRate() {
        System.out.println("Enter the name of the hotel");
        String name = sc.next();
        System.out.println("Enter the rate of the hotel");
        int rate = sc.nextInt();
        hotelData.put(name,rate);
    }
    public void manageRecords() {
        boolean check = true;
        while(check) {
            System.out.println("Enter the corresponding number according to your requirement\n" +
                    "1. ADD HOTEL\n2. EXIT");
            switch (sc.nextInt()) {
                case 1:
                    hotelReservation.sethotelNameAndRate();
                    System.out.println(hotelData);
                    break;
                case 2:
                    check = false;
                    break;
                default:
                    System.out.println("Invalid Input.Try Again!!");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Resrvation System");
        hotelReservation.manageRecords();
    }
}
