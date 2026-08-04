package com.example;

public class TravelApp {
    public static void main(String[] args) {

        TravelPlanner planner = new TravelPlanner();

        HotelBooking booking = new HotelBooking.Builder("Ritz")
                .night(3)
                .breakfastIncluded(true)
                .build();

        planner.bookHotel(booking);

        String from = "Moscow";
        String to = "Berlin";

        System.out.println(planner.planTrip("train", from, to));
        System.out.println(planner.planTrip("airplane", from, to));
    }
}