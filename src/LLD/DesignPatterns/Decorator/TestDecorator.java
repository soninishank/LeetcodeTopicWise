package LLD.DesignPatterns.Decorator;

import LLD.DesignPatterns.Decorator.DecorateFlightSeat.LiveTV;
import LLD.DesignPatterns.Decorator.DecorateFlightSeat.WiFi;

public class TestDecorator {
    public static void main(String[] args) {
//        MainCabinSeat mainCabinSeat1 = new MainCabinSeat();
//        FlightSeat liveTV = new LiveTV(mainCabinSeat1);
//        System.out.println(liveTV);
//        FlightSeat headPhone = new HeadPhone(liveTV);
//        System.out.println(headPhone);
//        FlightSeat combination = new WiFi(headPhone);
//        System.out.println(combination);
//
//        System.out.println("Chosen Facilities for your seat:");
//        System.out.println(combination.getFacilities());
//        System.out.println("Total Cost:" + combination.getCost());

        FlightSeat flightSeat = new WiFi(new LiveTV(new MainCabinSeat()));

        System.out.println(flightSeat.getFacilities());
    }
}
