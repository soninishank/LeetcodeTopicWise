package LLD.DesignPatterns.Behavioural.Strategy;

public abstract class VideoPlayer {
    Device currentDevice;
    Resolution currentResolution;

    abstract void display();

    void getDevice() {
        currentDevice.device();
    }

    void getResolution()
    {
        currentResolution.resolution();
    }
}
