package Coding.BinarySearch;

// https://leetcode.com/problems/find-peak-element/
// https://leetcode.com/problems/find-peak-element/discuss/1290642/intuition-behind-conditions-complete-explanation-diagram-binary-search
// https://www.youtube.com/watch?v=a7D77DdhlFc
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0; // single element
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int peakElement = new FindPeakElement().findPeakElement(nums);
        System.out.println(peakElement);
    }
}


