package com.example;

public class AirplaneStrategy implements TravelStrategy {

    @Override
    public String travelPlan(String from, String to) {
        return String.format("Поездка самолётом из %s в %s", from, to);
    }
}
