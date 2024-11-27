package Coding.BinarySearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = nums.length - 1;
        // Means the array is not rotated itself
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prevIndex = (mid - 1 + length) % length;
            int nextIndex = (mid + 1) % length;
            // 3,4,5,1,2
            // 1 is smaller than both nextIndex and prevIndex
            if (nums[prevIndex] >= nums[mid] && nums[nextIndex] >= nums[mid]) {
                return nums[mid];
            } // let's assume nums[mid] is 2 and it is less than 3
            else if (nums[mid] < nums[0]) {
                high--;
            } else {
                low++;
            }
        }
        return -1;
    }
}
