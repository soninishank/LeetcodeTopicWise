package Coding.Amazon.DSA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LoyalCustomers {

    public static void main(String[] args) throws IOException {
        String day1LogFile = "day1.log";
        String day2LogFile = "day2.log";

        // Parse log files
        Map<String, Set<String>> day1Visits = parseLogFile(day1LogFile);
        Map<String, Set<String>> day2Visits = parseLogFile(day2LogFile);

        // Find loyal customers
        Set<String> loyalCustomers = findLoyalCustomers(day1Visits, day2Visits);

        // Print results
        System.out.println("Loyal Customers: " + loyalCustomers);
    }

    // Parses a log file and returns a map of CustomerId -> Set of PageIds
    private static Map<String, Set<String>> parseLogFile(String logFilePath) throws IOException {
        Map<String, Set<String>> customerVisits = new HashMap<>();
        // Read file line by line
        List<String> lines = Files.readAllLines(Paths.get(logFilePath));
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String timestamp = parts[0];
                String pageId = parts[1];
                String customerId = parts[2];
                // Add pageId to the customer's set of visited pages
                customerVisits.computeIfAbsent(customerId, k -> new HashSet<>()).add(pageId);
            }
        }
        return customerVisits;
    }

    // Finds customers who came on both days and visited at least two unique pages each day
    private static Set<String> findLoyalCustomers(Map<String, Set<String>> day1Visits, Map<String, Set<String>> day2Visits) {
        Set<String> loyalCustomers = new HashSet<>();

        for (String customerId : day1Visits.keySet()) {
            if (day2Visits.containsKey(customerId)) {
                Set<String> day1Pages = day1Visits.get(customerId);
                Set<String> day2Pages = day2Visits.get(customerId);
                // two unique pages
                if (day1Pages.size() >= 2 && day2Pages.size() >= 2) {
                    loyalCustomers.add(customerId);
                }
            }
        }
        return loyalCustomers;
    }
}
