package com.example;

public class TrainStrategy implements TravelStrategy {
    @Override
    public String travelPlan(String from, String to) {
        return String.format("Поездка поездом из %s в %s", from, to);
    }
}
