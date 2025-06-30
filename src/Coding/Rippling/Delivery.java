package Coding.Rippling;

public class Delivery {
    private String deliveryId;
    private String destination;
    public long deliveryTime;

    public Delivery(String deliveryId, String destination, long deliveryTime) {
        this.deliveryId = deliveryId;
        this.destination = destination;
        this.deliveryTime = deliveryTime;
    }
}
