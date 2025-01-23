package Coding.Amazon.LogicAndMaintainable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/discuss/interview-question/368537/amazon-phone-screen-parking-service
class ParkingGarage {
    private int[] bays; // [small, medium, large] bay counts
    private Map<Integer, String> ticketMap; // Maps ticket number to a car type
    private int nextTicket;

    public ParkingGarage(int small, int medium, int large) {
        bays = new int[]{small, medium, large};
        ticketMap = new HashMap<>();
        nextTicket = 1;
    }

    public String processArrival(String carType) {
        int bayIndex = getBayIndex(carType);
        for (int i = bayIndex; i < bays.length; i++) {
            if (bays[i] > 0) {
                bays[i]--;
                ticketMap.put(nextTicket, carType);
                int ticketNo = nextTicket;
                nextTicket++;
                return String.valueOf(ticketNo);
            }
        }
        return "reject";
    }

    public String processDeparture(int ticketNumber) {
        if (!ticketMap.containsKey(ticketNumber)) {
            return "Invalid ticket";
        }
        String carType = ticketMap.remove(ticketNumber);
        int bayIndex = getBayIndex(carType);
        bays[bayIndex]++;
        if (ticketMap.size() == 0) {
            nextTicket = 1;
        }
        return "departed";
    }

    private int getBayIndex(String carType) {
        switch (carType) {
            case "small":
                return 0;
            case "medium":
                return 1;
            case "large":
                return 2;
            default:
                throw new IllegalArgumentException("Invalid car type");
        }
    }

    public static void main(String[] args) {
        ParkingGarage garage = new ParkingGarage(1, 1, 2);

        // Second sequence
        System.out.println("\nSecond Sequence Output:");
        List<String[]> secondSequence = Arrays.asList(
                new String[]{"arrival", "small"},
                new String[]{"arrival", "small"},
                new String[]{"arrival", "medium"},
                new String[]{"arrival", "large"},
                new String[]{"depart", "3"},
                new String[]{"arrival", "medium"}
        );
        for (String[] action : secondSequence) {
            if ("arrival".equals(action[0])) {
                System.out.println(garage.processArrival(action[1]));
            } else if ("depart".equals(action[0])) {
                System.out.println(garage.processDeparture(Integer.parseInt(action[1])));
            }
        }
    }
}
