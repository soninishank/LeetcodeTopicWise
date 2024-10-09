package Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhotographerService {
    private List<PhotographerProfile> profiles = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(PhotographerService.class.getName());

    public void addProfile(String name, String location, double rate, List<String> eventTypes) {
        PhotographerProfile profile = new PhotographerProfile(name, location, rate, eventTypes);
        profiles.add(profile);
        logger.log(Level.INFO, "Added profile: {0}", profile);
    }

    public List<PhotographerProfile> searchProfiles(String eventType, String location) {
        List<PhotographerProfile> results = new ArrayList<>();
        for (PhotographerProfile profile : profiles) {
            if (profile.getEventTypes().contains(eventType) && profile.getLocation().equalsIgnoreCase(location)) {
                results.add(profile);
            }
        }
        logger.log(Level.INFO, "Search for eventType='{0}' and location='{1}' returned {2} results",
                new Object[]{eventType, location, results.size()});
        return results;
    }

    public static void main(String[] args) {
        try {
            // Initialize the service
            PhotographerService photographerService = new PhotographerService();

            // Add sample profiles
            List<String> eventTypes1 = Arrays.asList("Wedding", "Rehearsal Dinner", "Bridal Shower");
            photographerService.addProfile("Dream Weddings", "San Jose, CA", 150, eventTypes1);

            List<String> eventTypes2 = Arrays.asList("Wedding", "Reception");
            photographerService.addProfile("Memorable Moments", "San Jose, CA", 180, eventTypes2);

            List<String> eventTypes3 = Arrays.asList("Wedding");
            photographerService.addProfile("Beautiful Weddings", "San Jose, CA", 100, eventTypes3);

            // Search for profiles
            String eventType = "Wedding";
            String location = "San Jose, CA";
            List<PhotographerProfile> results = photographerService.searchProfiles(eventType, location);

            // Print search results
            for (PhotographerProfile result : results) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
