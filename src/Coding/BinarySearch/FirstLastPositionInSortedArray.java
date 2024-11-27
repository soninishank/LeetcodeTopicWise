package Coding.BinarySearch;

// same as binary search template
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = applyBinarySearch(nums, target, 0, nums.length - 1);
        int right = applyBinarySearchHigh(nums, target, 0, nums.length - 1);
        return new int[]{left, right};
    }

    private int applyBinarySearch(int[] nums, int target, int low, int high) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;
                high = mid - 1; // set high
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private int applyBinarySearchHigh(int[] nums, int target, int low, int high) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;
                low = mid + 1; // set low
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
