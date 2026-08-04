package com.example;

public class HotelBooking {

    private String hotelName;
    private int night;
    private boolean breakfastIncluded;

    static final class Builder {

        private String hotelName;
        private int night;
        private boolean breakfastIncluded;

        Builder(String hotelName){
            this.hotelName = hotelName;
        }

        Builder night(int night){
            this.night = night;
            return this;
        }

        Builder breakfastIncluded(boolean breakfastIncluded){
            this.breakfastIncluded = breakfastIncluded;
            return this;
        }

        HotelBooking build(){
            return new HotelBooking(this);
        }
    }

    private HotelBooking(final Builder builder){
        this.hotelName = builder.hotelName;
        this.night = builder.night;
        this.breakfastIncluded = builder.breakfastIncluded;
    }

    @Override
    public String toString() {
        return String.format("Отель %s  на %s ночей, завтрак: %s ",  hotelName, night, breakfastIncluded ? "включён" : "не включён");
    }
}
