package BinarySearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + length) % length;
            int next = (mid + 1) % length;
            if (nums[mid] <= nums[prev] && nums[next] >= nums[mid]) {
                return nums[mid];
            } else if (nums[mid] < nums[0]) {
                high--;
            } else {
                low++;
            }
        }
        return -1;
    }
}
