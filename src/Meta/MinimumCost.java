package Meta;

// https://leetcode.com/discuss/interview-question/4288566/E4-meta-phone-screen-qs
public class MinimumCost {
    public static int findMinCost(int[] departing, int[] returning) {
        // Edge case: Ensure arrays have valid lengths
        if (departing == null || returning == null || departing.length < 2 || returning.length < 2) {
            throw new IllegalArgumentException("Invalid input: Arrays must have at least two elements.");
        }
        if (departing.length != returning.length) {
            throw new IllegalArgumentException("Invalid input: Arrays must have the same length.");
        }
        int minDepartCost = Integer.MAX_VALUE;
        int minTotalCost = Integer.MAX_VALUE;

        for (int i = 0; i < departing.length - 1; i++) {
            minDepartCost = Math.min(minDepartCost, departing[i]);
            minTotalCost = Math.min(minTotalCost, returning[i + 1] + minDepartCost);
        }
        if (minTotalCost == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("No valid round trip possible with the given input.");
        }
        return minTotalCost;
    }

    public static void main(String[] args) {
        int[] departing = {1, 2, 3, 4};
        int[] returning = {4, 3, 2, 1};

        int result = findMinCost(departing, returning);

        System.out.println("The minimum cost for the round trip is " + result + ".");
    }
}
