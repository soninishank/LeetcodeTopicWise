package Coding.PrefixSum;

import java.util.Random;

// https://leetcode.com/problems/random-pick-with-weight/
public class RandomPickWithWeight {
    Random rand;
    int[] prefixSum;
    int totalSum = 0;

    public RandomPickWithWeight(int[] w) {
        // Initialize the random object
        rand = new Random();
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
        // get totalSum
        totalSum = prefixSum[w.length - 1];
    }

    public int pickIndex() {
        // Generate a random integer in the range [1, totalSum]
        int target = rand.nextInt(totalSum) + 1; // +1 is added because last digit is excluded in rand.nextInt
        int low = 0, high = prefixSum.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] == target) return mid;
            if (prefixSum[mid] < target) { // if it's less than target , it is clear that we need to increase low
                low = mid + 1;
            } else {
                high = mid; // it means it might be a valid candidate
            }
        }
        return low; // you can return anything because low == high at this point
    }
}
