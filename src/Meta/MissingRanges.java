package Meta;

// https://leetcode.com/discuss/interview-question/4376727/Meta-E4-Phone-Screen-(Rejected)
public class MissingRanges {
    public String findMissingRanges(int[] nums, int lower, int upper) {
        StringBuilder result = new StringBuilder();
        int n = nums.length;

        // Handle an edge case: empty array
        if (n == 0) {
            addRange(result, lower, upper);
            return result.toString();
        }

        // Check for missing numbers between lower bound and the first number
        if (lower < nums[0]) {
            addRange(result, lower, nums[0] - 1);
        }

        // Check for missing numbers between consecutive numbers
        for (int i = 0; i < n - 1; i++) {
            int currentElement = nums[i];
            int nextElement = nums[i + 1];
            if (nextElement - currentElement > 1) {
                addRange(result, currentElement + 1, nextElement - 1);
            }
        }

        // Check for missing numbers between the last number and the upper bound
        if (upper > nums[n - 1]) {
            addRange(result, nums[n - 1] + 1, upper);
        }

        return result.toString();
    }

    // Helper method to format and append ranges
    private void addRange(StringBuilder result, int start, int end) {
        if (result.length() > 0) {
            result.append(",");
        }
        if (start == end) {
            result.append(start);
        } else {
            result.append(start).append("-").append(end);
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 13, 20};
        MissingRanges solution = new MissingRanges();
        String output = solution.findMissingRanges(nums, 0, 99);
        System.out.println(output); // Output: "0,3,5,6,8-54,56-94,96-99"
    }
}
