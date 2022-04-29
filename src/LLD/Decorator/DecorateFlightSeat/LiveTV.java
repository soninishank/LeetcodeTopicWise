package LLD.Decorator.DecorateFlightSeat;

import LLD.Decorator.FlightSeat;

public class LiveTV extends FlightSeatDecorator {
    public LiveTV(FlightSeat flightSeat) {
        super(flightSeat);
    }

    @Override
    public String getFacilities() {
        return this.flightSeat.getFacilities() + "\nLive TV";
    }

    @Override
    public Double getCost() {
        return this.flightSeat.getCost() + 5.0;
    }
}
