package Coding.BinarySearch;

// https://leetcode.com/problems/find-peak-element/
// https://leetcode.com/problems/find-peak-element/discuss/1290642/intuition-behind-conditions-complete-explanation-diagram-binary-search
// https://www.youtube.com/watch?v=a7D77DdhlFc
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0; // single element
        }
        int n = nums.length;
        // check if 0th/n-1th index is the peak element
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        // search in the remaining array
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) { // peak lies in left side
                high = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) { // peak lies in right side
                low = mid + 1;
            }
        }
        return -1; // dummy return statement
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int peakElement = new FindPeakElement().findPeakElement(nums);
        System.out.println(peakElement);
    }
}
