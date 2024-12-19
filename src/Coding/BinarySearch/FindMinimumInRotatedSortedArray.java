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

    // There is more easy way, it is exactly similar to find peak index in a mountain array
    // If the mid-element is greater than the rightmost element, the minimum must be in the right half.
    //     Otherwise, the minimum lies in the left half (including mid).
    public int findMinimum(int[] nums) {
        int low = 0, high = nums.length - 1;
        // Means the array is not rotated itself -  Check if the array is not rotated
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            // iska matlab abhi me highest position pe hu
            // 3 4 5 1 2
            // if nums[mid] is 5 it means I need to go in right side
            // If mid element is greater than the rightmost element,
            // the minimum is in the right part
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {            // Otherwise, the minimum is in the left part (including mid)
                high = mid;
            }
        }
        // At the end, left will point to the minimum element
        return nums[low];
    }
}
