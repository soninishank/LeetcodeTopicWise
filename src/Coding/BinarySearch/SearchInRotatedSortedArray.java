package Coding.BinarySearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
// It is similar as Minimum sorted array
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int midValue = findMinIndex(nums);
        if (midValue == -1) {
            return -1;
        }
        if (nums[midValue] == target) {
            return midValue;
        }
        int left = applyBinarySearch(nums, 0, midValue - 1, target);
        if (left != -1) {
            return left;
        }
        int right = applyBinarySearch(nums, midValue + 1, nums.length - 1, target);
        return right;
    }

    private int findMinIndex(int[] nums) {
        int low = 0, high = nums.length - 1;
        if (nums[low] < nums[high]) {
            return low;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int nextEle = (mid + 1) % nums.length;
            int prevEle = (mid - 1 + nums.length) % nums.length;
            if (nums[prevEle] >= nums[mid] && nums[mid] <= nums[nextEle]) {
                return mid;
            } else if (nums[mid] >= nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int applyBinarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // Very easy
    // 1. if nums[mid] == target -> return mid
    // 2. if nums[low] <= target < mid
    //           high = mid - 1
    //         else
    //            low = mid + 1
    // 3. if nums[mid] < target <= nums[high]
    //            low = mid + 1
    //          else
    //             high = mid - 1
    public int searchOnePass(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } // means target is between low and mid
            // than make high = mid-1 else low = mid+1;
            else if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
