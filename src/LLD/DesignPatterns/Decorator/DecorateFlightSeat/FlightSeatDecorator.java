package LLD.DesignPatterns.Decorator.DecorateFlightSeat;

import LLD.DesignPatterns.Decorator.FlightSeat;

public abstract class FlightSeatDecorator implements FlightSeat {
    protected FlightSeat flightSeat;

    public FlightSeatDecorator(FlightSeat flightSeat) {
        this.flightSeat = flightSeat;
    }

    public abstract String getFacilities();

    public abstract Double getCost();
}
