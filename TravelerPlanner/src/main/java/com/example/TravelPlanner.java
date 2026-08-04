package com.example;

public class TravelPlanner {

    private HotelBooking hotelBooking;
    private TravelStrategyFactory factory;

    public TravelPlanner() {
        this.factory = new TravelStrategyFactory();
    }

    public void bookHotel(final HotelBooking hotelBooking) {
        this.hotelBooking = hotelBooking;
    }

    public String planTrip(final String travelMethod, final String from, final String to){
        final TravelStrategy strategy = factory.getTravelStrategy(travelMethod);

        final String travel = strategy.travelPlan(from, to);
        final String hotel = hotelBooking != null ? hotelBooking.toString() : "Отель не забронирован !";

        return travel + "\n" + hotel;
    }


}
