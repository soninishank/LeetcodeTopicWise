package Coding.Rippling;

import java.util.List;

public class Driver {
    private String name;
    private double hourlyRate;
    private List<Delivery> deliveries;

    public Driver(String name, double hourlyRate, List<Delivery> deliveries) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.deliveries = deliveries;
    }

    public double calculatePayment(long paymentClearanceTime, boolean includeUnpaid) {
        double payment = 0.0;
        for (Delivery delivery : deliveries) {
            if (includeUnpaid || delivery.deliveryTime <= paymentClearanceTime) {
                payment += hourlyRate; // Assuming each delivery takes 1 hour
            }
        }
        return payment;
    }
}
