package LLD.Decorator;

import LLD.Decorator.DecorateFlightSeat.HeadPhone;
import LLD.Decorator.DecorateFlightSeat.LiveTV;
import LLD.Decorator.DecorateFlightSeat.WiFi;

public class TestDecorator {
    public static void main(String[] args) {
        MainCabinSeat mainCabinSeat1 = new MainCabinSeat();
        LiveTV liveTV = new LiveTV(mainCabinSeat1);
        HeadPhone headPhone = new HeadPhone(liveTV);
        FlightSeat combination = new WiFi(headPhone);

        System.out.println("Chosen Facilities for your seat:");
        System.out.println(combination.getFacilities());
        System.out.println("Total Cost:" + combination.getCost());
    }
}
