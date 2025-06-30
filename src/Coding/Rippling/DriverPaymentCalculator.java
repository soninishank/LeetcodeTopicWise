package Coding.Rippling;

import java.util.Arrays;
import java.util.List;

public class DriverPaymentCalculator {
    public static double calculateTotalPaid(List<Driver> drivers, long paymentClearanceTime) {
        double totalPaid = 0.0;
        for (Driver driver : drivers) {
            totalPaid += driver.calculatePayment(paymentClearanceTime, false);
        }
        return totalPaid;
    }

    public static double calculateTotalUnpaid(List<Driver> drivers, long paymentClearanceTime) {
        double totalUnpaid = 0.0;
        for (Driver driver : drivers) {
            totalUnpaid += driver.calculatePayment(paymentClearanceTime, true) - driver.calculatePayment(paymentClearanceTime, false);
        }
        return totalUnpaid;
    }

    public static void main(String[] args) {
        // Example usage
        List<Delivery> driver1Deliveries = Arrays.asList(
                new Delivery("D1", "123 Main St", 1698742800000L), // October 31, 2023 12:00:00 AM GMT
                new Delivery("D2", "456 Elm St", 1698829200000L)  // November 1, 2023 12:00:00 AM GMT
        );
        Driver driver1 = new Driver("John", 15.0, driver1Deliveries);
        List<Delivery> driver2Deliveries = Arrays.asList(
                new Delivery("D3", "789 Oak St", 1698915600000L)  // November 2, 2023 12:00:00 AM GMT
        );
        Driver driver2 = new Driver("Jane", 20.0, driver2Deliveries);
        List<Driver> drivers = Arrays.asList(driver1, driver2);
        long paymentClearanceTime = 1698829200000L; // November 1, 2023 12:00:00 AM GMT

        double totalPaid = calculateTotalPaid(drivers, paymentClearanceTime);
        double totalUnpaid = calculateTotalUnpaid(drivers, paymentClearanceTime);

        System.out.println("Total paid: $" + totalPaid);
        System.out.println("Total unpaid: $" + totalUnpaid);
    }
}
