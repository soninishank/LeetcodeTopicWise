package LLD.DesignPatterns.Behavioural.Strategy;

public class TVVideoPlayer extends VideoPlayer {

    public TVVideoPlayer(Device device, Resolution resolution) {
        this.currentDevice = device;
        this.currentResolution = resolution; // parent interface objects
    }

    @Override
    void display() {
        this.getDevice();
        this.getResolution();
    }
}
