package Meta;

import java.util.Random;

public class CityGenerator_RandomNoGenerator {

    private String[] cities;
    private int[] prefixSums;
    private Random random;
    private int totalSum;

    public CityGenerator_RandomNoGenerator(String[] cityNames, int[] cityPopulations) {
        int n = cityNames.length;
        cities = cityNames;
        prefixSums = new int[n];
        random = new Random();
        totalSum = 0;

        // Construct the prefix sum array - Compute the cumulative sum
        for (int i = 0; i < cityPopulations.length; i++) {
            totalSum += cityPopulations[i];
            prefixSums[i] = totalSum; // Example: prefix_sums = [7, 12, 20]
        }
    }

    public String getRandomCity() {
        int target = random.nextInt(totalSum); // Random number in range [0, totalSum - 1], it's just the index
        int left = 0, right = prefixSums.length - 1;

        // Binary search to find the target city
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] <= target) { // Note: target is 0-based
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return cities[left];
    }

    public static void main(String[] args) {
        String[] cityNames = {"NY", "SF", "LA"};
        int[] cityPopulations = {7, 5, 8};

        CityGenerator_RandomNoGenerator selector = new CityGenerator_RandomNoGenerator(cityNames, cityPopulations);

        // Test the random city selection
        for (int i = 0; i < 20; i++) {
            System.out.println(selector.getRandomCity());
        }
    }
}

