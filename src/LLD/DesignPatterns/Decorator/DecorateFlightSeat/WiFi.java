package LLD.DesignPatterns.Decorator.DecorateFlightSeat;

import LLD.DesignPatterns.Decorator.FlightSeat;

public class WiFi extends FlightSeatDecorator {

    public WiFi(FlightSeat flightSeat) {
        super(flightSeat);
    }

    @Override
    public String getFacilities() {
        return this.flightSeat.getFacilities() + "\nwifi is available";
    }

    @Override
    public Double getCost() {
        return this.flightSeat.getCost() + 10.0;
    }
}
