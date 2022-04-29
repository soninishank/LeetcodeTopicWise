package LLD.Decorator;

public class MainCabinSeat implements FlightSeat {
    @Override
    public String getFacilities() {
        return "Free food";
    }

    @Override
    public Double getCost() {
        return 1.0;
    }
}
