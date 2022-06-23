package LLD.DesignPatterns.Behavioural.Strategy;

public class PhonePlayer extends VideoPlayer {

    public PhonePlayer(Device device, Resolution resolution) {
        this.currentDevice = device;
        this.currentResolution = resolution; // parent interface objects
    }

    @Override
    void display() {
        this.getDevice();
        this.getResolution();
    }
}
