package Coding;

import java.util.List;

public class PhotographerProfile {
    private String name;
    private String location;
    private double rate;
    private List<String> eventTypes;

    public PhotographerProfile(String name, String location, double rate, List<String> eventTypes) {
        this.name = name;
        this.location = location;
        this.rate = rate;
        this.eventTypes = eventTypes;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getEventTypes() {
        return eventTypes;
    }

    @Override
    public String toString() {
        return String.format("\"%s\", location=\"%s\", rate=$%.2f, eventTypes: %s",
                name, location, rate, String.join(", ", eventTypes));
    }
}
